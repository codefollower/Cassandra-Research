对应Index.db文件，表示索引文件

相关的类是: 
org.apache.cassandra.io.sstable.SSTableWriter.IndexWriter


文件格式
=================

按行写，一行一行排下来:

Row {
	2字节:                 key.length
	key.length个字节:      key本身的字节

	RowIndexEntry {
		8字节:             row在写入数据文件(Data.db)所在的起始位置
		4字节:             promotedSize promote(促进, 发扬, 提升, 提拔, 晋升为)
						   一行有多列并且这些列的总长度大于配置参数column_index_size_in_kb(默认64kb)时promotedSize的值大于0，
						   此时会出现下面的IndexedEntry，否则promotedSize的值是0，不会有IndexedEntry。
		IndexedEntry {
			DeletionTime {
				4字节:                          localDeletionTime
				8字节:                          markedForDeleteAt
			} 见: org.apache.cassandra.db.DeletionTime.Serializer.serialize(DeletionTime, DataOutput)

			4字节:         IndexHelper.IndexInfo.size

			IndexHelper.IndexInfo.size个 {
				2字节:                          firstColumnName.length
				firstColumnName.length个字节:   firstColumnName本身的字节

				2字节:                          lastColumnName.length
				lastColumnName.length个字节:    lastColumnName本身的字节

				8字节:                          offset
				8字节:                          width
			} 见: org.apache.cassandra.io.sstable.IndexHelper.IndexInfo.serialize(DataOutput)
		}
	} 见: org.apache.cassandra.db.RowIndexEntry.Serializer.serialize(RowIndexEntry, DataOutput)
} 见: org.apache.cassandra.io.sstable.SSTableWriter.IndexWriter.append(DecoratedKey, RowIndexEntry)
