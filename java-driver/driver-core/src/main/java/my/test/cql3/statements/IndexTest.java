package my.test.cql3.statements;

import my.test.TestBase;

public class IndexTest extends TestBase {
    String indexName;
    public static void main(String[] args) throws Exception {
        new IndexTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        tableName = "IndexTest";
        createTest();
        dropTest();
    }

    void test_CreateIndexStatement_validate() throws Exception {

        tableName = "IndexTest1";
        indexName = tableName + "_index_alias";

        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " (pk int PRIMARY KEY, c counter)");
        //错误: counter type is not supported for PRIMARY KEY part c
        //tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " (c counter PRIMARY KEY)");
        //错误: Secondary indexes are not supported on counter tables
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c)");

        tableName = "IndexTest2";
        indexName = tableName + "_myindex";
        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " (pk int PRIMARY KEY, c text)");
        //错误: No column definition found for column c2
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c2)");

        execute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c)");
        execute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c)");
        //错误: Index already exists
        tryExecute("CREATE INDEX " + indexName + " ON " + tableName + " (c)");
        indexName = tableName + "_index_c2";
        //错误: Index already exists
        //在同一个字段上不能建立两个索引，哪怕索引名不同也不行
        tryExecute("CREATE INDEX " + indexName + " ON " + tableName + " (c)");

        tableName = "IndexTest3";
        indexName = tableName + "_myindex";
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " (pk int PRIMARY KEY, c text, i int)");
        //错误: CUSTOM index requires specifiying the index class
        //少了USING子句
        tryExecute("CREATE CUSTOM INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c)");
        //错误: Cannot specify index class for a non-CUSTOM index
        //使用USING子句时必须指定CUSTOM
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c) USING 'my_index_class'");

        tableName = "IndexTest4";
        indexName = tableName + "_myindex";
        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " (pk int,i int, c text, PRIMARY KEY(pk,i)) WITH COMPACT STORAGE");
        //错误: Secondary index on COMPACT_VALUE column c is not yet supported for compact table
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c)");

        tableName = "IndexTest5";
        indexName = tableName + "_myindex";
        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " (pk int,i int, c set<text>, PRIMARY KEY(pk,i))");
        //错误: Indexes on collections are no yet supported
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c)");

        tableName = "IndexTest6";
        indexName = tableName + "_myindex";
        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " (pk int PRIMARY KEY, c text, i int)");
        //错误: Cannot add secondary index to already primarily indexed column pk
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (pk)");

        tableName = "IndexTest7";
        indexName = tableName + "_myindex";
        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " (pk int,i int, c text, PRIMARY KEY((pk,i),c))");
        //这样就允许了，因为pk字段只是PARTITION_KEY的一部分
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (pk)");
    }
    void test_CreateIndexStatement_announceMigration() throws Exception {
        tableName = "IndexTest8";
        indexName = tableName + "_myindex";
        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " (pk int PRIMARY KEY, c text)");
        tryExecute("CREATE CUSTOM INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c) USING 'my_index_class'");
        
        tableName = "IndexTest9";
        indexName = tableName + "_myindex";
        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " (pk int, c text, i int, b boolean, PRIMARY KEY(pk,c,i))");
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c)");
        
        tableName = "IndexTest10";
        indexName = tableName + "_myindex";
        //tryExecute("DROP TABLE IF EXISTS " + tableName);
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " (pk int,i int, c text, PRIMARY KEY(pk)) WITH COMPACT STORAGE");
        tryExecute("CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (c)");
    }

    void createTest() throws Exception {
        //test_CreateIndexStatement_validate();
        test_CreateIndexStatement_announceMigration();

        //        cql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + //
        //                "block_id uuid," + //
        //                "species text," + //
        //                "alias text," + //
        //                "population varint," + //
        //                "PRIMARY KEY (block_id, population)" + //
        //
        //                ") WITH compression = { 'sstable_compression' : 'DeflateCompressor', 'chunk_length_kb' : 64 }" + //
        //                "AND compaction = { 'class' : 'SizeTieredCompactionStrategy', 'min_threshold' : 6 }";
        //        execute();
        //
        //        cql = "DROP INDEX IF EXISTS " + indexName;
        //        tryExecute();
        //
        //        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (alias);";
        //        execute();
        //
        //        indexName = tableName + "_index_population";
        //        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (population);";
        //        execute();
        //
        //        tableName += "2";
        //        execute("CREATE TABLE IF NOT EXISTS " + tableName //
        //                + " ( block_id uuid, breed text, short_hair boolean, f1 text, f2 int, " //
        //                + "PRIMARY KEY ((block_id, breed), short_hair, f1)) WITH COMPACT STORAGE");
        //
        //        indexName = tableName + "_index_f2";
        //        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f2);";
        //        tryExecute();
        //
        //        tableName += "22";
        //        execute("CREATE TABLE IF NOT EXISTS " + tableName //
        //                + " ( block_id uuid, breed text, short_hair boolean, f1 text, f2 int, " //
        //                + "PRIMARY KEY (block_id))");
        //
        //        indexName = tableName + "_index_f2";
        //        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f2);";
        //        tryExecute();
        //
        //        tableName += "2";
        //        execute("CREATE TABLE IF NOT EXISTS " + tableName //
        //                + " ( block_id uuid, breed text, short_hair boolean, f1 text, " //
        //                + "PRIMARY KEY ((block_id, breed), f1)) WITH COMPACT STORAGE");
        //
        //        indexName = tableName + "_index_f1";
        //        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f1);";
        //        tryExecute();
        //
        //        //测试org.apache.cassandra.cql3.statements.CreateIndexStatement.announceMigration()中的
        //        //cd.setIndexType(IndexType.KEYS, Collections.<String, String>emptyMap());
        //        tableName += "2";
        //        execute("CREATE TABLE IF NOT EXISTS " + tableName //
        //                + " ( block_id uuid, breed text, short_hair boolean, f1 text, " //
        //                + "PRIMARY KEY ((block_id, breed))) WITH COMPACT STORAGE");
        //
        //        indexName = tableName + "_index_f1";
        //        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f1);";
        //        tryExecute();
    }

    void dropTest() throws Exception {

    }
}
