从哪看起:
org.apache.cassandra.service.CassandraDaemon.main(String[])

cassandra java driver(https://github.com/datastax/java-driver/tree/3.0)

从cassandra java driver发起请求

请求转到cassandra时经过的模块如下:

transport -> cql3 -> service(重点是StorageProxy) -> db(先写commitlog再写Memtable) -> io(flush Memtable时触发)

如果StorageProxy中是转发到别的节点的，需要通过net模块进行
