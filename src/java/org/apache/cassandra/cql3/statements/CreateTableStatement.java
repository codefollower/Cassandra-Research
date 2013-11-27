/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.cql3.statements;

import java.nio.ByteBuffer;
import java.util.*;

import org.apache.cassandra.exceptions.*;
import org.apache.commons.lang3.StringUtils;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import org.apache.cassandra.auth.Permission;
import org.apache.cassandra.config.ColumnDefinition;
import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.Schema;
import org.apache.cassandra.cql3.*;
import org.apache.cassandra.db.ColumnFamilyType;
import org.apache.cassandra.db.marshal.*;
import org.apache.cassandra.exceptions.AlreadyExistsException;
import org.apache.cassandra.io.compress.CompressionParameters;
import org.apache.cassandra.service.ClientState;
import org.apache.cassandra.service.MigrationManager;
import org.apache.cassandra.thrift.CqlResult;
import org.apache.cassandra.transport.messages.ResultMessage;
import org.apache.cassandra.utils.ByteBufferUtil;

/** A <code>CREATE TABLE</code> parsed from a CQL query statement. */
public class CreateTableStatement extends SchemaAlteringStatement
{
    public AbstractType<?> comparator; //用于clustering key
    private AbstractType<?> defaultValidator; //第一个非partition key和clustering key字段类型(按定义顺序)
    private AbstractType<?> keyValidator; //用于partition key

    private final List<ByteBuffer> keyAliases = new ArrayList<ByteBuffer>();
    private final List<ByteBuffer> columnAliases = new ArrayList<ByteBuffer>();
    private ByteBuffer valueAlias; //使用CompactStorage时第一个并且只有一个非partition key和clustering key字段名

    private final Map<ColumnIdentifier, AbstractType> columns = new HashMap<ColumnIdentifier, AbstractType>();
    private final CFPropDefs properties;
    private final boolean ifNotExists;

    public CreateTableStatement(CFName name, CFPropDefs properties, boolean ifNotExists)
    {
        super(name);
        this.properties = properties;
        this.ifNotExists = ifNotExists;

        try
        {
            //如果没指定compression属性，则默认使用org.apache.cassandra.io.compress.LZ4Compressor
            if (!this.properties.hasProperty(CFPropDefs.KW_COMPRESSION) && CFMetaData.DEFAULT_COMPRESSOR != null)
                //注意compression属性对应的是一个Map不是一个字符串
                this.properties.addProperty(CFPropDefs.KW_COMPRESSION,
                                            new HashMap<String, String>()
                                            {{
                                                put(CompressionParameters.SSTABLE_COMPRESSION, CFMetaData.DEFAULT_COMPRESSOR);
                                            }});
        }
        catch (SyntaxException e)
        {
            throw new AssertionError(e);
        }
    }

    public void checkAccess(ClientState state) throws UnauthorizedException, InvalidRequestException
    {
        state.hasKeyspaceAccess(keyspace(), Permission.CREATE);
    }

    public void validate(ClientState state)
    {
        // validated in announceMigration()
    }

    // Column definitions
    private Map<ByteBuffer, ColumnDefinition> getColumns(CFMetaData cfm)
    {
        Map<ByteBuffer, ColumnDefinition> columnDefs = new HashMap<ByteBuffer, ColumnDefinition>();
        Integer componentIndex = null;
        if (cfm.hasCompositeComparator())
        {
            CompositeType ct = (CompositeType) comparator;
            //非CollectionType类型的最后一个字段的位置
            componentIndex = ct.types.get(ct.types.size() - 1) instanceof ColumnToCollectionType
                           ? ct.types.size() - 2
                           : ct.types.size() - 1;
        }

        for (Map.Entry<ColumnIdentifier, AbstractType> col : columns.entrySet())
        {
            columnDefs.put(col.getKey().bytes, ColumnDefinition.regularDef(cfm, col.getKey().bytes, col.getValue(), componentIndex));
        }

        return columnDefs;
    }

    public void announceMigration() throws RequestValidationException
    {
        try
        {
           MigrationManager.announceNewColumnFamily(getCFMetaData());
        }
        catch (AlreadyExistsException e)
        {
            if (!ifNotExists)
                throw e;
        }
    }

    public ResultMessage.SchemaChange.Change changeType()
    {
        return ResultMessage.SchemaChange.Change.CREATED;
    }

    /**
     * Returns a CFMetaData instance based on the parameters parsed from this
     * <code>CREATE</code> statement, or defaults where applicable.
     *
     * @return a CFMetaData instance corresponding to the values parsed from this statement
     * @throws InvalidRequestException on failure to validate parsed parameters
     */
    public CFMetaData getCFMetaData() throws RequestValidationException
    {
        CFMetaData newCFMD;
        newCFMD = new CFMetaData(keyspace(),
                                 columnFamily(),
                                 ColumnFamilyType.Standard,
                                 comparator,
                                 null);
        applyPropertiesTo(newCFMD);
        return newCFMD;
    }

    public void applyPropertiesTo(CFMetaData cfmd) throws RequestValidationException
    {
        cfmd.defaultValidator(defaultValidator)
            .keyValidator(keyValidator)
            .columnMetadata(getColumns(cfmd));

        cfmd.addColumnMetadataFromAliases(keyAliases, keyValidator, ColumnDefinition.Kind.PARTITION_KEY);
        cfmd.addColumnMetadataFromAliases(columnAliases, comparator, ColumnDefinition.Kind.CLUSTERING_COLUMN);
        //只有useCompactStorage为true且columnAliases不为empty时valueAlias才可能不为null
        if (valueAlias != null)
            cfmd.addColumnMetadataFromAliases(Collections.<ByteBuffer>singletonList(valueAlias), defaultValidator, ColumnDefinition.Kind.COMPACT_VALUE);

        properties.applyToCFMetadata(cfmd);
    }

    /*
          对于这样的CQL:
    CREATE TABLE test (
       table_name text,
       index_name text,
       index_name2 text,
       PRIMARY KEY (table_name, index_name)
    )WITH CLUSTERING ORDER BY (index_name DESC, index_name2 ASC) 
     AND COMPACT STORAGE AND COMMENT='indexes that have been completed'");

    keyAliases是table_name
    columnAliases是index_name
    definedOrdering是index_name, index_name2，其中index_name的reversed是true，index_name2是false
    useCompactStorage是true
    properties是COMMENT(通过org.apache.cassandra.cql3.PropertyDefinitions.addProperty(String, String)增加)
    
          如果PRIMARY KEY是PRIMARY KEY ((table_name,index_name2), index_name)
          则keyAliases是(table_name,index_name2)
    */
    public static class RawStatement extends CFStatement
    {
        private final Map<ColumnIdentifier, CQL3Type> definitions = new HashMap<ColumnIdentifier, CQL3Type>();
        //在org.apache.cassandra.cql3.CqlParser.cfamProperty(RawStatement)中把属性解析后放到properties字段中
        public final CFPropDefs properties = new CFPropDefs();
        //如CREATE TABLE IF NOT EXISTS Cats0 ( block_id uuid PRIMARY KEY, breed text, color text, short_hair boolean,"
        //+ "PRIMARY KEY ((block_id, breed), color, short_hair))
        //此时keyAliases.size是2，
        //其中keyAliases[0]是block_id
        //keyAliases[1]是(block_id, breed)
        //这在语法解析阶段是允许的，但是在CreateTableStatement.RawStatement.prepare()中才抛错，只需要keyAliases.size是1
        
        //每个表必须有主键，并且只能有一个
        //这个是错误的: CREATE TABLE IF NOT EXISTS Cats00 ( block_id uuid, breed text, color text, short_hair boolean)
        private final List<List<ColumnIdentifier>> keyAliases = new ArrayList<List<ColumnIdentifier>>();
        private final List<ColumnIdentifier> columnAliases = new ArrayList<ColumnIdentifier>();
        private final Map<ColumnIdentifier, Boolean> definedOrdering = new LinkedHashMap<ColumnIdentifier, Boolean>(); // Insertion ordering is important

        private boolean useCompactStorage;
        //允许相同的元素出现多个(按元素的hash值确定)
        //用来检查是否定义了多个同名的字段
        private final Multiset<ColumnIdentifier> definedNames = HashMultiset.create(1);

        private final boolean ifNotExists;

        public RawStatement(CFName name, boolean ifNotExists)
        {
            super(name);
            this.ifNotExists = ifNotExists;
        }

        /**
         * Transform this raw statement into a CreateTableStatement.
         */
        //参见my.test.cql3.statements.CreateTableStatementTest的测试
        public ParsedStatement.Prepared prepare() throws RequestValidationException
        {
            // Column family name
            //列族名就是表名，必须是有效的标识符
            //(TODO 无法在这重现这个场景, org.apache.cassandra.cql3.CqlParser中如果发现不合法会提前抛异常了)
            if (!columnFamily().matches("\\w+"))
                throw new InvalidRequestException(String.format("\"%s\" is not a valid column family name (must be alphanumeric character only: [0-9A-Za-z]+)", columnFamily()));
            //列族名就是表名，不能超过48个字符
            if (columnFamily().length() > Schema.NAME_LENGTH)
                throw new InvalidRequestException(String.format("Column family names shouldn't be more than %s characters long (got \"%s\")", Schema.NAME_LENGTH, columnFamily()));

            //定义了重复的字段
            for (Multiset.Entry<ColumnIdentifier> entry : definedNames.entrySet())
                if (entry.getCount() > 1)
                    throw new InvalidRequestException(String.format("Multiple definition of identifier %s", entry.getElement()));

            //验证是否是支持的属性
            //这样的用法是错误的:  WITH min_threshold=2 (Unknown property 'min_threshold')
            properties.validate();

            CreateTableStatement stmt = new CreateTableStatement(cfName, properties, ifNotExists);

            //以下代码用于确定stmt.columns的值
            ///////////////////////////////////////////////////////////////////////////
            Map<ByteBuffer, CollectionType> definedCollections = null;
            for (Map.Entry<ColumnIdentifier, CQL3Type> entry : definitions.entrySet())
            {
                ColumnIdentifier id = entry.getKey();
                CQL3Type pt = entry.getValue();
                if (pt.isCollection())
                {
                    if (definedCollections == null)
                        definedCollections = new HashMap<ByteBuffer, CollectionType>();
                    definedCollections.put(id.bytes, (CollectionType)pt.getType());
                }
                stmt.columns.put(id, pt.getType()); // we'll remove what is not a column below
            }


            //以下代码用于确定stmt.keyAliases和stmt.keyValidator的值(处理partition key)
            ///////////////////////////////////////////////////////////////////////////
            
            //每个表必须有主键，并且只能有一个
            if (keyAliases.isEmpty())
                throw new InvalidRequestException("No PRIMARY KEY specifed (exactly one required)");
            else if (keyAliases.size() > 1)
                throw new InvalidRequestException("Multiple PRIMARY KEYs specifed (exactly one required)");

            List<ColumnIdentifier> kAliases = keyAliases.get(0);

            List<AbstractType<?>> keyTypes = new ArrayList<AbstractType<?>>(kAliases.size());
            for (ColumnIdentifier alias : kAliases)
            {
                stmt.keyAliases.add(alias.bytes);
                //通过PRIMARY KEY定义的部分，
                //例如: PRIMARY KEY ((block_id, breed), color, short_hair)
                //PRIMARY KEY由partition key和clustering key组成，
                //其中(block_id, breed)是partition key，而(color, short_hair)是clustering key
                //因为(block_id, breed)由大于1个字段组成，所以又叫composite partition key
                //getTypeAndRemove就是用来检查partition key和clustering key的，这两种key中的字段类型不能是CollectionType
                
                //另外，此类的keyAliases对应partition key，而columnAliases对应clustering key
                AbstractType<?> t = getTypeAndRemove(stmt.columns, alias);
                //主键字段不能是counter类型
                //例如这样是不行的: block_id counter PRIMARY KEY
                //但是配合使用CLUSTERING ORDER BY时，
                //如
                //CREATE TABLE IF NOT EXISTS test( block_id counter PRIMARY KEY, breed text) 
                //WITH CLUSTERING ORDER BY (block_id DESC)
                //此时getTypeAndRemove返回的是ReversedType，所以可以绕过这个异常，但是在后面的definedOrdering检查中还是会抛出异常
                //这个bug碰巧解决了
                if (t instanceof CounterColumnType)
                    throw new InvalidRequestException(String.format("counter type is not supported for PRIMARY KEY part %s", alias));
                keyTypes.add(t);
            }
            stmt.keyValidator = keyTypes.size() == 1 ? keyTypes.get(0) : CompositeType.getInstance(keyTypes);


            //以下代码用于确定stmt.comparator和stmt.columnAliases的值(处理clustering key)
            ///////////////////////////////////////////////////////////////////////////
            // Handle column aliases
            if (columnAliases.isEmpty())
            {
                if (useCompactStorage)
                {
                    // There should remain some column definition since it is a non-composite "static" CF
                    if (stmt.columns.isEmpty())
                        throw new InvalidRequestException("No definition found that is not part of the PRIMARY KEY");

                    if (definedCollections != null)
                        throw new InvalidRequestException("Collection types are not supported with COMPACT STORAGE");

                    stmt.comparator = UTF8Type.instance;
                }
                else
                {
                    //如: CREATE TABLE test
                    //+ " ( block_id uuid, breed text, short_hair boolean, emails set<text>," //
                    //+ " PRIMARY KEY ((block_id, breed)))
                    //此时stmt.comparator是一个CompositeType(包含UTF8Type和ColumnToCollectionType)
                    List<AbstractType<?>> types = new ArrayList<AbstractType<?>>(definedCollections == null ? 1 : 2);
                    types.add(UTF8Type.instance);
                    if (definedCollections != null)
                        types.add(ColumnToCollectionType.getInstance(definedCollections));
                    stmt.comparator = CompositeType.getInstance(types);
                }
            }
            else
            {
                // If we use compact storage and have only one alias, it is a
                // standard "dynamic" CF, otherwise it's a composite
                if (useCompactStorage && columnAliases.size() == 1)
                {
                    if (definedCollections != null)
                        throw new InvalidRequestException("Collection types are not supported with COMPACT STORAGE");
                    stmt.columnAliases.add(columnAliases.get(0).bytes);
                    stmt.comparator = getTypeAndRemove(stmt.columns, columnAliases.get(0));
                    if (stmt.comparator instanceof CounterColumnType)
                        throw new InvalidRequestException(String.format("counter type is not supported for PRIMARY KEY part %s", stmt.columnAliases.get(0)));
                }
                else
                {
                    List<AbstractType<?>> types = new ArrayList<AbstractType<?>>(columnAliases.size() + 1);
                    for (ColumnIdentifier t : columnAliases)
                    {
                        stmt.columnAliases.add(t.bytes);

                        AbstractType<?> type = getTypeAndRemove(stmt.columns, t);
                        if (type instanceof CounterColumnType)
                            throw new InvalidRequestException(String.format("counter type is not supported for PRIMARY KEY part %s", t));
                        types.add(type);
                    }

                    if (useCompactStorage)
                    {
                        if (definedCollections != null)
                            throw new InvalidRequestException("Collection types are not supported with COMPACT STORAGE");
                    }
                    else
                    {
                        // For sparse, we must add the last UTF8 component
                        // and the collection type if there is one
                        types.add(UTF8Type.instance);
                        if (definedCollections != null)
                            types.add(ColumnToCollectionType.getInstance(definedCollections));
                    }

                    //types不可能为empty
                    if (types.isEmpty())
                        throw new IllegalStateException("Nonsensical empty parameter list for CompositeType");
                    stmt.comparator = CompositeType.getInstance(types);
                }
            }

            
            //以下代码用于确定stmt.defaultValidator和stmt.valueAlias的值
            ///////////////////////////////////////////////////////////////////////////
            if (useCompactStorage && !stmt.columnAliases.isEmpty())
            {
                if (stmt.columns.isEmpty())
                {
                    // The only value we'll insert will be the empty one, so the default validator don't matter
                    stmt.defaultValidator = BytesType.instance;
                    // We need to distinguish between
                    //   * I'm upgrading from thrift so the valueAlias is null
                    //   * I've defined my table with only a PK (and the column value will be empty)
                    // So, we use an empty valueAlias (rather than null) for the second case
                    stmt.valueAlias = ByteBufferUtil.EMPTY_BYTE_BUFFER;
                }
                else
                {
                    if (stmt.columns.size() > 1)
                        throw new InvalidRequestException(String.format("COMPACT STORAGE with composite PRIMARY KEY allows no more than one column not part of the PRIMARY KEY (got: %s)", StringUtils.join(stmt.columns.keySet(), ", ")));
                    //使用最后那个字段
                    //如:
                    //CREATE TABLE IF NOT EXISTS " + tableName
                    //  (block_id uuid, breed text, short_hair boolean, f1 text"
                    //   PRIMARY KEY ((block_id, breed), short_hair)) WITH COMPACT STORAGE");
                    //则defaultValidator是text
                    //valueAlias是f1
                    Map.Entry<ColumnIdentifier, AbstractType> lastEntry = stmt.columns.entrySet().iterator().next();
                    stmt.defaultValidator = lastEntry.getValue();
                    stmt.valueAlias = lastEntry.getKey().bytes;
                    stmt.columns.remove(lastEntry.getKey()); //stmt.columns之后就空了
                }
            }
            else
            {
                // For compact, we are in the "static" case, so we need at least one column defined. For non-compact however, having
                // just the PK is fine since we have CQL3 row marker.
                if (useCompactStorage && stmt.columns.isEmpty())
                    throw new InvalidRequestException("COMPACT STORAGE with non-composite PRIMARY KEY require one column not part of the PRIMARY KEY, none given");

                // There is no way to insert/access a column that is not defined for non-compact storage, so
                // the actual validator don't matter much (except that we want to recognize counter CF as limitation apply to them).
                stmt.defaultValidator = !stmt.columns.isEmpty() && (stmt.columns.values().iterator().next() instanceof CounterColumnType)
                    ? CounterColumnType.instance
                    : BytesType.instance;
            }

            
            
            //以下代码用于检查CLUSTERING ORDER子句是否合法
            ///////////////////////////////////////////////////////////////////////////
            //CLUSTERING ORDER中的字段只能是clustering key包含的字段
            // If we give a clustering order, we must explicitly do so for all aliases and in the order of the PK
            if (!definedOrdering.isEmpty())
            {
                if (definedOrdering.size() > columnAliases.size())
                    throw new InvalidRequestException("Only clustering key columns can be defined in CLUSTERING ORDER directive");

                int i = 0;
                for (ColumnIdentifier id : definedOrdering.keySet())
                {
                    ColumnIdentifier c = columnAliases.get(i);
                    if (!id.equals(c))
                    {
                        //排序key中的字段与clustering key中的字段顺序必须一样
                        if (definedOrdering.containsKey(c))
                            throw new InvalidRequestException(String.format("The order of columns in the CLUSTERING ORDER directive must be the one of the clustering key (%s must appear before %s)", c, id));
                        else //排序key中的字段必须是clustering key中的字段
                            throw new InvalidRequestException(String.format("Missing CLUSTERING ORDER for column %s", c));
                    }
                    ++i;
                }
            }

            return new ParsedStatement.Prepared(stmt);
        }

        //PRIMARY KEY字段是partition key和clustering key的统称
        //这个方法其实就是用来检查partition key和clustering key中的字段(类型不能是CollectionType)
        //并且从org.apache.cassandra.cql3.statements.CreateTableStatement.columns中删除这些PRIMARY KEY字段
        private AbstractType<?> getTypeAndRemove(Map<ColumnIdentifier, AbstractType> columns, ColumnIdentifier t) throws InvalidRequestException
        {
            AbstractType type = columns.get(t);
            if (type == null)
                throw new InvalidRequestException(String.format("Unknown definition %s referenced in PRIMARY KEY", t));
            if (type instanceof CollectionType)
                throw new InvalidRequestException(String.format("Invalid collection type for PRIMARY KEY component %s", t));

            columns.remove(t);
            Boolean isReversed = definedOrdering.get(t);
            return isReversed != null && isReversed ? ReversedType.getInstance(type) : type;
        }

        //definitions中会有keyAliases和columnAliases的内容，
        //在prepare方法中会进行处理
        public void addDefinition(ColumnIdentifier def, CQL3Type type)
        {
            definedNames.add(def);
            definitions.put(def, type);
        }
 
        //partition key可能由一个或多个字段构成，所以用List<ColumnIdentifier>
        //语法分析阶段可以出现多次PRIMARY KEY，当运行到prepare方法时才检查，
        //所以keyAliases的类型是List<List<ColumnIdentifier>>
        public void addKeyAliases(List<ColumnIdentifier> aliases)
        {
            keyAliases.add(aliases);
        }

        public void addColumnAlias(ColumnIdentifier alias)
        {
            columnAliases.add(alias);
        }

        public void setOrdering(ColumnIdentifier alias, boolean reversed)
        {
            definedOrdering.put(alias, reversed);
        }

        public void setCompactStorage()
        {
            useCompactStorage = true;
        }

        //没用到，多余的
        public void checkAccess(ClientState state)
        {
            throw new UnsupportedOperationException();
        }

        //没用到，多余的
        public CqlResult execute(ClientState state, List<ByteBuffer> variables)
        {
            throw new UnsupportedOperationException();
        }
    }
}
