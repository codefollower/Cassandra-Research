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
package org.apache.cassandra.cql3;

import org.apache.cassandra.config.KSMetaData;
import org.apache.cassandra.config.Schema;
import org.apache.cassandra.db.marshal.*;
import org.apache.cassandra.exceptions.InvalidRequestException;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.cassandra.exceptions.SyntaxException;

//定义字段的类型
//对应Cql.g文件中comparatorType
public interface CQL3Type
{
    public boolean isCollection();
    public AbstractType<?> getType();

    //16个本地类型
    public enum Native implements CQL3Type
    {
        ASCII    (AsciiType.instance), //与TEXT类似，但是使用US-ASCII编码，而TEXT用UTF-8
        BIGINT   (LongType.instance),
        BLOB     (BytesType.instance),
        BOOLEAN  (BooleanType.instance),
        COUNTER  (CounterColumnType.instance),
        DECIMAL  (DecimalType.instance),
        DOUBLE   (DoubleType.instance),
        FLOAT    (FloatType.instance),
        INET     (InetAddressType.instance),
        INT      (Int32Type.instance),
        TEXT     (UTF8Type.instance),
        TIMESTAMP(TimestampType.instance),
        UUID     (UUIDType.instance),
        VARCHAR  (UTF8Type.instance),
        VARINT   (IntegerType.instance), //Int32Type对应int类型，而IntegerType对应BigInteger
        TIMEUUID (TimeUUIDType.instance);

        private final AbstractType<?> type;

        private Native(AbstractType<?> type)
        {
            this.type = type;
        }

        public boolean isCollection()
        {
            return false;
        }

        public AbstractType<?> getType()
        {
            return type;
        }

        @Override
        public String toString()
        {
            return super.toString().toLowerCase();
        }
    }

    //可以像这样定义字段类型:
    //CREATE TABLE(f1 'org.apache.cassandra.db.marshal.UTF8Type');
    //CREATE TABLE(f1 'UTF8Type');
    //但是不能这样:
    //CREATE TABLE(f1 UTF8Type); //要加单引号
    public static class Custom implements CQL3Type
    {
        private final AbstractType<?> type;

        public Custom(AbstractType<?> type)
        {
            this.type = type;
        }

        public Custom(String className) throws SyntaxException, ConfigurationException
        {
            this(TypeParser.parse(className));
        }

        public boolean isCollection()
        {
            return false;
        }

        public AbstractType<?> getType()
        {
            return type;
        }

        @Override
        public final boolean equals(Object o)
        {
            if(!(o instanceof Custom))
                return false;

            Custom that = (Custom)o;
            return type.equals(that.type);
        }

        @Override
        public final int hashCode()
        {
            return type.hashCode();
        }

        @Override
        public String toString()
        {
            return "'" + type + "'";
        }
    }

    //如: "CREATE TABLE IF NOT EXISTS test ( block_id uuid PRIMARY KEY, s set<int>, l list<int>, m map<text,int>)
    //Collection类型的元素类型不能是couter类型和Collection类型
    public static class Collection implements CQL3Type
    {
        private final CollectionType type;

        public Collection(CollectionType<?> type)
        {
            this.type = type;
        }

        public AbstractType<?> getType()
        {
            return type;
        }

        public boolean isCollection()
        {
            return true;
        }

        @Override
        public final boolean equals(Object o)
        {
            if(!(o instanceof Collection))
                return false;

            Collection that = (Collection)o;
            return type.equals(that.type);
        }

        @Override
        public final int hashCode()
        {
            return type.hashCode();
        }

        @Override
        public String toString()
        {
            switch (type.kind)
            {
                case LIST:
                    return "list<" + ((ListType)type).elements.asCQL3Type() + ">";
                case SET:
                    return "set<" + ((SetType)type).elements.asCQL3Type() + ">";
                case MAP:
                    MapType mt = (MapType)type;
                    return "map<" + mt.keys.asCQL3Type() + ", " + mt.values.asCQL3Type() + ">";
            }
            throw new AssertionError();
        }
    }

    public static class UserDefined implements CQL3Type //用create type建立的类型
    {
        // Keeping this separatly from type just to simplify toString()
        private final String name;
        private final UserType type;

        private UserDefined(String name, UserType type)
        {
            this.name = name;
            this.type = type;
        }

        //在org.apache.cassandra.db.marshal.UserType.asCQL3Type()调用
        public static UserDefined create(UserType type)
        {
            return new UserDefined(UTF8Type.instance.compose(type.name), type);
        }

        public boolean isCollection()
        {
            return false;
        }

        public AbstractType<?> getType()
        {
            return type;
        }

        @Override
        public final boolean equals(Object o)
        {
            if(!(o instanceof UserDefined))
                return false;

            UserDefined that = (UserDefined)o;
            return type.equals(that.type);
        }

        @Override
        public final int hashCode()
        {
            return type.hashCode();
        }

        @Override
        public String toString()
        {
            return name;
        }
    }
 
    // For UserTypes, we need to know the current keyspace to resolve the
    // actual type used, so Raw is a "not yet prepared" CQL3Type.
    public abstract class Raw
    {
        public boolean isCollection()
        {
            return false;
        }

        public boolean isCounter()
        {
            return false;
        }

        public abstract CQL3Type prepare(String keyspace) throws InvalidRequestException;

        public static Raw from(CQL3Type type)
        {
            return new RawType(type);
        }

        public static Raw userType(UTName name)
        {
            return new RawUT(name);
        }

        public static Raw map(CQL3Type.Raw t1, CQL3Type.Raw t2) throws InvalidRequestException
        {
            if (t1.isCollection() || t2.isCollection())
                throw new InvalidRequestException("map type cannot contain another collection");
            if (t1.isCounter() || t2.isCounter())
                throw new InvalidRequestException("counters are not allowed inside a collection");

            return new RawCollection(CollectionType.Kind.MAP, t1, t2);
        }

        public static Raw list(CQL3Type.Raw t) throws InvalidRequestException
        {
            if (t.isCollection())
                throw new InvalidRequestException("list type cannot contain another collection");
            if (t.isCounter())
                throw new InvalidRequestException("counters are not allowed inside a collection");

            return new RawCollection(CollectionType.Kind.LIST, null, t);
        }

        public static Raw set(CQL3Type.Raw t) throws InvalidRequestException
        {
            if (t.isCollection())
                throw new InvalidRequestException("set type cannot contain another collection");
            if (t.isCounter())
                throw new InvalidRequestException("counters are not allowed inside a collection");

            return new RawCollection(CollectionType.Kind.SET, null, t);
        }

        private static class RawType extends Raw
        {
            private CQL3Type type;

            private RawType(CQL3Type type)
            {
                this.type = type;
            }

            public CQL3Type prepare(String keyspace) throws InvalidRequestException
            {
                return type;
            }

            public boolean isCounter()
            {
                return type == Native.COUNTER;
            }

            @Override
            public String toString()
            {
                return type.toString();
            }
        }

        private static class RawCollection extends Raw
        {
            private final CollectionType.Kind kind;
            private final CQL3Type.Raw keys;
            private final CQL3Type.Raw values;

            private RawCollection(CollectionType.Kind kind, CQL3Type.Raw keys, CQL3Type.Raw values)
            {
                this.kind = kind;
                this.keys = keys;
                this.values = values;
            }

            public boolean isCollection()
            {
                return true;
            }

            public CQL3Type prepare(String keyspace) throws InvalidRequestException
            {
                switch (kind)
                {
                    case LIST: return new Collection(ListType.getInstance(values.prepare(keyspace).getType()));
                    case SET:  return new Collection(SetType.getInstance(values.prepare(keyspace).getType()));
                    case MAP:  return new Collection(MapType.getInstance(keys.prepare(keyspace).getType(), values.prepare(keyspace).getType()));
                }
                throw new AssertionError();
            }

            @Override
            public String toString()
            {
                switch (kind)
                {
                    case LIST: return "list<" + values + ">";
                    case SET:  return "set<" + values + ">";
                    case MAP:  return "map<" + keys + ", " + values + ">";
                }
                throw new AssertionError();
            }
        }

        private static class RawUT extends Raw
        {

            private final UTName name;

            private RawUT(UTName name)
            {
                this.name = name;
            }

            public CQL3Type prepare(String keyspace) throws InvalidRequestException
            {
                name.setKeyspace(keyspace);

                KSMetaData ksm = Schema.instance.getKSMetaData(name.getKeyspace());
                if (ksm == null)
                    throw new InvalidRequestException("Unknown keyspace " + name.getKeyspace());
                UserType type = ksm.userTypes.getType(name.getUserTypeName());
                if (type == null)
                    throw new InvalidRequestException("Unknown type " + name);

                return new UserDefined(name.toString(), type);
            }

            @Override
            public String toString()
            {
                return name.toString();
            }
    }
    }
}
