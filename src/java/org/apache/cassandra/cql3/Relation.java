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

import java.util.ArrayList;
import java.util.List;

/**
 * Relations encapsulate the relationship between an entity of some kind, and
 * a value (term). For example, <key> > "start" or "colname1" = "somevalue".
 *
 */
//表示where子句中的一个关系表达式，只支持and，不支持or
//比如where a=10 and b>20就会得到两个Relation，
//其中entity字段分别是a、b，relationType字段分别是EQ、LT，而value字段分别是10、20
public class Relation
{
    private final ColumnIdentifier entity;
    private final Type relationType;
    private final Term.Raw value;
    private final List<Term.Raw> inValues;
    public final boolean onToken;

    public static enum Type
    {
        //CONTAINS, CONTAINS_KEY是CASSANDRA-4511新加的，见:https://issues.apache.org/jira/browse/CASSANDRA-4511
        EQ, LT, LTE, GTE, GT, IN, CONTAINS, CONTAINS_KEY;

        public boolean allowsIndexQuery()
        {
            switch (this)
            {
                case EQ:
                case CONTAINS:
                case CONTAINS_KEY:
                    return true;
                default:
                    return false;
            }
        }
    }

    //WHERE token(user_id,f1) > 10时会分开成两次，entity分别是user_id和f1，值都是10
    //但是会抛异常:
    /*
     * java.lang.IllegalArgumentException: null
        at java.nio.Buffer.limit(Buffer.java:267) ~[na:1.7.0_10]
        at org.apache.cassandra.db.marshal.AbstractCompositeType.getBytes(AbstractCompositeType.java:55) ~[main/:na]
        at org.apache.cassandra.db.marshal.AbstractCompositeType.getWithShortLength(AbstractCompositeType.java:64) ~[main/:na]
        at org.apache.cassandra.db.marshal.CompositeType.split(CompositeType.java:147) ~[main/:na]
        at org.apache.cassandra.cql3.statements.SelectStatement.processColumnFamily(SelectStatement.java:861) ~[main/:na]
        at org.apache.cassandra.cql3.statements.SelectStatement.process(SelectStatement.java:840) ~[main/:na]
        at org.apache.cassandra.cql3.statements.SelectStatement.processResults(SelectStatement.java:212) ~[main/:na]
        at org.apache.cassandra.cql3.statements.SelectStatement.execute(SelectStatement.java:171) ~[main/:na]
        at org.apache.cassandra.cql3.statements.SelectStatement.execute(SelectStatement.java:1) ~[main/:na]
        at org.apache.cassandra.cql3.QueryProcessor.processStatement(QueryProcessor.java:189) ~[main/:na]
        at org.apache.cassandra.cql3.QueryProcessor.process(QueryProcessor.java:222) ~[main/:na]
     */
    private Relation(ColumnIdentifier entity, Type type, Term.Raw value, List<Term.Raw> inValues, boolean onToken)
    {
        this.entity = entity;
        this.relationType = type;
        this.value = value;
        this.inValues = inValues;
        this.onToken = onToken; //比如WHERE token(user_id) > 10时onToken为true
    }

    /**
     * Creates a new relation.
     *
     * @param entity the kind of relation this is; what the term is being compared to.
     * @param type the type that describes how this entity relates to the value.
     * @param value the value being compared.
     */
    public Relation(ColumnIdentifier entity, Type type, Term.Raw value)
    {
        this(entity, type, value, null, false);
    }

    public Relation(ColumnIdentifier entity, Type type, Term.Raw value, boolean onToken)
    {
        this(entity, type, value, null, onToken);
    }

    public static Relation createInRelation(ColumnIdentifier entity)
    {
        return new Relation(entity, Type.IN, null, new ArrayList<Term.Raw>(), false);
    }

    public Type operator()
    {
        return relationType;
    }

    public ColumnIdentifier getEntity()
    {
        return entity;
    }

    public Term.Raw getValue()
    {
        assert relationType != Type.IN || value == null || value instanceof AbstractMarker.INRaw;
        return value;
    }

    public List<Term.Raw> getInValues()
    {
        assert relationType == Type.IN;
        return inValues;
    }

    public void addInValue(Term.Raw t)
    {
        inValues.add(t);
    }

    @Override
    public String toString()
    {
        if (relationType == Type.IN)
            return String.format("%s IN %s", entity, inValues);
        else
            return String.format("%s %s %s", entity, relationType, value);
    }
}
