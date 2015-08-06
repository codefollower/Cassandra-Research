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
package org.apache.cassandra.config;

import java.nio.ByteBuffer;
import java.util.*;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import org.apache.cassandra.cql3.*;
import org.apache.cassandra.db.rows.*;
import org.apache.cassandra.db.marshal.*;
import org.apache.cassandra.serializers.MarshalException;
import org.apache.cassandra.exceptions.*;

public class ColumnDefinition extends ColumnSpecification implements Comparable<ColumnDefinition>
{
//<<<<<<< HEAD
////<<<<<<< HEAD
////    // system.schema_columns column names
////    /*
////    CREATE TABLE schema_columns (
////            //这4个对应超类ColumnSpecification中的4个字段
////            keyspace_name text,
////            columnfamily_name text,
////            column_name text,
////            validator text,
////            //这4个对应此类的5个字段
////            index_type text,
////            index_options text,
////            index_name text,
////            component_index int,
////            type text, //对应ColumnDefinition.kind字段
////            PRIMARY KEY(keyspace_name, columnfamily_name, column_name)
////        ) WITH COMMENT='ColumnFamily column attributes' AND gc_grace_seconds=8640
////    */
////    //下面7个字段就对应schema_columns中的后7个字段名
////    private static final String COLUMN_NAME = "column_name";
////    private static final String TYPE = "validator"; //其实就是字段的类型，使用validator这名字一点都不直观
////    private static final String INDEX_TYPE = "index_type"; //对应org.apache.cassandra.config.IndexType
////    private static final String INDEX_OPTIONS = "index_options";
////    private static final String INDEX_NAME = "index_name";
////    private static final String COMPONENT_INDEX = "component_index";
////    private static final String KIND = "type"; //对应枚举类型ColumnDefinition.Kind
////
////=======
////>>>>>>> bf599fb5b062cbcc652da78b7d699e7a01b949ad
//=======
    public static final Comparator<Object> asymmetricColumnDataComparator = (a, b) -> ((ColumnData) a).column().compareTo((ColumnDefinition) b);
    /*
     * The type of CQL3 column this definition represents.
     * There is 4 main type of CQL3 columns: those parts of the partition key,
     * those parts of the clustering columns and amongst the others, regular and
     * static ones.
     *
     * Note that thrift only knows about definitions of type REGULAR (and
     * the ones whose componentIndex == null).
     */
    public enum Kind
    {
        PARTITION_KEY,
        CLUSTERING,
        REGULAR,
        STATIC;

        public boolean isPrimaryKeyKind()
        {
            return this == PARTITION_KEY || this == CLUSTERING;
        }

    }

    //超类ColumnSpecification有4个字段，此类有5个字段，刚好9个，刚好对应system.schema_columns表中的9个字段
    public final Kind kind;

    private String indexName;
    private IndexType indexType;
    private Map<String,String> indexOptions;

    /*
     * If the column comparator is a composite type, indicates to which
     * component this definition refers to. If null, the definition refers to
     * the full column name.
     */
    private final Integer componentIndex;

    private final Comparator<CellPath> cellPathComparator;
    private final Comparator<Object> asymmetricCellPathComparator;
    private final Comparator<? super Cell> cellComparator;

    /**
     * These objects are compared frequently, so we encode several of their comparison components
     * into a single int value so that this can be done efficiently
     */
    private final int comparisonOrder;

    private static int comparisonOrder(Kind kind, boolean isComplex, int position)
    {
        return (kind.ordinal() << 28) | (isComplex ? 1 << 27 : 0) | position;
    }

    public static ColumnDefinition partitionKeyDef(CFMetaData cfm, ByteBuffer name, AbstractType<?> validator, Integer componentIndex)
    {
        return new ColumnDefinition(cfm, name, validator, componentIndex, Kind.PARTITION_KEY);
    }

    public static ColumnDefinition partitionKeyDef(String ksName, String cfName, String name, AbstractType<?> validator, Integer componentIndex)
    {
        return new ColumnDefinition(ksName, cfName, ColumnIdentifier.getInterned(name, true), validator, null, null, null, componentIndex, Kind.PARTITION_KEY);
    }

    public static ColumnDefinition clusteringKeyDef(CFMetaData cfm, ByteBuffer name, AbstractType<?> validator, Integer componentIndex)
    {
        return new ColumnDefinition(cfm, name, validator, componentIndex, Kind.CLUSTERING);
    }

    public static ColumnDefinition clusteringKeyDef(String ksName, String cfName, String name, AbstractType<?> validator, Integer componentIndex)
    {
        return new ColumnDefinition(ksName, cfName, ColumnIdentifier.getInterned(name, true),  validator, null, null, null, componentIndex, Kind.CLUSTERING);
    }

    public static ColumnDefinition regularDef(CFMetaData cfm, ByteBuffer name, AbstractType<?> validator)
    {
        return new ColumnDefinition(cfm, name, validator, null, Kind.REGULAR);
    }

    public static ColumnDefinition regularDef(String ksName, String cfName, String name, AbstractType<?> validator)
    {
        return new ColumnDefinition(ksName, cfName, ColumnIdentifier.getInterned(name, true), validator, null, null, null, null, Kind.REGULAR);
    }

    public static ColumnDefinition staticDef(CFMetaData cfm, ByteBuffer name, AbstractType<?> validator)
    {
        return new ColumnDefinition(cfm, name, validator, null, Kind.STATIC);
    }

    public ColumnDefinition(CFMetaData cfm, ByteBuffer name, AbstractType<?> validator, Integer componentIndex, Kind kind)
    {
        this(cfm.ksName,
             cfm.cfName,
//<<<<<<< HEAD
//             //cfm.getComponentComparator(componentIndex, kind)返回的值用于生成字段名的字符串形式
//             //见org.apache.cassandra.cql3.statements.CreateTableStatement.getColumns(CFMetaData)中的注释
//             new ColumnIdentifier(name, cfm.getComponentComparator(componentIndex, kind)),
//=======
             ColumnIdentifier.getInterned(name, cfm.getColumnDefinitionNameComparator(kind)),
             validator,
             null,
             null,
             null,
             componentIndex,
             kind);
    }

    public ColumnDefinition(String ksName, String cfName, ColumnIdentifier name, AbstractType<?> type, Integer componentIndex, Kind kind)
    {
        this(ksName, cfName, name, type, null, null, null, componentIndex, kind);
    }

    @VisibleForTesting
    public ColumnDefinition(String ksName,
                            String cfName,
                            ColumnIdentifier name,
                            AbstractType<?> validator,
                            IndexType indexType,
                            Map<String, String> indexOptions,
                            String indexName,
                            Integer componentIndex,
                            Kind kind)
    {
        super(ksName, cfName, name, validator);
        assert name != null && validator != null && kind != null;
        assert name.isInterned();
        assert componentIndex == null || kind.isPrimaryKeyKind(); // The componentIndex really only make sense for partition and clustering columns,
                                                                  // so make sure we don't sneak it for something else since it'd breaks equals()
        this.kind = kind;
        this.indexName = indexName;
        this.componentIndex = componentIndex;
        this.setIndexType(indexType, indexOptions);
        this.cellPathComparator = makeCellPathComparator(kind, validator);
        this.cellComparator = cellPathComparator == null ? ColumnData.comparator : (a, b) -> cellPathComparator.compare(a.path(), b.path());
        this.asymmetricCellPathComparator = cellPathComparator == null ? null : (a, b) -> cellPathComparator.compare(((Cell)a).path(), (CellPath) b);
        this.comparisonOrder = comparisonOrder(kind, isComplex(), position());
    }

    private static Comparator<CellPath> makeCellPathComparator(Kind kind, AbstractType<?> validator)
    {
        if (kind.isPrimaryKeyKind() || !validator.isCollection() || !validator.isMultiCell())
            return null;

        final CollectionType type = (CollectionType)validator;
        return new Comparator<CellPath>()
        {
            public int compare(CellPath path1, CellPath path2)
            {
                if (path1.size() == 0 || path2.size() == 0)
                {
                    if (path1 == CellPath.BOTTOM)
                        return path2 == CellPath.BOTTOM ? 0 : -1;
                    if (path1 == CellPath.TOP)
                        return path2 == CellPath.TOP ? 0 : 1;
                    return path2 == CellPath.BOTTOM ? 1 : -1;
                }

                // This will get more complicated once we have non-frozen UDT and nested collections
                assert path1.size() == 1 && path2.size() == 1;
                return type.nameComparator().compare(path1.get(0), path2.get(0));
            }
        };
    }

    public ColumnDefinition copy()
    {
        return new ColumnDefinition(ksName, cfName, name, type, indexType, indexOptions, indexName, componentIndex, kind);
    }

    public ColumnDefinition withNewName(ColumnIdentifier newName)
    {
        return new ColumnDefinition(ksName, cfName, newName, type, indexType, indexOptions, indexName, componentIndex, kind);
    }

    public ColumnDefinition withNewType(AbstractType<?> newType)
    {
        return new ColumnDefinition(ksName, cfName, name, newType, indexType, indexOptions, indexName, componentIndex, kind);
    }

    //SimpleSparseCellNameType和SimpleDenseCellNameType的情况componentIndex是null
    public boolean isOnAllComponents()
    {
        return componentIndex == null; //例如PARTITION_KEY中只包含一个字段时，或者COMPACT_VALUE的情况也是null
    }

    public boolean isPartitionKey()
    {
        return kind == Kind.PARTITION_KEY;
    }

    public boolean isClusteringColumn()
    {
        return kind == Kind.CLUSTERING;
    }

    public boolean isStatic()
    {
        return kind == Kind.STATIC;
    }

    public boolean isRegular()
    {
        return kind == Kind.REGULAR;
    }

    // The componentIndex. This never return null however for convenience sake:
    // if componentIndex == null, this return 0. So caller should first check
    // isOnAllComponents() to distinguish if that's a possibility.
    public int position()
    {
        return componentIndex == null ? 0 : componentIndex;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;

        if (!(o instanceof ColumnDefinition))
            return false;

        ColumnDefinition cd = (ColumnDefinition) o;

        return Objects.equal(ksName, cd.ksName)
            && Objects.equal(cfName, cd.cfName)
            && Objects.equal(name, cd.name)
            && Objects.equal(type, cd.type)
            && Objects.equal(kind, cd.kind)
            && Objects.equal(componentIndex, cd.componentIndex)
            && Objects.equal(indexName, cd.indexName)
            && Objects.equal(indexType, cd.indexType)
            && Objects.equal(indexOptions, cd.indexOptions);
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(ksName, cfName, name, type, kind, componentIndex, indexName, indexType, indexOptions);
    }

    @Override
    public String toString()
    {
//        return Objects.toStringHelper(this)
//                      .add("name", name)
//                      .add("type", type)
//                      .add("kind", kind)
//                      .add("componentIndex", componentIndex)
//                      .add("indexName", indexName)
//                      .add("indexType", indexType)
//                      .toString();
        
        return Objects.toStringHelper(this)
                .add("name", name)
                .toString();
    }

    public boolean isPrimaryKeyColumn()
    {
        return kind.isPrimaryKeyKind();
    }

    /**
     * Whether the name of this definition is serialized in the cell nane, i.e. whether
     * it's not just a non-stored CQL metadata.
     */
    public boolean isPartOfCellName(boolean isCQL3Table, boolean isSuper)
    {
        // When converting CQL3 tables to thrift, any regular or static column ends up in the cell name.
        // When it's a compact table however, the REGULAR definition is the name for the cell value of "dynamic"
        // column (so it's not part of the cell name) and it's static columns that ends up in the cell name.
        if (isCQL3Table)
            return kind == Kind.REGULAR || kind == Kind.STATIC;
        else if (isSuper)
            return kind == Kind.REGULAR;
        else
            return kind == Kind.STATIC;
    }

//<<<<<<< HEAD
//    /**
//     * Drop specified column from the schema using given mutation.
//     *
//     * @param mutation  The schema mutation
//     * @param timestamp The timestamp to use for column modification
//     */
//    public void deleteFromSchema(Mutation mutation, long timestamp)
//    {
//        ColumnFamily cf = mutation.addOrGet(SystemKeyspace.SchemaColumnsTable);
//        int ldt = (int) (System.currentTimeMillis() / 1000);
//
//        // Note: we do want to use name.toString(), not name.bytes directly for backward compatibility (For CQL3, this won't make a difference).
//        Composite prefix = SystemKeyspace.SchemaColumnsTable.comparator.make(cfName, name.toString());
//        cf.addAtom(new RangeTombstone(prefix, prefix.end(), timestamp, ldt));
//    }
//
//    //每一个字段对应schema_columns表中的一条记录
//    public void toSchema(Mutation mutation, long timestamp)
//    {
//        ColumnFamily cf = mutation.addOrGet(SystemKeyspace.SchemaColumnsTable);
//        Composite prefix = SystemKeyspace.SchemaColumnsTable.comparator.make(cfName, name.toString());
//        CFRowAdder adder = new CFRowAdder(cf, prefix, timestamp);
//
//        //对应schema_columns表除keyspace_name和columnfamily_name、column_name之外的6个普通字段
//        //keyspace_name字段是PARTITION_KEY，
//        //而columnfamily_name、column_name字段是CLUSTERING_COLUMN
//        //columnfamily_name、column_name这两个字段的值串接后会加到每个普通字段名之前
//        adder.add(TYPE, type.toString());
//        adder.add(INDEX_TYPE, indexType == null ? null : indexType.toString());
//        adder.add(INDEX_OPTIONS, json(indexOptions));
//        adder.add(INDEX_NAME, indexName);
//        adder.add(COMPONENT_INDEX, componentIndex);
//        adder.add(KIND, kind.serialize());
//        cf.toString();
//    }
//
//=======
//>>>>>>> bf599fb5b062cbcc652da78b7d699e7a01b949ad
    public ColumnDefinition apply(ColumnDefinition def)  throws ConfigurationException
    {
        assert kind == def.kind && Objects.equal(componentIndex, def.componentIndex);

        if (getIndexType() != null && def.getIndexType() != null)
        {
            // If an index is set (and not drop by this update), the validator shouldn't be change to a non-compatible one
            // (and we want true comparator compatibility, not just value one, since the validator is used by LocalPartitioner to order index rows)
            if (!def.type.isCompatibleWith(type))
                throw new ConfigurationException(String.format("Cannot modify validator to a non-order-compatible one for column %s since an index is set", name));

            assert getIndexName() != null;
            if (!getIndexName().equals(def.getIndexName()))
                throw new ConfigurationException("Cannot modify index name: " + def.getIndexName());
        }

        return new ColumnDefinition(ksName,
                                    cfName,
                                    name,
                                    def.type,
                                    def.getIndexType(),
                                    def.getIndexOptions(),
                                    def.getIndexName(),
                                    componentIndex,
                                    kind);
    }

    public String getIndexName()
    {
        return indexName;
    }

    public ColumnDefinition setIndexName(String indexName)
    {
        this.indexName = indexName;
        return this;
    }

    public ColumnDefinition setIndexType(IndexType indexType, Map<String,String> indexOptions)
    {
        this.indexType = indexType;
        this.indexOptions = indexOptions;
        return this;
    }

    public ColumnDefinition setIndex(String indexName, IndexType indexType, Map<String,String> indexOptions)
    {
        return setIndexName(indexName).setIndexType(indexType, indexOptions);
    }

    public boolean isIndexed()
    {
        return indexType != null;
    }

    public IndexType getIndexType()
    {
        return indexType;
    }

    public Map<String,String> getIndexOptions()
    {
        return indexOptions;
    }

    /**
     * Checks if the index option with the specified name has been specified.
     *
     * @param name index option name
     * @return <code>true</code> if the index option with the specified name has been specified, <code>false</code>
     * otherwise.
     */
    public boolean hasIndexOption(String name)
    {
        return indexOptions != null && indexOptions.containsKey(name);
    }

    /**
     * Converts the specified column definitions into column identifiers.
     *
     * @param definitions the column definitions to convert.
     * @return the column identifiers corresponding to the specified definitions
     */
    public static List<ColumnIdentifier> toIdentifiers(List<ColumnDefinition> definitions)
    {
        return Lists.transform(definitions, new Function<ColumnDefinition, ColumnIdentifier>()
        {
            @Override
            public ColumnIdentifier apply(ColumnDefinition columnDef)
            {
                return columnDef.name;
            }
        });
    }

    public int compareTo(ColumnDefinition other)
    {
        if (this == other)
            return 0;

        if (comparisonOrder != other.comparisonOrder)
            return comparisonOrder - other.comparisonOrder;

        return this.name.compareTo(other.name);
    }

    public Comparator<CellPath> cellPathComparator()
    {
        return cellPathComparator;
    }

    public Comparator<Object> asymmetricCellPathComparator()
    {
        return asymmetricCellPathComparator;
    }

    public Comparator<? super Cell> cellComparator()
    {
        return cellComparator;
    }

    public boolean isComplex()
    {
        return cellPathComparator != null;
    }

    public boolean isSimple()
    {
        return !isComplex();
    }

    public CellPath.Serializer cellPathSerializer()
    {
        // Collections are our only complex so far, so keep it simple
        return CollectionType.cellPathSerializer;
    }

    public void validateCellValue(ByteBuffer value)
    {
        type.validateCellValue(value);
    }

    public void validateCellPath(CellPath path)
    {
        if (!isComplex())
            throw new MarshalException("Only complex cells should have a cell path");

        assert type instanceof CollectionType;
        ((CollectionType)type).nameComparator().validate(path.get(0));
    }

    public static String toCQLString(Iterable<ColumnDefinition> defs)
    {
        return toCQLString(defs.iterator());
    }

    public static String toCQLString(Iterator<ColumnDefinition> defs)
    {
        if (!defs.hasNext())
            return "";

        StringBuilder sb = new StringBuilder();
        sb.append(defs.next().name);
        while (defs.hasNext())
            sb.append(", ").append(defs.next().name);
        return sb.toString();
    }

    /**
     * The type of the cell values for cell belonging to this column.
     *
     * This is the same than the column type, except for collections where it's the 'valueComparator'
     * of the collection.
     */
    public AbstractType<?> cellValueType()
    {
        return type instanceof CollectionType
             ? ((CollectionType)type).valueComparator()
             : type;
    }
}
