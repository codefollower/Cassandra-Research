MeteredFlusher
	个数: 1
	类名: org.apache.cassandra.db.MeteredFlusher
	频率: 固定每隔一妙唤醒一次
	在org.apache.cassandra.service.CassandraDaemon.setup()中启动

AutoCompaction
	个数: 1
	类名: org.apache.cassandra.db.compaction.CompactionManager.BackgroundCompactionTask
	频率: 固定每隔5分钟唤醒一次
	在org.apache.cassandra.service.CassandraDaemon.setup()中启动


