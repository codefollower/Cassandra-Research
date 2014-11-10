入口:
org.apache.cassandra.db.compaction.CompactionManager.submitBackground(ColumnFamilyStore)

在org.apache.cassandra.service.CassandraDaemon.setup()中启动了一个后台任务，
每5分钟调用一次， 5分钟是固定的，不能改。


抽象基类org.apache.cassandra.db.compaction.AbstractCompactionStrategy

可以配置3种compaction
===================================
DateTieredCompactionStrategy
SizeTieredCompactionStrategy
LeveledCompactionStrategy

建表时通过compaction参数来配置，compaction参数的值是一个json风格的map，如:
CREATE TABLE IF NOT EXISTS test (block_id uuid PRIMARY KEY, species text)
  WITH compaction = { 'class' : 'LeveledCompactionStrategy', 'sstable_size_in_mb' : 50 }

3种compaction一些共用的选项:
==============================
tombstone_threshold            //默认0.2f;
tombstone_compaction_interval  //默认86400秒，也就是一天
unchecked_tombstone_compaction //默认false
enabled                        //默认true
==============================
这4个选项在AbstractCompactionStrategy.validateOptions(Map<String, String>)中检查指定的值是否合法


然后，每个不同compaction类有自己的专用选项:

DateTieredCompactionStrategy
==============================
timestamp_resolution //默认以MICROSECONDS为时间单位，
                     //可以指定MICROSECONDS、HOURS、DAYS这样的字符串，
					 //对应java.util.concurrent.TimeUnit中的枚举常量名

max_sstable_age_days //默认365天
base_time_seconds    //默认3600秒，也就是一小时
==============================



SizeTieredCompactionStrategy
==============================
min_sstable_size   //默认50MB
bucket_low         //默认0.5
bucket_high        //默认1.5
cold_reads_to_omit //默认0.05
==============================



LeveledCompactionStrategy
==============================
sstable_size_in_mb //默认1MB
==============================


有一些遗留问题值得提一下:

1. 在SizeTieredCompactionStrategy和DateTieredCompactionStrategy中配置min_threshold和max_threshold也是允许的，只是被忽略。
   min_threshold和max_threshold这两个选项已经不在使用。

2. 因为LeveledCompactionStrategy在验证选项时会调用SizeTieredCompactionStrategyOptions.validateOptions，
   所以SizeTieredCompactionStrategy上面那4个选项能出现在LeveledCompactionStrategy中，只是被忽略,
   但是min_threshold和max_threshold不可以出现在LeveledCompactionStrategy中。
