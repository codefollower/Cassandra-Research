但使用压缩时，不但有Data.db文件，还会生成CompressionInfo.db文件

压缩后的数据还是放在Data.db文件，
CompressionInfo.db文件并不存放压缩后的数据，而是放与压缩相关的概要信息。

相关的类是: 
org.apache.cassandra.io.compress.CompressedSequentialWriter
org.apache.cassandra.io.compress.CompressionMetadata.Writer


文件格式
=================

Header 见：org.apache.cassandra.io.compress.CompressionMetadata.Writer.writeHeader(CompressionParameters)
==========
UTF(String):       对应org.apache.cassandra.io.compress.ICompressor接口实现类的简单类名(比如SnappyCompressor、LZ4Compressor)
4字节:             压缩选项个数(N)
N个 Options:
{
	UTF:           压缩选项名
	UTF:           压缩选项值
}

4字节:             chunkLength
8字节:             dataLength
4字节:             chunk个数(M)

Body 见: org.apache.cassandra.io.compress.CompressedSequentialWriter.flushData()
==========
8字节:             chunkOffset //M个

