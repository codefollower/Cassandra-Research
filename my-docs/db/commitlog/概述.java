- 有两种commitlog同步方式:

	batch    批量同步，  对应类名: org.apache.cassandra.db.commitlog.BatchCommitLogService
	periodic 周期性同步，对应类名: org.apache.cassandra.db.commitlog.PeriodicCommitLogService

	可在cassandra.yaml中通过"commitlog_sync"参数设置

	默认使用periodic，可能会丢数据

	batch不会丢数据，但是比periodic慢



- 提交日志文件名格式:

	CommitLog-<version>-<id>.log

	<version>是固定的，每次修改提交日志文件内容的格式时都会增加，3.0版本的<version>是6，
	<id>是一个以毫秒为单位的时间戳
	取值规则如下，
	先算maxId，maxId是上一次生成的提交日志文件名中的所有<id>中的最大值,
	最后idBase = max(System.currentTimeMillis(), maxId + 1)

	例如:
	CommitLog-6-1444028269087.log
	<version> = 6，
	<id> = 1444028269087


	当在运行时要生成一个新的提交日志文件时，在idBase上面每次加1就可得到新的id



- 提交日志文件格式:

	文件头:
	===========================================================================
	4字节:      version
	8字节:      id
	2字节:      压缩参数构成的JSON字符串点用的字节数(size)
	size字节:   压缩参数构成的JSON字符串点用的字节
	4字节:      CRC32 checksum，对上面的内容求checksum
	===========================================================================


	文件内容格式:
	===========================================================================

	每次默认生成一个32M(可修改commitlog_segment_size_in_mb参数)的日志文件，写满后再生成另一个
	对记录的增加、删除、修改都被抽象成一个Mutation，
	每次往日志文件中增加一个Mutation时，除了Mutation本身的字节外，还要额外多加12字节


	格式:
	前4字节:   保存Mutation占用的字节数(size)
	5-8字节:   对size求CRC32 checksum，然后保存这个占4字节的checksum(为何要这样做？)
	size字节:  保存Mutation的字节
	最后4字节: 对Mutation占用的字节求CRC32 checksum，然后保存这个占4字节的checksum(前面对size求CRC32 checksum后并未reset)

	如果使用压缩，会对上面的内容压缩，然后再额外加4字节: 用来保存上面的内容长度


	每次同步到硬盘时还要加8字节的SYNC_MARKER(同步标记)
	前4字节:   nextMarker
	后4字节:   对id和filePos进行的CRC32 checksum
	===========================================================================



- 实现关键点:

	如果不使用日志压缩，32M的日志文件会使用Memory-mapped buffer(对应org.apache.cassandra.db.commitlog.MemoryMappedSegment)
	如果使用日志压缩:
	DeflateCompressor会直接分配32M的ON_HEAP buffer
	LZ4Compressor和SnappyCompressor都会分配32M的OFF_HEAP buffer
	(对应org.apache.cassandra.db.commitlog.CompressedSegment)

	如果有多个线程并发写日志，会在buffer中得到一个开始位置和长度，然后并发写到buffer中，
	最后依据是使用batch或periodic，把buffer中已写的内容同步到硬盘，batch会阻塞写线程，直到同步到硬盘为止。

