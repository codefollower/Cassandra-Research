package my.test.cql3.statements;

import my.test.TestBase;

public class CreateColumnFamilyStatement extends TestBase {
    public static void main(String[] args) throws Exception {
        new CreateColumnFamilyStatement().start();
    }

    @Override
    public void startInternal() throws Exception {
        cql = "DROP TABLE myks.CreateColumnFamilyStatement";
        tryExecute();
        cql = "CREATE TABLE myks.CreateColumnFamilyStatement (" + //
                "block_id uuid," + //
                "species text," + //
                "alias text," + //
                "population varint," + //
                "PRIMARY KEY (block_id, population)" + //

                ") WITH compression = { 'sstable_compression' : 'DeflateCompressor', 'chunk_length_kb' : 64 }" + //
                "AND compaction = { 'class' : 'SizeTieredCompactionStrategy', 'min_threshold' : 6 }" + //
                " AND CLUSTERING ORDER BY (population DESC)" + //
                " AND COMPACT STORAGE";
        execute();

    }
}
