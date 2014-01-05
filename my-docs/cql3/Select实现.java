先构建org.apache.cassandra.db.filter.IDiskAtomFilter

有org.apache.cassandra.db.filter.NamesQueryFilter
和org.apache.cassandra.db.filter.SliceQueryFilter


然后分两种情况读:
读具体的某一行
读多行(也就是一个range)

SliceFromReadCommand => 

org.apache.cassandra.db.SliceFromReadCommand.getRow(Keyspace)
	org.apache.cassandra.db.Keyspace.getRow(QueryFilter)
		org.apache.cassandra.db.ColumnFamilyStore.getColumnFamily(QueryFilter)
			org.apache.cassandra.db.ColumnFamilyStore.getTopLevelColumns(QueryFilter, int)
				org.apache.cassandra.db.CollationController.getTopLevelColumns()
					org.apache.cassandra.db.CollationController.collectAllData()
						org.apache.cassandra.db.filter.QueryFilter.getSSTableColumnIterator(SSTableReader)
							org.apache.cassandra.db.filter.SliceQueryFilter.getSSTableColumnIterator(SSTableReader, DecoratedKey)
								org.apache.cassandra.db.columniterator.SSTableSliceIterator.SSTableSliceIterator(SSTableReader, DecoratedKey, ColumnSlice[], boolean)
									org.apache.cassandra.db.columniterator.SimpleSliceReader.SimpleSliceReader(SSTableReader, RowIndexEntry, FileDataInput, Composite)
										org.apache.cassandra.config.CFMetaData.getOnDiskIterator(DataInput, int, Version)
											org.apache.cassandra.db.Cell.onDiskIterator(DataInput, int, Flag, int, Version, CellNameType)









