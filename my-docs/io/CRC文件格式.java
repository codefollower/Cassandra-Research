对应CRC.db文件，表示CRC文件，
使用org.apache.cassandra.utils.PureJavaCrc32，类似于java.util.zip.CRC32，但是性能更快。

相关的类是: 
org.apache.cassandra.io.util.DataIntegrityMetadata.ChecksumWriter


文件格式
=================
	4字节:              ChunkSize
	4字节:              checksum //会有多个，按每64K计算一次checksum



