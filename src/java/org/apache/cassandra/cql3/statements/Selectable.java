/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.cassandra.cql3.statements;

import java.util.List;

import org.apache.cassandra.cql3.ColumnIdentifier;

//对应Select语句的:
//见Cql.g
//unaliasedSelector returns [Selectable s]
//        @init { Selectable tmp = null; }
//        :  ( c=cident                                  { tmp = c; }
//           | K_WRITETIME '(' c=cident ')'              { tmp = new Selectable.WritetimeOrTTL(c, true); }
//           | K_TTL       '(' c=cident ')'              { tmp = new Selectable.WritetimeOrTTL(c, false); }
//           | f=functionName args=selectionFunctionArgs { tmp = new Selectable.WithFunction(f, args); }
//           ) ( '.' fi=cident { tmp = new Selectable.WithFieldSelection(tmp, fi); } )* { $s = tmp; }
//        ;
//在CqlParser中生成下面这些类的实例
public interface Selectable
{
    public static class WritetimeOrTTL implements Selectable
    {
        public final ColumnIdentifier id;
        public final boolean isWritetime;

        public WritetimeOrTTL(ColumnIdentifier id, boolean isWritetime)
        {
            this.id = id;
            this.isWritetime = isWritetime;
        }

        @Override
        public String toString()
        {
            return (isWritetime ? "writetime" : "ttl") + "(" + id + ")";
        }
    }

    public static class WithFunction implements Selectable
    {
        public final String functionName;
        public final List<Selectable> args;

        //可以这样SELECT token(user_id)，如果是token(user_id, f1)那么args.size>0
        //但不能这样SELECT token(20)
        public WithFunction(String functionName, List<Selectable> args)
        {
            this.functionName = functionName;
            this.args = args;
        }

        @Override
        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(functionName).append("(");
            for (int i = 0; i < args.size(); i++)
            {
                if (i > 0) sb.append(", ");
                sb.append(args.get(i));
            }
            return sb.append(")").toString();
        }
    }

    //见my.test.cql3.TypeTest中的例子
    public static class WithFieldSelection implements Selectable
    {
        public final Selectable selected;
        public final ColumnIdentifier field;

        //此构造函数在org.apache.cassandra.cql3.CqlParser.unaliasedSelector()调用
        public WithFieldSelection(Selectable selected, ColumnIdentifier field)
        {
            this.selected = selected;
            this.field = field;
        }

        @Override
        public String toString()
        {
            return String.format("%s.%s", selected, field);
        }
    }
}
