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

import java.util.Collections;
import java.util.List;

import org.apache.cassandra.cql3.*;
import org.apache.cassandra.cql3.functions.Function;
import org.apache.cassandra.exceptions.RequestValidationException;

//Parser对CQL解析完后，得到一个ParsedStatement，
//对ParsedStatement调用prepare之后得到一个Prepared实例，这个Prepared实例中包含一个CQLStatement
//有些CQL例如DDL类的CQL没有分开，而是用同一个类来继承ParsedStatement并实现CQLStatement
//例如DropTriggerStatement，在解析时，Parser会生成一个DropTriggerStatement实例，
//调用DropTriggerStatement的prepare方法后生成的Prepared实例中的CQLStatement还是它自己
public abstract class ParsedStatement
{
    private VariableSpecifications variables;

    //只有select/insert/update/delete/batch这5种句型使用
    public VariableSpecifications getBoundVariables() //在子类执行prepare()时调用
    {
        return variables;
    }

    // Used by the parser and preparable statement
    //boundNames.size是prepared语句中?号的个数,
    //先触发setBoundVariables，再到Prepared(CQLStatement, List<ColumnSpecification>)
    //如果是WHERE id=:a AND f1=:b这种类型，boundNames就是a、b
    //如果是WHERE id=? AND f1=?这种类型，boundNames就是null、null
    //Parser对CQL解析完之后都会自动调用这个方法(见Cql.g文法文件，里面有个@after)
    //如果没有?号或绑定变量，就是一个empty的ArrayList
    public void setBoundVariables(List<ColumnIdentifier> boundNames)
    {
        this.variables = new VariableSpecifications(boundNames);
    }

    public void setBoundVariables(VariableSpecifications variables)
    {
        this.variables = variables;
    }

    public abstract Prepared prepare() throws RequestValidationException;

    public static class Prepared
    {
        public final CQLStatement statement;
        public final List<ColumnSpecification> boundNames;
        public final Short[] partitionKeyBindIndexes;

        protected Prepared(CQLStatement statement, List<ColumnSpecification> boundNames, Short[] partitionKeyBindIndexes)
        {
            this.statement = statement;
            this.boundNames = boundNames;
            this.partitionKeyBindIndexes = partitionKeyBindIndexes;
        }

        //凡是调用这个函数的类说明他们对应的CQL支持?号占位符
        //例如select/insert/update/delete/batch
        public Prepared(CQLStatement statement, VariableSpecifications names, Short[] partitionKeyBindIndexes)
        {
            this(statement, names.getSpecifications(), partitionKeyBindIndexes);
        }

        //凡是调用这个函数的类说明他们对应的CQL是不支持?号占位符的
        //例如各类ddl语句
        public Prepared(CQLStatement statement)
        {
            this(statement, Collections.<ColumnSpecification>emptyList(), null);
        }
    }

    //未见使用
    public Iterable<Function> getFunctions()
    {
        return Collections.emptyList();
    }
}
