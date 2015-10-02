对应Summary.db文件，表示索引概要文件

相关的类是: 
org.apache.cassandra.io.sstable.IndexSummaryBuilder
org.apache.cassandra.io.sstable.IndexSummary


参考org.apache.cassandra.io.sstable.IndexSummaryBuilder.build


3.0新版本:

文件格式
=================
4字节:   minIndexInterval(默认是128)
4字节:   offsetCount
8字节:   offHeapSize
if (withSamplingLevel) {
	4字节:   samplingLevel
	4字节:   sizeAtFullSampling
}

offsetCount个offset {
	4字节:   offset
}
entries个字节:    entries
=================
代码: org.apache.cassandra.io.sstable.IndexSummary.IndexSummarySerializer.serialize(IndexSummary, DataOutputPlus, boolean)


offsets和entries分开，
offsets存放的是entries的相对位置

字节范围 值
==================
offsets
===========
0-3:     0  //key在概要文件的开始位置
4-7:     9
8-11:    18
12-15:   29
===========

entries
===========
0:       a //key本身的字节
1-8:     0 //key在写入索引文件时所在的位置

9:       b
10-17:   2

18:      c
19-28:   4

29:      d
30-37:   6
===========
==================

老版本:

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


