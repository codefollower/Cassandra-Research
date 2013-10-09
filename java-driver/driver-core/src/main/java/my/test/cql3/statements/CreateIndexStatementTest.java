package my.test.cql3.statements;

import my.test.TestBase;

public class CreateIndexStatementTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new CreateIndexStatementTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        tableName = "CreateIndexStatementTest";
        cql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + //
                "block_id uuid," + //
                "species text," + //
                "alias text," + //
                "population varint," + //
                "PRIMARY KEY (block_id, population)" + //

                ") WITH compression = { 'sstable_compression' : 'DeflateCompressor', 'chunk_length_kb' : 64 }" + //
                "AND compaction = { 'class' : 'SizeTieredCompactionStrategy', 'min_threshold' : 6 }";
        execute();

        String indexName = tableName + "_index_alias";
        cql = "DROP INDEX IF EXISTS " + indexName;
        tryExecute();

        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (alias);";
        execute();

        indexName = tableName + "_index_population";
        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (population);";
        execute();

        tableName += "2";
        execute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean, f1 text, f2 int, " //
                + "PRIMARY KEY ((block_id, breed), short_hair, f1)) WITH COMPACT STORAGE");

        indexName = tableName + "_index_f2";
        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f2);";
        tryExecute();

        tableName += "22";
        execute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean, f1 text, f2 int, " //
                + "PRIMARY KEY (block_id))");

        indexName = tableName + "_index_f2";
        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f2);";
        tryExecute();

        tableName += "2";
        execute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean, f1 text, " //
                + "PRIMARY KEY ((block_id, breed), f1)) WITH COMPACT STORAGE");

        indexName = tableName + "_index_f1";
        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f1);";
        tryExecute();
        
        
        //测试org.apache.cassandra.cql3.statements.CreateIndexStatement.announceMigration()中的
        //cd.setIndexType(IndexType.KEYS, Collections.<String, String>emptyMap());
        tableName += "2";
        execute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean, f1 text, " //
                + "PRIMARY KEY ((block_id, breed))) WITH COMPACT STORAGE");

        indexName = tableName + "_index_f1";
        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f1);";
        tryExecute();
    }
}
