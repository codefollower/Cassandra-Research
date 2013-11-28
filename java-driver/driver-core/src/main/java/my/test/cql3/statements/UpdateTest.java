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

import java.util.HashSet;
import java.util.Set;

import my.test.TestBase;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;

public class UpdateTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new UpdateTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        //tableName = "UpdateTest";
        //create();
        //testSetCollectionType();
        //testListCollectionType();
        testMapCollectionType();
    }

    void create() {
        session.execute("DROP TABLE IF EXISTS users");
        session.execute("CREATE TABLE IF NOT EXISTS users " + "(user_id text PRIMARY KEY,first_name text,last_name text,"
                + "emails set<text>, top_places list<text>, todo map<timestamp, text>)");

    }

    public void testSetCollectionType() {
        session.execute("INSERT INTO users (user_id, first_name, last_name, emails) VALUES('frodo', null, 'Baggins', {'f@baggins.com','baggins@gmail.com'});");

        session.execute("INSERT INTO users (user_id, first_name, last_name, emails) VALUES('frodo', 'Frodo', 'Baggins', {'f@baggins.com','baggins@gmail.com'});");

        tryExecute("UPDATE users SET todo = todo + {'fb@friendsofmordor.org','abc@d.com'} WHERE user_id = 'frodo';");
        session.execute("UPDATE users SET todo = todo + {} WHERE user_id = 'frodo';");

        session.execute("UPDATE users SET emails = {'fb@friendsofmordor.org','abc@d.com'} WHERE user_id = 'frodo';");

        session.execute("UPDATE users SET emails = emails + {'fb@friendsofmordor.org','abc@d.com'} WHERE user_id = 'frodo';");

        String sql = "SELECT user_id, emails FROM users WHERE user_id = 'frodo';";
        ResultSet results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET emails = emails - {'fb@friendsofmordor.org'} WHERE user_id = 'frodo';");
        sql = "SELECT user_id, emails FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("DELETE emails['f@baggins.com'] FROM users WHERE user_id = 'frodo';");

        session.execute("UPDATE users SET emails = {} WHERE user_id = 'frodo';");
        sql = "SELECT user_id, emails FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("DELETE emails FROM users WHERE user_id = 'frodo';");
        sql = "SELECT user_id, emails FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        //测试org.apache.cassandra.cql3.TypeCast
        session.execute("DELETE emails FROM users WHERE user_id = (text)'12'");

        cql = "UPDATE users SET emails = ? WHERE user_id = 'frodo';";
        PreparedStatement statement = session.prepare(cql);
        BoundStatement boundStatement = new BoundStatement(statement);
        //session.execute(boundStatement.bind("abc@d.com")); //不能这么用

        Set<String> tags = new HashSet<String>();
        tags.add("abc1@d.com");
        tags.add("abc2@d.com");
        session.execute(boundStatement.bind(tags));
    }

    public void testListCollectionType() {
        //session.execute("ALTER TABLE users ADD top_places list<text>;");
        session.execute("INSERT INTO users (user_id) VALUES('frodo');");
        session.execute("UPDATE users SET top_places = [ 'rivendell', 'rohan' ] WHERE user_id = 'frodo';");
        String sql = "SELECT user_id, top_places FROM users WHERE user_id = 'frodo';";
        ResultSet results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET top_places = [ 'the shire' ] + top_places WHERE user_id = 'frodo';");
        sql = "SELECT user_id, top_places FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET top_places = top_places + [ 'mordor' ] WHERE user_id = 'frodo';");
        sql = "SELECT user_id, top_places FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET top_places[2] = 'riddermark' WHERE user_id = 'frodo';");
        sql = "SELECT user_id, top_places FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("DELETE top_places[3] FROM users WHERE user_id = 'frodo';");
        sql = "SELECT user_id, top_places FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET top_places = top_places - ['riddermark'] WHERE user_id = 'frodo';");
        sql = "SELECT user_id, top_places FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);
    }

    public void testMapCollectionType() {
        //session.execute("ALTER TABLE users ADD todo map<timestamp, text>;");
        session.execute("INSERT INTO users (user_id) VALUES('frodo');");
        session.execute("UPDATE users SET todo ={ '2012-9-24' : 'enter mordor','2012-10-2 12:00' : 'throw ring into mount doom' } WHERE user_id = 'frodo';");
        String sql = "SELECT user_id, todo FROM users WHERE user_id = 'frodo';";
        ResultSet results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET todo['2012-10-2 12:00'] = 'throw my precious into mountdoom' WHERE user_id = 'frodo';");
        sql = "SELECT user_id, todo FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("DELETE todo['2012-9-24'] FROM users WHERE user_id = 'frodo';");
        sql = "SELECT user_id, todo FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users USING TTL 6000 SET todo['2012-10-1'] = 'find water' WHERE user_id = 'frodo';");
        sql = "SELECT user_id, todo FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET todo = todo+ { '2012-9-24' : 'enter mordor'} WHERE user_id = 'frodo';");

        //错误: Multiple incompatible setting of column todo
        //测试org.apache.cassandra.cql3.Operation.RawUpdate.isCompatibleWith(RawUpdate)
        //在org.apache.cassandra.cql3.CqlParser.addRawUpdate(List<Pair<ColumnIdentifier, RawUpdate>>, ColumnIdentifier, RawUpdate)
        tryExecute("UPDATE users SET todo = todo+ { '2012-9-24' : 'enter mordor'},"
                + " todo = { '2012-9-24' : 'enter mordor'} WHERE user_id = 'frodo';");

    }
}
