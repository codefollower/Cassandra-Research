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
import com.datastax.driver.core.Host;
import com.datastax.driver.core.Metadata;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

public class SimpleClient {
   private Cluster cluster;
   
   private Session session;

   public void connect(String node) {
      cluster = Cluster.builder()
            .addContactPoint(node).build();
      Metadata metadata = cluster.getMetadata();
      System.out.printf("Connected to cluster: %s\n", 
            metadata.getClusterName());
      for ( Host host : metadata.getAllHosts() ) {
         System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n",
               host.getDatacenter(), host.getAddress(), host.getRack());
      }
      
      session = cluster.connect();
   }

   public void close() {
      cluster.shutdown();
   }
   
   public void createSchema() {
       session.execute("CREATE KEYSPACE simplex WITH replication " + 
       "= {'class':'SimpleStrategy', 'replication_factor':3};");
       
       session.execute(
               "CREATE TABLE simplex.songs (" +
                     "id uuid PRIMARY KEY," + 
                     "title text," + 
                     "album text," + 
                     "artist text," + 
                     "tags set<text>," + 
                     "data blob" + 
                     ");");
         session.execute(
               "CREATE TABLE simplex.playlists (" +
                     "id uuid," +
                     "title text," +
                     "album text, " + 
                     "artist text," +
                     "song_id uuid," +
                     "PRIMARY KEY (id, title, album, artist)" +
                     ");");
   }
   
   public void loadData()  {
       session.execute(
               "INSERT INTO simplex.songs (id, title, album, artist, tags) " +
               "VALUES (" +
                   "756716f7-2e54-4715-9f00-91dcbea6cf50," +
                   "'La Petite Tonkinoise'," +
                   "'Bye Bye Blackbird'," +
                   "'Joséphine Baker'," +
                   "{'jazz', '2013'})" +
                   ";");
         session.execute(
               "INSERT INTO simplex.playlists (id, song_id, title, album, artist) " +
               "VALUES (" +
                   "2cc9ccb7-6221-4ccb-8387-f22b6a1b354d," +
                   "756716f7-2e54-4715-9f00-91dcbea6cf50," +
                   "'La Petite Tonkinoise'," +
                   "'Bye Bye Blackbird'," +
                   "'Joséphine Baker'" +
                   ");");
   }

    public void querySchema() {
        //ResultSet results = session.execute("SELECT * FROM simplex.playlists " + "WHERE id = 2cc9ccb7-6221-4ccb-8387-f22b6a1b354d;");
        
        ResultSet results = session.execute("SELECT * FROM simplex.playlists;");
        
        
        System.out.println(String.format("%-30s\t%-20s\t%-20s\n%s", "title", "album", "artist",
                "-------------------------------+-----------------------+--------------------"));
        for (Row row : results) {
            System.out.println(String.format("%-30s\t%-20s\t%-20s", row.getString("title"), row.getString("album"),
                    row.getString("artist")));
        }
        System.out.println();
    }
    
    Session getSession() {
       return session;
    }
    
    public void loadDataUsingBoundStatements() {
        PreparedStatement statement = getSession().prepare(
              "INSERT INTO simplex.songs " +
              "(id, title, album, artist, tags) " +
              "VALUES (?, ?, ?, ?, ?);");
        BoundStatement boundStatement = new BoundStatement(statement);
        Set<String> tags = new HashSet<String>();
        tags.add("jazz");
        tags.add("2013");
        getSession().execute(boundStatement.bind(
              UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"),
              "La Petite Tonkinoise'",
              "Bye Bye Blackbird'",
              "Joséphine Baker",
              tags ) );
        statement = getSession().prepare(
              "INSERT INTO simplex.playlists " +
              "(id, song_id, title, album, artist) " +
              "VALUES (?, ?, ?, ?, ?);");
        boundStatement = new BoundStatement(statement);
        getSession().execute(boundStatement.bind(
              UUID.fromString("2cc9ccb7-6221-4ccb-8387-f22b6a1b354d"),
              UUID.fromString("756716f7-2e54-4715-9f00-91dcbea6cf50"),
              "La Petite Tonkinoise",
              "Bye Bye Blackbird",
              "Joséphine Baker") );
     }
    public void testInsert()  {
        session.execute(
                "INSERT INTO simplex.songs (id, title, album, artist, tags) " +
                "VALUES (" +
                    "756716f7-2e54-4715-9f00-91dcbea6cf50," +
                    "'La Petite Tonkinoise'," +
                    "'Bye Bye Blackbird'," +
                    "'Joséphine Baker'," +
                    "{'jazz', '2013'})" +
                    " USING TTL 86400"+
                    " and TIMESTAMP 1318452291034"+
                    ";");
    }
    
    public void testDelete() {
        //session.execute("delete from simplex.playlists where id=2cc9ccb7-6221-4ccb-8387-f22b6a1b354d");
        
//        PreparedStatement statement = getSession().prepare("delete from simplex.playlists where id=?");
//          BoundStatement boundStatement = new BoundStatement(statement);
//          getSession().execute(boundStatement.bind(
//                UUID.fromString("2cc9ccb7-6221-4ccb-8387-f22b6a1b354d")) );
//          
          session.execute("delete from simplex.playlists  USING TIMESTAMP 1318452291034  where id in(2cc9ccb7-6221-4ccb-8387-f22b6a1b354d, 756716f7-2e54-4715-9f00-91dcbea6cf50)");
    }

    public void testUpdate() {

          session.execute("update simplex.songs  USING TTL 86400 and TIMESTAMP 1318452291034 set title = 'abc' where id in(2cc9ccb7-6221-4ccb-8387-f22b6a1b354d, 756716f7-2e54-4715-9f00-91dcbea6cf50)");
    }
    
    public void run() {
        connect("127.0.0.1");

        //      createSchema();
        //      loadData();
        //      loadDataUsingBoundStatements();
        //      querySchema();

        testInsert();
        //testUpdate();
        //testDelete();

        close();
    }
    
    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        client.run();
        //client.connect("127.0.0.1");

//        client.createSchema();
//        client.loadData();
//        client.loadDataUsingBoundStatements();
//        client.querySchema();
        
        //client.testDelete();

        //client.close();
    }
}