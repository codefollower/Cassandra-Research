对应Index.db文件，表示索引文件

相关的类是: 
org.apache.cassandra.io.sstable.SSTableWriter.IndexWriter


文件格式
=================
forEach Partition {

	2字节:          partition key长度(L)，是指转变成ByteBuffer后的长度
	L字节:          partition key，是一个ByteBuffer

	RowIndexEntry {
		VInt字节:          Partition在写入数据文件(Data.db)所在的起始位置
		VInt字节:          promotedSize promote(促进, 发扬, 提升, 提拔, 晋升为)
						   一行有多列并且这些列的总长度大于配置参数column_index_size_in_kb(默认64kb)时promotedSize的值大于0，
						   此时会出现下面的IndexedEntry，否则promotedSize的值是0，不会有IndexedEntry。
		IndexedEntry {
			VInt字节:          partition header长度

			DeletionTime {
				4字节:                          localDeletionTime
				8字节:                          markedForDeleteAt
			} 见: org.apache.cassandra.db.DeletionTime.Serializer.serialize(DeletionTime, DataOutput)

			VInt字节:         IndexHelper.IndexInfo.size

			IndexHelper.IndexInfo.size个 {
				first聚簇(可能由多个聚簇列组成) {
					1字节:                          聚簇kind
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

				last聚簇(可能由多个聚簇列组成) {
					1字节:                          聚簇kind
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

				UnsignedVInt字节:               offset
				VInt字节:                       width-WIDTH_BASE
				1字节:                          endOpenMarker是否为null
				if endOpenMarker不为null {
					DeletionTime { 
						4字节:      localDeletionTime
						8字节:      markedForDeleteAt
					}
				}
			} 见: org.apache.cassandra.io.sstable.IndexHelper.IndexInfo.serialize(DataOutput)

			IndexHelper.IndexInfo.size个offset {
				4字节:      offset
			}
		}
	} 见: org.apache.cassandra.db.RowIndexEntry.Serializer.serialize(RowIndexEntry, DataOutput)
} 见: org.apache.cassandra.io.sstable.SSTableWriter.IndexWriter.append(DecoratedKey, RowIndexEntry)
