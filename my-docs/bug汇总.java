- RowFilter.Expression.Serializer.deserialize(DataInputPlus, int, CFMetaData)
  把value = CompositeType.extractComponent(composite, 0)改成value = CompositeType.extractComponent(composite, 1)

- org.apache.cassandra.db.lifecycle.LogFile.make(File, int)
  如果没启用assert，是不会调用下面那行assert matcher.matches()的，
  这会导致java.lang.IllegalStateException: No match found

- org.apache.cassandra.config.ParameterizedClass.ParameterizedClass(Map<String, ?>)

      例如在cassandra.yaml中定义
      seed_provider:
          - class_name: org.apache.cassandra.locator.SimpleSeedProvider
            parameters:
                - seeds: "127.0.0.1"
      p.get("parameters")是一个List，List.get(0)才是Map<String, String>
        
      这种方式有bug，取到的值有可能不是String类型
      例如下面这个配置
        commitlog_compression:
            - class_name: LZ4Compressor
              parameters:
                  - chunk_length_in_kb: 64
      就抛出
      Caused by: java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.CharSequence
        at org.apache.cassandra.schema.CompressionParams.copyOptions(CompressionParams.java:276) ~[main/:na]
        at org.apache.cassandra.schema.CompressionParams.createCompressor(CompressionParams.java:266) ~[main/:na]
        at org.apache.cassandra.db.commitlog.CommitLog.<init>(CommitLog.java:103) ~[main/:na]
        at org.apache.cassandra.db.commitlog.CommitLog.construct(CommitLog.java:84) ~[main/:na]
        at org.apache.cassandra.db.commitlog.CommitLog.<clinit>(CommitLog.java:63) ~[main/:na]
        ... 19 common frames omitted