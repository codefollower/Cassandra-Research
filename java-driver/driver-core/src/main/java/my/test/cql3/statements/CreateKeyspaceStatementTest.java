package my.test.cql3.statements;

import my.test.TestBase;

public class CreateKeyspaceStatementTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new CreateKeyspaceStatementTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        cql = "DROP KEYSPACE IF EXISTS CreateKeyspaceStatementTest";
        //KEYSPACE和SCHEMA是一样的
        cql = "DROP SCHEMA IF EXISTS CreateKeyspaceStatementTest";
        execute();

        //NetworkTopologyStrategy不能使用replication_factor
        cql = "CREATE KEYSPACE IF NOT EXISTS CreateKeyspaceStatementTest " + //
                "WITH replication = {'class':'NetworkTopologyStrategy', 'replication_factor':3} AND DURABLE_WRITES = true";
        //tryExecute();
        
        cql = "CREATE KEYSPACE IF NOT EXISTS CreateKeyspaceStatementTest3 " + //
                "WITH replication = {'class':'SimpleStrategy', 'replication_factor':3} AND DURABLE_WRITES = true";
        execute();

        //system是内部使用的KEYSPACE，不能与它相同
        cql = "CREATE KEYSPACE IF NOT EXISTS system " + //
                "WITH replication = {'class':'SimpleStrategy', 'replication_factor':3} AND DURABLE_WRITES = true";
        tryExecute();

        cql = "ALTER KEYSPACE CreateKeyspaceStatementTest " + //
                "WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
        execute();
    }
}
