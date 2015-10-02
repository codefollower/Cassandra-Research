文件格式
=================
forEach Partition {

	PartitionHeader {
		2字节:          partition key长度(L)，是指转变成ByteBuffer后的长度
		L字节:          partition key，是一个ByteBuffer

		PartitionLevelDeletion 
			(代码: org.apache.cassandra.db.DeletionTime.Serializer.serialize(DeletionTime, DataOutputPlus))
		{
			DeletionTime {
				4字节:      localDeletionTime
				8字节:      markedForDeleteAt
			}
		}

		Static Row (可选的，一个Partition只有一个静态行)
			(代码: org.apache.cassandra.db.rows.UnfilteredSerializer.serialize(Row, SerializationHeader, DataOutputPlus, int))
		{
			1字节:       flags
			1字节:       extendedFlags(可选的)
			VInt字节:    Timestamp (可选的)
			VInt字节:    TTL (可选的)
			VInt字节:    LocalDeletionTime (可选的)

			DeletionTime (可选的) { 
				4字节:      localDeletionTime
				8字节:      markedForDeleteAt
			}

			没有包含所有静态列时 { 
				//TODO
			}

			forEach 静态行中的列 { 
				if 简单列 { 
					1字节:       flags
					VInt字节:    Timestamp (可选的)
					VInt字节:    LocalDeletionTime (可选的)
					VInt字节:    TTL (可选的)
					if 列类型对应的值长度固定 {
						n字节:      列值 (其中n依据不同列类型而定，比如int类型是4字节)
					} else {
						VInt字节:   列值长度(n)经过编码后占用的字节数
						n字节:      列值
					}
				} else if 复杂列 {
				}
			}
		}
	}

	forEach 非静态行 {
		1字节:       flags
		1字节:       extendedFlags(可选的)

		聚簇列 (代码: org.apache.cassandra.db.Clustering.Serializer.serialize)
		{
			VInt字节:    Header
			forEach 聚簇列 {
				if 列类型对应的值长度固定 {
					n字节:      列值 (其中n依据不同列类型而定，比如int类型是4字节)
				} else {
					VInt字节:   列值长度(n)经过编码后占用的字节数
					n字节:      列值
				}
			}
		}
		
		VInt字节:    Timestamp (可选的)
		VInt字节:    TTL (可选的)
		VInt字节:    LocalDeletionTime (可选的)

		DeletionTime (可选的) { 
			4字节:      localDeletionTime
			8字节:      markedForDeleteAt
		}

		没有包含所有列时 { 
				//TODO
		}

		forEach 非静态行中的列 { 
				if 简单列 { 
					1字节:       flags
					VInt字节:    Timestamp (可选的)
					VInt字节:    LocalDeletionTime (可选的)
					VInt字节:    TTL (可选的)
					if 列类型对应的值长度固定 {
						n字节:      列值 (其中n依据不同列类型而定，比如int类型是4字节)
					} else {
						VInt字节:   列值长度(n)经过编码后占用的字节数
						n字节:      列值
					}
				} else if 复杂列 {
					DeletionTime (可选的) { 
						4字节:      localDeletionTime
						8字节:      markedForDeleteAt
					}

					VInt字节:    cellsCount
					forEach 子列 {
						1字节:       flags
						VInt字节:    Timestamp (可选的)
						VInt字节:    LocalDeletionTime (可选的)
						VInt字节:    TTL (可选的)

						CellPath {
							VInt字节:   列值长度(n)经过编码后占用的字节数
							n字节:      列值
						}

						if 列类型对应的值长度固定 {
							n字节:      列值 (其中n依据不同列类型而定，比如int类型是4字节)
						} else {
							VInt字节:   列值长度(n)经过编码后占用的字节数
							n字节:      列值
						}
					}
				}
		}
	}

	1字节:      EndOfPartition，固定是1
}

IO层不负责对多个Partition排序，由IO层代码的调用者事先排好序，
通常是由不同的IPartitioner子类来排，
如果是Murmur3Partitioner，会对partition key进行hash后，按hash值的大小来排好序，
这样在写入数据文件后，虽然存的还是partition key，但是并不是按partition key的顺序来排的，
在进行流式化时很有用，因为流式化是按range来读数据文件的，
只要根据索引概要文件计算一下partition key的hash值，就能确定是否在指定的range中，
然后再经过索引概要文件 -> 索引文件 -> 数据文件，就能确定要读取的数据块。


