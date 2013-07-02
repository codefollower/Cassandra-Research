运行流程分析:

-> initLog4j()
	可以通过下面两行指定日志配置文件:
	System.setProperty("log4j.defaultInitOverride", "true");
	System.setProperty("log4j.configuration", "my-log4j-server.properties");

-> main(String[])
	-> org.apache.cassandra.service.CassandraDaemon.activate()
		-> org.apache.cassandra.service.CassandraDaemon.setup()
			-> org.apache.cassandra.utils.CLibrary.tryMlockall() 看一下本地库是否可用