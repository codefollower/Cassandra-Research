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

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.SimpleStatement;

public class InsertTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new InsertTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        tableName = "InsertTest";
        //create();
        for (int i = 1; i < 100; i++) {
            insert();
            Thread.sleep(1000);
        }
        //select();
    }

    void create() throws Exception {
        cql = "CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, counter_value counter, " //
                + "PRIMARY KEY (block_id))";
        //execute(cql);

        //execute("INSERT INTO " + tableName + "(block_id, counter_value) VALUES (1, 3)");

        //此时建立的索引是CompositesIndexOnRegular
        cql = "CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, short_hair boolean, f1 text, " //
                + "PRIMARY KEY (block_id, short_hair))";

        execute(cql);
    }

    void insert() throws Exception {
        int i = 9;
        cql = "INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (" + i + ", true, 'ab" + i + "')";
        SimpleStatement stmt = new SimpleStatement(cql);
        stmt.setConsistencyLevel(ConsistencyLevel.TWO);
        stmt.setConsistencyLevel(ConsistencyLevel.QUORUM);
        execute(stmt);

        //错误: Multiple definitions found for column f1
        cql = "INSERT INTO " + tableName + "(block_id, short_hair, f1, f1) VALUES (?, ?, ?, ?)";

        cql = "INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (?, ?, ?) USING TIMESTAMP ? AND TTL ?";
        PreparedStatement statement = session.prepare(cql);
        BoundStatement boundStatement = new BoundStatement(statement);
        //TIMESTAMP必须是long类型(所以要明确加L)，而TTL必须是int
        //否则出错: 
        //Invalid type for value 3 of CQL type bigint, 
        //expecting class java.lang.Long but class java.lang.Integer provided
        //session.execute(boundStatement.bind(1, true, "ab", 10000, 100));
        session.execute(boundStatement.bind(1, true, "ab", 10000L, 100));

        //                execute("drop table if EXISTS " + tableName + "2");
        //                cql = "CREATE TABLE IF NOT EXISTS " + tableName + "2" //
        //                        + " ( block_id int, f1 int, f2 int, f3 int, " //
        //                        + "PRIMARY KEY ((block_id, f1), f2))";
        //                execute(cql);
        //        
        //                cql = "INSERT INTO " + tableName + "2" + "(block_id, f1, f2, f3) VALUES (1,2,3,4)";
        //                stmt = new SimpleStatement(cql);
        //                execute(stmt);
        //                
        //                cql = "SELECT * FROM " + tableName + "2" + " WHERE block_id in(1,2,3)";
        //                cql = "SELECT * FROM " + tableName + "2" + " WHERE block_id =1 AND f1 in(1,2,3)";
        //                
        //                //错误的:IN is only supported on the last column of the partition key
        //                cql = "DELETE FROM " + tableName + "2" + " WHERE block_id in(1,2,3)";
        //                cql = "DELETE FROM " + tableName + "2" + " WHERE block_id =1 AND f1 in(1,2,3)";
        ////                execute(cql);
        //
        //        execute("BEGIN BATCH " + //
        //                " INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (1, true, 'ab')" + //
        //                " INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (2, true, 'cd')" + //
        //                " APPLY BATCH");

        tryExecute("DELETE FROM " + tableName + " WHERE block_id in(1,2,3) IF f1='ab' AND short_hair=true");
    }
}
