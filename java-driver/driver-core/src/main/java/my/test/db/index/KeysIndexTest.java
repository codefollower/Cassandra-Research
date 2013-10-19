package my.test.db.index;

import com.datastax.driver.core.ConsistencyLevel;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.SimpleStatement;

import my.test.TestBase;

public class KeysIndexTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new KeysIndexTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        tableName = "KeysIndexTest";

        create();
        insert();
        select();
    }

    void create() throws Exception {
        execute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, short_hair boolean, f1 text, " //
                + "PRIMARY KEY (block_id))");

        //存储到my-test-data\data\mytest\keysindextest\mytest-keysindextest.KeysIndexTest_index_f1-ja-1-Data.db文件
        String indexName = tableName + "_index_f1";
        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f1)";
        execute();
    }

    void insert() throws Exception {
        for (int i = 0; i < 2; i++)
            execute("INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (" + i + ", true, 'ab" + i + "')");
    }

    void select() {
        String cql = "SELECT * FROM " + tableName //
                + " WHERE block_id in = 1";
        cql = "SELECT * FROM " + tableName //
                + " WHERE block_id in(1,0)";
        SimpleStatement stmt = new SimpleStatement(cql);
        stmt.setConsistencyLevel(ConsistencyLevel.TWO);
        ResultSet results = session.execute(stmt);

        System.out.println(String.format("%-30s\t%-20s\t%-20s\n%s", "block_id", "short_hair", "f1",
                "-------------------------------+-----------------------+--------------------"));
        for (Row row : results) {
            System.out.println(String.format("%-30s\t%-20s\t%-20s", row.getInt("block_id"), row.getBool("short_hair"),
                    row.getString("f1")));
        }
        System.out.println();
    }
}
