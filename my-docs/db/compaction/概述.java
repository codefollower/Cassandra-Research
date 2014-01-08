入口:
org.apache.cassandra.db.compaction.CompactionManager.submitBackground(ColumnFamilyStore)

在org.apache.cassandra.service.CassandraDaemon.setup()中启动了一个后台任务，
每5分钟调用一次， 5分钟是固定的，不能改。