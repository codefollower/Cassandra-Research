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

import java.util.Locale;

public class CFName
{
    //对于CREATE TABLE simplex.songs这样的sql，
    //ksName = simplex
    //cfName = songs
    //按RDBMS来看，ksName就是模式名，cfName就是表名，
    //Cassandra的CQL只支持单个ColumnFamily，而HBase支持多个ColumnFamily
    private String ksName;
    private String cfName;

    //在CqlParser中调用，如果Keyspace名加了引号，那么keepCase为true
    //在org.apache.cassandra.cql3.statements.CFStatement.prepareKeyspace(ClientState)中也调用了
    //如果未指定Keyspace名，那么必须使用USE来指明，这时就会触发
    public void setKeyspace(String ks, boolean keepCase)
    {
        ksName = keepCase ? ks : ks.toLowerCase(Locale.US);
    }

    public void setColumnFamily(String cf, boolean keepCase) //在CqlParser中调用，如果列族名加了引号，那么keepCase为true
    {
        cfName = keepCase ? cf : cf.toLowerCase(Locale.US);
    }

    public boolean hasKeyspace()
    {
        return ksName != null;
    }

    public String getKeyspace()
    {
        return ksName;
    }

    public String getColumnFamily()
    {
        return cfName;
    }

    @Override
    public String toString()
    {
        return (hasKeyspace() ? (ksName + ".") : "") + cfName;
    }
}
