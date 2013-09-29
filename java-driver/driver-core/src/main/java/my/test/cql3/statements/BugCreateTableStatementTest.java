package my.test.cql3.statements;

import com.datastax.driver.core.ResultSet;

import my.test.TestBase;

public class BugCreateTableStatementTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new BugCreateTableStatementTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        //        //clustering key中的字段不能是counter类型
        //        //错误是: counter type is not supported for PRIMARY KEY part java.nio.HeapByteBuffer[pos=0 lim=6 cap=6]
        //        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
        //                + " ( block_id uuid, breed text, emails counter," //
        //                + "PRIMARY KEY ((block_id, breed), emails)) WITH COMPACT STORAGE");
        //
        //        //但是加了CLUSTERING ORDER后就可绕过这个问题(这是一个bug)
        //        //不过也可以正常添加和查询记录，见my.test.cql3.statements.BugCreateTableStatementTest
        //        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
        //                + " ( block_id uuid, breed text, emails counter," //
        //                + "PRIMARY KEY ((block_id, breed), emails)) WITH COMPACT STORAGE " //
        //                + "AND CLUSTERING ORDER BY (emails DESC)");

        tableName = "BugCreateTableStatementTest";
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id int, breed text, emails counter," //
                + "PRIMARY KEY ((block_id, breed), emails)) WITH COMPACT STORAGE " //
                + "AND CLUSTERING ORDER BY (emails DESC)");

        execute("INSERT INTO " + tableName + "(block_id, breed, emails) VALUES (1, 'ab', 2)");

        String sql = "SELECT block_id, breed, emails FROM " + tableName + " WHERE block_id = 1 AND breed = 'ab'";
        ResultSet results = session.execute(sql);
        printResultSet(results);
    }
}
