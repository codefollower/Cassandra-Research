package my.test.cql3.statements;

import my.test.TestBase;

public class CreateIndexStatementTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new CreateIndexStatementTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        cql = "DROP TABLE myks.CreateIndexStatementTest";
        tryExecute();
        cql = "CREATE TABLE myks.CreateIndexStatementTest (" + //
                "block_id uuid," + //
                "species text," + //
                "alias text," + //
                "population varint," + //
                "PRIMARY KEY (block_id, population)" + //

                ") WITH compression = { 'sstable_compression' : 'DeflateCompressor', 'chunk_length_kb' : 64 }" + //
                "AND compaction = { 'class' : 'SizeTieredCompactionStrategy', 'min_threshold' : 6 }";
        execute();

        
        cql = "DROP INDEX CreateIndexStatementIndex";
        tryExecute();
        cql = "CREATE INDEX CreateIndexStatementIndex ON myks.CreateIndexStatementTest (alias);";
        execute();
    }
}
