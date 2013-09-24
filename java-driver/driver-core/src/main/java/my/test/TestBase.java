package my.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.SocketOptions;
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

        builder.withCredentials("cassandra", "cassandra");

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
        initDefaults();
        init();

        startInternal();

        stop();
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
}
