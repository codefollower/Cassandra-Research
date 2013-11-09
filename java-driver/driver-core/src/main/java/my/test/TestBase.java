package my.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.DataType;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;
import com.datastax.driver.core.Statement;
import com.datastax.driver.core.ProtocolOptions.Compression;

public abstract class TestBase {
    protected static final String KEYSPACE_NAME = "mytest";
    protected String tableName;
    protected String cql;
    protected Cluster cluster;
    protected Session session;
    protected String address = "127.0.0.1";

    private void initDefaults() throws Exception {
        Cluster.Builder builder = Cluster.builder().addContactPoint(address);
        // builder.withClusterName("My Cassandra Cluster");
        SocketOptions so = new SocketOptions();
        // 设置一下这两个参数，避免在用eclipse进行debug代码时出现超时
        so.setReadTimeoutMillis(60 * 60 * 1000);
        so.setConnectTimeoutMillis(60 * 60 * 1000);
        builder.withSocketOptions(so);

        //builder.withCredentials("cassandra", "cassandra");

        PoolingOptions po = new PoolingOptions();
        po.setCoreConnectionsPerHost(HostDistance.LOCAL, 1);
        po.setCoreConnectionsPerHost(HostDistance.REMOTE, 1);
        builder.withPoolingOptions(po);

        builder.withCompression(Compression.SNAPPY);
        cluster = builder.build();
        cluster.init();

        session = cluster.connect();
        session.execute("CREATE KEYSPACE IF NOT EXISTS " + KEYSPACE_NAME + " WITH replication "
                + "= {'class':'SimpleStrategy', 'replication_factor':1};");
        session.execute("USE " + KEYSPACE_NAME);
    }

    public void init() throws Exception {
    }

    public void start() throws Exception {
        try {
            initDefaults();
            init();

            startInternal();

        } finally {
            stop();
        }

    }

    public void stop() throws Exception {
        if (session != null)
            session.shutdown();
        if (cluster != null)
            cluster.shutdown();
    }

    public abstract void startInternal() throws Exception;

    public void execute() throws Exception {
        execute(cql);
    }

    public void execute(String cql) throws Exception {
        session.execute(cql);
    }

    public void execute(Statement statement) throws Exception {
        session.execute(statement);
    }

    public void tryExecute() {
        tryExecute(cql);
    }

    public void tryExecute(String cql) {
        try {
            session.execute(cql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printResultSet(ResultSet results) {
        ColumnDefinitions cd = results.getColumnDefinitions();
        int size = cd.size();

        for (Row row : results) {
            for (int i = 0; i < size; i++) {
                System.out.print(" ");
                DataType dt = cd.getType(i);
                switch (dt.getName()) {
                case TEXT:
                    System.out.print(row.getString(i));
                    break;
                case INT:
                    System.out.print(row.getInt(i));
                    break;
                case BIGINT:
                    System.out.print(row.getLong(i));
                    break;
                case UUID:
                    System.out.print(row.getUUID(i));
                    break;
                case SET:
                    System.out.print(row.getSet(i, String.class));
                    break;
                case LIST:
                    System.out.print(row.getList(i, String.class));
                    break;
                case MAP:
                    System.out.print(row.getMap(i, java.util.Date.class, String.class));
                    break;
                case COUNTER:
                    System.out.print(row.getLong(i));
                    break;
                default:
                    System.out.print(row.getString(i));
                    break;
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
