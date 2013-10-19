package my.test.db.index;

import my.test.TestBase;

public class KeysIndexTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new KeysIndexTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        tableName = "KeysIndexTest2";

        //create();
        insert();
    }

    void create() throws Exception {
        execute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, short_hair boolean, f1 text, " //
                + "PRIMARY KEY (block_id)) WITH COMPACT STORAGE");

        //存储到my-test-data\data\mytest\keysindextest\mytest-keysindextest.KeysIndexTest_index_f1-ja-1-Data.db文件
        String indexName = tableName + "_index_f1";
        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f1)";
        execute();
    }

    void insert() throws Exception {
        for (int i = 0; i < 2; i++)
            execute("INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (" + i + ", true, 'ab" + i + "')");
    }
}
