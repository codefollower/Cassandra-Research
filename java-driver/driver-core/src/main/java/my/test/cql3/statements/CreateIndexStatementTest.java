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
    }
}
