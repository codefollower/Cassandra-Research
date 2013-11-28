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

public class DeleteTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new DeleteTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        tableName = "DeleteTest";
        //        create();
        //        insert();
        delete();
    }

    void create() throws Exception {
        execute("DROP TABLE IF EXISTS " + tableName);

        cql = "CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, short_hair boolean, f1 text, " //
                + "PRIMARY KEY (block_id))";
        execute(cql);
    }

    void insert() throws Exception {
        cql = "INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (1, true, 'abbc')";
        SimpleStatement stmt = new SimpleStatement(cql);
        stmt.setConsistencyLevel(ConsistencyLevel.ONE);
        //stmt.setConsistencyLevel(ConsistencyLevel.QUORUM);
        execute(stmt);

        cql = "INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (?, ?, ?) USING TIMESTAMP ? AND TTL ?";
        PreparedStatement statement = session.prepare(cql);
        BoundStatement boundStatement = new BoundStatement(statement);
        session.execute(boundStatement.bind(1, true, "ab", 10000L, 100));
    }

    void delete() throws Exception {
        //还不支持在where中使用or
        cql = "DELETE f1 FROM " + tableName + " WHERE block_id=1 or block_id=2";
        //where中只允许出现primary key
        //否则出错:Non PRIMARY KEY f1 found in where clause
        cql = "DELETE f1 FROM " + tableName + " WHERE f1='abbc'";
        cql = "DELETE f1 FROM " + tableName + " WHERE block_id=1";
        execute();

        cql = "DELETE FROM " + tableName + " WHERE block_id=1";
        execute();

        //错误:IN on the partition key is not supported with conditional updates
        tryExecute("DELETE FROM " + tableName + " WHERE block_id in(1,2,3) IF f1='ab' AND short_hair=true");

        execute("DELETE FROM " + tableName + " WHERE block_id=1 IF f1='ab' AND short_hair=true");

        tableName = "DeleteTest2";
        cql = "CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, short_hair boolean, f1 text, f2 text, f3 text, " //
                + "PRIMARY KEY (block_id, f1, f2))";
        execute(cql);
        cql = "INSERT INTO " + tableName + "(block_id, short_hair, f1, f2, f3) VALUES (1, true, 'abbc', 'abbc', 'abbc')";
        execute(cql);

        //对应一个RangeTombstone
        execute("DELETE FROM " + tableName + " WHERE block_id=1 AND f1='abbc'");

        //错误:Missing mandatory PRIMARY KEY part f2 since f3 specified
        tryExecute("DELETE f3 FROM " + tableName + " WHERE block_id=1 AND f1='abbc'");

        tableName = "DeleteTest3";
        cql = "CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, short_hair boolean, f1 text, f2 text, f3 text, " //
                + "PRIMARY KEY (block_id, f1, f2, short_hair)) WITH COMPACT STORAGE";
        execute(cql);
        cql = "INSERT INTO " + tableName + "(block_id, short_hair, f1, f2, f3) VALUES (1, true, 'abbc', 'abbc', 'abbc')";
        execute(cql);

        //对应org.apache.cassandra.cql3.statements.DeleteStatement.updateForKey(ByteBuffer, ColumnNameBuilder, UpdateParameters)
        //的if (isRange)
        execute("DELETE FROM " + tableName + " WHERE block_id=1 AND f1='abbc'");

        //对应org.apache.cassandra.cql3.statements.DeleteStatement.updateForKey(ByteBuffer, ColumnNameBuilder, UpdateParameters)
        //的if (cfDef.isCompact)
        execute("DELETE FROM " + tableName + " WHERE block_id=1 AND f1='abbc' AND f2='abbc' AND short_hair=true");
    }
}
