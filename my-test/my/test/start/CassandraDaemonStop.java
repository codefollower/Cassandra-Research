package my.test.start;

import org.apache.cassandra.service.CassandraDaemon;

public class CassandraDaemonStop {
	public static void main(String[] args) {
		CassandraDaemon.stop(new String[] {}); // 无效，不能这样停止CassandraDaemon
	}
}
