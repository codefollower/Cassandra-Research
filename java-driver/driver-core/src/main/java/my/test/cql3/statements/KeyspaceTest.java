/*
 * Copyright 2011 The Apache Software Foundation
 *
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
package my.test.cql3.statements;

import my.test.TestBase;

public class KeyspaceTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new KeyspaceTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        cql = "DROP KEYSPACE IF EXISTS KeyspaceTest";
        //KEYSPACE和SCHEMA是一样的
        cql = "DROP SCHEMA IF EXISTS KeyspaceTest3";
        execute();

        //NetworkTopologyStrategy不能使用replication_factor
        cql = "CREATE KEYSPACE IF NOT EXISTS KeyspaceTest " + //
                "WITH replication = {'class':'NetworkTopologyStrategy', 'replication_factor':3} AND DURABLE_WRITES = true";
        //tryExecute();
        
        cql = "CREATE KEYSPACE IF NOT EXISTS KeyspaceTest3 " + //
                "WITH replication = {'class':'SimpleStrategy', 'replication_factor':3} AND DURABLE_WRITES = true";
        execute();

        //system是内部使用的KEYSPACE，不能与它相同
        cql = "CREATE KEYSPACE IF NOT EXISTS system " + //
                "WITH replication = {'class':'SimpleStrategy', 'replication_factor':3} AND DURABLE_WRITES = true";
        tryExecute();

        cql = "ALTER KEYSPACE KeyspaceTest " + //
                "WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
        execute();
    }
}
