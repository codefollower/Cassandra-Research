对应Summary.db文件，表示索引概要文件

相关的类是: 
org.apache.cassandra.io.sstable.IndexSummaryBuilder
org.apache.cassandra.io.sstable.IndexSummary


文件格式
=================

keys.size个:
{
	4字节:             key在概要文件的开始位置
}
keys.size个:
{
	key.length个字节:  key本身的字节
	8字节:             key在写入索引文件时所在的位置
}


例如:
keys = ["a", "b", "c", "d"]
indexPositions = [0, 2, 4, 6]

那么索引概要文件的内容是

字节范围 值
==================
0-3:     16 //key在概要文件的开始位置
4-7:     25
8-11:    34
12-15:   43

16:      a //key本身的字节
17-24:   0 //key在写入索引文件时所在的位置

25:      b
26-33:   2

34:      c
35-42:   4

43:      d
44-51:   6
==================

参考org.apache.cassandra.io.sstable.IndexSummaryBuilder.build

