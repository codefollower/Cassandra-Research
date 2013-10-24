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
        //create();
        insert();
        //select();
    }

    void create() throws Exception {
        //此时建立的索引是CompositesIndexOnRegular
        cql = "CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, short_hair boolean, f1 text, " //
                + "PRIMARY KEY (block_id))";

        //此时建立的索引是KeysIndex
        cql = "CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, short_hair boolean, f1 text, " //
                + "PRIMARY KEY (block_id)) WITH COMPACT STORAGE";

        execute(cql);

        //存储到my-test-data\data\mytest\keysindextest\mytest-keysindextest.KeysIndexTest_index_f1-ja-1-Data.db文件
        String indexName = tableName + "_index_f1";
        cql = "CREATE INDEX IF NOT EXISTS " + indexName + " ON " + tableName + " (f1)";
        execute();
    }

    void insert() throws Exception {
        int i = 9;
        String cql = "INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (" + i + ", true, 'ab" + i + "')";
        SimpleStatement stmt = new SimpleStatement(cql);
        //stmt.setConsistencyLevel(ConsistencyLevel.TWO);
        //stmt.setConsistencyLevel(ConsistencyLevel.QUORUM);
        execute(stmt);
        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        for (i = 0; i < 1000; i++)
            execute("INSERT INTO " + tableName + "(block_id, short_hair, f1) VALUES (" + i + ", true, 'ab" + str + i + "')");
    }

    void select() {
        String cql = "SELECT * FROM " + tableName //
                + " WHERE block_id in = 1";
        cql = "SELECT * FROM " + tableName //
                + " WHERE block_id in(1,0)";

        cql = "SELECT * FROM " + tableName //
                + " WHERE block_id =9900000";

        //不支持按索引字段进行范围查询
        cql = "SELECT * FROM " + tableName + " WHERE f1 >'ab1'";

        cql = "SELECT * FROM " + tableName + " WHERE f1='ab9900000'";
        //cql = "SELECT * FROM " + tableName + " WHERE f1='ab9900000' and block_id = 900000";
        cql = "SELECT * FROM " + tableName + " WHERE token(block_id) >= 900000";
        SimpleStatement stmt = new SimpleStatement(cql);
        stmt.setConsistencyLevel(ConsistencyLevel.TWO);
        //stmt.setConsistencyLevel(ConsistencyLevel.QUORUM);
        //stmt.setConsistencyLevel(ConsistencyLevel.SERIAL);
        //stmt.setConsistencyLevel(ConsistencyLevel.LOCAL_SERIAL);
        stmt.setConsistencyLevel(ConsistencyLevel.ONE);
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
