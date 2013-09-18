package my.test;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public abstract class TestBase {
    protected String cql;
    protected Cluster cluster;
    protected Session session;
    protected String address = "127.0.0.1";

    private void initDefaults() throws Exception {
        cluster = Cluster.builder().addContactPoint(address).build();
        //        Metadata metadata = cluster.getMetadata();
        //        System.out.printf("Connected to cluster: %s\n", metadata.getClusterName());
        //        for (Host host : metadata.getAllHosts()) {
        //            System.out.printf("Datatacenter: %s; Host: %s; Rack: %s\n", //
        //                    host.getDatacenter(), host.getAddress(), host.getRack());
        //        }

        session = cluster.connect();
        cql = "CREATE KEYSPACE myks " + //
                "WITH replication = {'class':'SimpleStrategy', 'replication_factor':1}";
        tryExecute();
        cql = null;
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
        session.execute(cql);
    }

    public void tryExecute() {
        try {
            session.execute(cql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
