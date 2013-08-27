org.apache.cassandra.db.Table 对应的是Keyspace
org.apache.cassandra.db.ColumnFamilyStore 才对应列族
Table包含ColumnFamilyStore


但是通过CQL的CREATE TABLE命令建表时，这时的表反而对应org.apache.cassandra.db.ColumnFamilyStore
而CREATE KEYSPACE命令才是对应org.apache.cassandra.db.Table

这些是历史问题
