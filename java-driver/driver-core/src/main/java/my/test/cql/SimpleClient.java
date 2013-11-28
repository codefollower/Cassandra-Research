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
package my.test.cql;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.Host;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ProtocolOptions.Compression;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SimpleStatement;
import com.datastax.driver.core.SocketOptions;

public class SimpleClient {
    private Cluster cluster;

    private Session session;

    public void connect(String node) {
        Cluster.Builder builder = Cluster.builder().addContactPoint(node);
        // builder.withClusterName("My Cassandra Cluster");
        SocketOptions so = new SocketOptions();
        // 设置一下这两个参数，避免在用eclipse进行debug代码时出现超时
        so.setReadTimeoutMillis(60 * 60 * 1000);
        so.setConnectTimeoutMillis(60 * 60 * 1000);
        builder.withSocketOptions(so);

        builder.withCredentials("cassandra", "cassandra");

        PoolingOptions po = new PoolingOptions();
        po.setCoreConnectionsPerHost(HostDistance.LOCAL, 1);
        po.setCoreConnectionsPerHost(HostDistance.REMOTE, 1);
        builder.withPoolingOptions(po);

        builder.withCompression(Compression.SNAPPY);
        cluster = builder.build();
        cluster.init();

        Metadata metadata = cluster.getMetadata();
        System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
        for (Host host : metadata.getAllHosts()) {
            System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n", host.getDatacenter(), host.getAddress(), host.getRack());
        }

        session = cluster.connect();
    }

    public void close() {
        cluster.shutdown();
    }

    public void createSchema() {
        session.execute("CREATE KEYSPACE IF NOT EXISTS simplex WITH replication "
                + "= {'class':'SimpleStrategy', 'replication_factor':3};");

        session.execute("CREATE TABLE IF NOT EXISTS simplex.songs (" + "id uuid PRIMARY KEY," + "title text," + "album text,"
                + "artist text," + "tags set<text>," + "data blob" + ");");
        session.execute("CREATE TABLE IF NOT EXISTS simplex.playlists (" + "id uuid," + "title text," + "album text, "
                + "artist text," + "song_id uuid," + "PRIMARY KEY (id, title, album, artist)" + ");");
    }

    public void loadData() {
        // session.execute(
        // "CREATE TABLE simplex.soNgs2 (" +
        // "id uuid PRIMARY KEY," +
        // "title text," +
        // "alBum text," +
        // "artist text," +
        // "tags set<text>," +
        // "data blob" +
        // ");");
        // session.execute(
        // "INSERT INTO simplex.songs2 (id, title, ALBUM, artist, tags) " +
        // "VALUES (" +
        // "756716f7-2e54-4715-9f00-91dcbea6cf50," +
        // "'La Petite Tonkinoise'," +
        // "'Bye Bye Blackbird'," +
        // "'Joséphine Baker'," +
        // "{'jazz', '2013'})" +
        // ";");

        session.execute("INSERT INTO simplex.songs (id, title, album, artist, tags) " + "VALUES ("
                + "756716f7-2e54-4715-9f00-91dcbea6cf50," + "'La Petite Tonkinoise'," + "'Bye Bye Blackbird',"
                + "'Joséphine Baker'," + "{'jazz', '2013'})" + ";");
        session.execute("INSERT INTO simplex.playlists (id, song_id, title, album, artist) " + "VALUES ("
                + "2cc9ccb7-6221-4ccb-8387-f22b6a1b354d," + "756716f7-2e54-4715-9f00-91dcbea6cf50," + "'La Petite Tonkinoise',"
                + "'Bye Bye Blackbird'," + "'Joséphine Baker'" + ");");
    }

    public void querySchema() {
        ResultSet results = session.execute("SELECT * FROM simplex.playlists "
                + "WHERE id = 2cc9ccb7-6221-4ccb-8387-f22b6a1b354d;");

        System.out.println(String.format("%-30s\t%-20s\t%-20s\n%s", "title", "album", "artist",
                "-------------------------------+-----------------------+--------------------"));
        for (Row row : results) {
            System.out.println(String.format("%-30s\t%-20s\t%-20s", row.getString("title"), row.getString("album"),
                    row.getString("artist")));
        }
        System.out.println();
    }

    public void testSelect() {
        // session.execute("DROP TABLE simplex.test;");
        // session.execute(
        // "CREATE TABLE simplex.test (" +
        // "k int PRIMARY KEY," +
        // "v1 int," +
        // "v2 int);");

        // session.execute(
        // "CREATE TABLE simplex.test (" +
        // "k0 int," +
        // "k int," +
        // "v1 int," +
        // "v2 int," +
        // " PRIMARY KEY(k0,k)"+
        // ");");

        // session.execute(
        // "CREATE TABLE simplex.test (" +
        // "k0 int," +
        // "k int," +
        // "v1 int," +
        // "v2 int," +
        // " PRIMARY KEY(k0)"+
        // ");");
        // session.execute("DROP INDEX myindex;");
        // session.execute("CREATE INDEX myindex on simplex.test(k);");

        // session.execute("INSERT INTO simplex.test (k, v1, v2) VALUES (1, 2, 3);");
        // session.execute("INSERT INTO simplex.test (k, v1, v2) VALUES (4, 5, 6);");
        // session.execute("INSERT INTO simplex.test (k, v1, v2) VALUES (7, 8, 9);");
        //
        // session.execute("SELECT * FROM system.HintsColumnFamily");
        session.execute("INSERT INTO simplex.test (k0, k, v1, v2) VALUES (1, 1, 2, 3);");
        session.execute("INSERT INTO simplex.test (k0, k, v1, v2) VALUES (4, 4, 5, 6);");
        session.execute("INSERT INTO simplex.test (k0, k, v1, v2) VALUES (7, 7, 8, 9);");

        String sql = "SELECT * FROM simplex.test WHERE k > 3  ALLOW FILTERING";
        sql = "SELECT token(k0), k, v1, v2 FROM simplex.test WHERE k > 3  ALLOW FILTERING";
        // sql =
        // "SELECT token(k), k, v1, v2 FROM simplex.test WHERE token(k) > token(3);";
        //
        // sql =
        // "SELECT token(k), k, v1, v2 FROM simplex.test WHERE token(k) > 3";
        // sql = "SELECT token(k), k, v1, v2 FROM simplex.test";

        sql = "SELECT token(k), k, v1, v2 FROM simplex.test WHERE k > 3"; // 不支持范围查询
        // sql = "SELECT token(k), k, v1, v2 FROM simplex.test WHERE k = 7";
        sql = "SELECT token(k), k, v1, v2 FROM simplex.test WHERE k in(7, 4)";

        // sql =
        // "SELECT token(k), k, v1, v2 FROM simplex.test WHERE k0> 3 AND k > 3";

        sql = "SELECT token(k), k, v1, v2 FROM simplex.test WHERE k > 3";
        ResultSet results = session.execute(sql);

        System.out.println(String.format("%-30s\t%-20s\t%-20s\t%-20s\n%s", "token(k)", "k", "v1", "v2",
                "-------------------------------+-----------------------+--------------------+--------------------"));
        for (Row row : results) {
            System.out.println(String.format("%-30s\t%-20s\t%-20s\t%-20s", row.getLong(0), row.getInt(1),//
                    row.getInt("v1"), row.getInt("v2")));
        }
        System.out.println();

    }

    public void testCounterColumn() {
        // session.execute("DROP TABLE simplex.page_view_counts;");
        // session.execute("CREATE TABLE simplex.page_view_counts (" + //
        // "counter_value counter," + //
        // "url_name varchar," + //
        // "page_name varchar," + //
        // "PRIMARY KEY (url_name, page_name)" + //
        // ");");

        session.execute("UPDATE simplex.page_view_counts SET counter_value = counter_value + 1"
                + "WHERE url_name='www.datastax.com' AND page_name='home';");
        String sql = "SELECT url_name,page_name,counter_value FROM simplex.page_view_counts";
        ResultSet results = session.execute(sql);

        System.out.println(String.format("%-30s\t%-20s\t%-20s\n%s", "url_name", "page_name", "counter_value counter",
                "-------------------------------+-----------------------+--------------------"));
        for (Row row : results) {
            System.out.println(String.format("%-30s\t%-20s\t%-20s", row.getString(0), row.getString(1),//
                    row.getLong(2)));
        }
        System.out.println();

    }

    private void printResultSet(ResultSet results) {
        ColumnDefinitions cd = results.getColumnDefinitions();
        int size = cd.size();

        for (Row row : results) {
            for (int i = 0; i < size; i++) {
                System.out.print(" ");
                DataType dt = cd.getType(i);
                switch (dt.getName()) {
                case TEXT:
                    System.out.print(row.getString(i));
                    break;
                case INT:
                    System.out.print(row.getInt(i));
                    break;
                case BIGINT:
                    System.out.print(row.getLong(i));
                    break;
                case UUID:
                    System.out.print(row.getUUID(i));
                    break;
                case SET:
                    System.out.print(row.getSet(i, String.class));
                    break;
                case LIST:
                    System.out.print(row.getList(i, String.class));
                    break;
                case MAP:
                    System.out.print(row.getMap(i, java.util.Date.class, String.class));
                    break;
                default:
                    System.out.print(row.getString(i));
                    break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void testSetCollectionType() {
        session.execute("USE simplex");
        // session.execute("DROP TABLE simplex.users;");
        session.execute("CREATE TABLE IF NOT EXISTS users (user_id text PRIMARY KEY,first_name text,last_name text,emails set<text>);");

        session.execute("INSERT INTO users (user_id, first_name, last_name, emails) VALUES('frodo', 'Frodo', 'Baggins', {'f@baggins.com','baggins@gmail.com'});");

        session.execute("UPDATE users SET emails = emails + {'fb@friendsofmordor.org'} WHERE user_id = 'frodo';");

        String sql = "SELECT user_id, emails FROM users WHERE user_id = 'frodo';";
        ResultSet results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET emails = emails - {'fb@friendsofmordor.org'} WHERE user_id = 'frodo';");
        sql = "SELECT user_id, emails FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("UPDATE users SET emails = {} WHERE user_id = 'frodo';");
        sql = "SELECT user_id, emails FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);

        session.execute("DELETE emails FROM users WHERE user_id = 'frodo';");
        sql = "SELECT user_id, emails FROM users WHERE user_id = 'frodo';";
        results = session.execute(sql);
        printResultSet(results);
    }

    public void testListCollectionType() {
        session.execute("USE simplex");
        // session.execute("ALTER TABLE users ADD top_places list<text>;");
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
        session.execute("USE simplex");
        // session.execute("ALTER TABLE users ADD todo map<timestamp, text>;");
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
    }

    Session getSession() {
        return session;
    }

    public void loadDataUsingBoundStatements() {
        PreparedStatement statement = getSession().prepare(
                "INSERT INTO simplex.songs " + "(id, title, album, artist, tags) " + "VALUES (?, ?, ?, ?, ?);");
        BoundStatement boundStatement = new BoundStatement(statement);
        Set<String> tags = new HashSet<String>();
        tags.add("jazz");
        tags.add("2013");
        getSession().execute(
                boundStatement.bind(UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"), "La Petite Tonkinoise'",
                        "Bye Bye Blackbird'", "Joséphine Baker", tags));
        statement = getSession().prepare(
                "INSERT INTO simplex.playlists " + "(id, song_id, title, album, artist) " + "VALUES (?, ?, ?, ?, ?);");
        boundStatement = new BoundStatement(statement);
        getSession().execute(
                boundStatement.bind(UUID.fromString("2cc9ccb7-6221-4ccb-8387-f22b6a1b354d"),
                        UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"), "La Petite Tonkinoise", "Bye Bye Blackbird",
                        "Joséphine Baker"));
    }

    public void queryUsingPreparedStatement() {
        PreparedStatement statement = getSession().prepare("SELECT title,album,artist FROM playlists WHERE id = ?");
        BoundStatement boundStatement = new BoundStatement(statement);

        System.out.println(String.format("%-30s\t%-20s\t%-20s\n%s", "title", "album", "artist",
                "-------------------------------+-----------------------+--------------------"));
        for (Row row : getSession().execute(boundStatement.bind(UUID.fromString("2cc9ccb7-6221-4ccb-8387-f22b6a1b354d")))) {

            System.out.println(String.format("%-30s\t%-20s\t%-20s", row.getString("title"), row.getString("album"),
                    row.getString("artist")));
        }
        System.out.println();
    }

    public void testInsert() {
        session.execute("INSERT INTO simplex.songs (id, title, album, artist, tags) " + "VALUES ("
                + "756716f7-2e54-4715-9f00-91dcbea6cf50," + "'La Petite Tonkinoise'," + "'Bye Bye Blackbird',"
                + "'Joséphine Baker'," + "{'jazz', '2013'})" + " USING TTL 86400" + " and TIMESTAMP 1318452291034" + ";");
    }

    public void testDelete() {
        // session.execute("delete from simplex.playlists where id=2cc9ccb7-6221-4ccb-8387-f22b6a1b354d");

        // PreparedStatement statement =
        // getSession().prepare("delete from simplex.playlists where id=?");
        // BoundStatement boundStatement = new BoundStatement(statement);
        // getSession().execute(boundStatement.bind(
        // UUID.fromString("2cc9ccb7-6221-4ccb-8387-f22b6a1b354d")) );
        //
        session.execute("delete from simplex.playlists  USING TIMESTAMP 1318452291034  where id in(2cc9ccb7-6221-4ccb-8387-f22b6a1b354d, 756716f7-2e54-4715-9f00-91dcbea6cf50)");
    }

    public void testUpdate() {
        session.execute("update simplex.songs  USING TTL 86400 and TIMESTAMP 1318452291034 set title = 'abc' " + //
                "where id in(2cc9ccb7-6221-4ccb-8387-f22b6a1b354d, 756716f7-2e54-4715-9f00-91dcbea6cf50)");
    }

    public void run() {
        connect("127.0.0.1");
        createSchema();
        //session.execute("USE simplex");

        SimpleStatement stmt = new SimpleStatement("USE simplex");
        stmt.enableTracing();
        session.execute(stmt);

        // loadData();
        //loadDataUsingBoundStatements();
        // querySchema();
        //queryUsingPreparedStatement();

        // testInsert();
        // testUpdate();
        // testDelete();
        // testSelect();
        // testCounterColumn();
        //testSetCollectionType();
        // testListCollectionType();
        // testMapCollectionType();
        

        close();
    }

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        client.run();
    }
}