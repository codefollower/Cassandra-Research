对应Data.db文件，表示数据文件

相关的类是: 
org.apache.cassandra.io.sstable.SSTableWriter

总是按行写，一个Data.db文件只存放一个表(也叫列族)的数据。


org.apache.cassandra.db.OnDiskAtom接口代表硬盘访问的最小原子单位
有6个子类:
org.apache.cassandra.db.Column
	org.apache.cassandra.db.CounterColumn
	org.apache.cassandra.db.CounterUpdateColumn
	org.apache.cassandra.db.DeletedColumn
	org.apache.cassandra.db.ExpiringColumn
org.apache.cassandra.db.RangeTombstone



在org.apache.cassandra.db.ColumnSerializer类定义了5种列MASK

列MASK {
    public final static int DELETION_MASK        = 0x01; //对应DeletedColumn
    public final static int EXPIRATION_MASK      = 0x02; //对应ExpiringColumn
    public final static int COUNTER_MASK         = 0x04; //对应CounterColumn
    public final static int COUNTER_UPDATE_MASK  = 0x08; //对应CounterUpdateColumn
    public final static int RANGE_TOMBSTONE_MASK = 0x10; //对应RangeTombstone
}
org.apache.cassandra.db.Column的MASK是0


文件格式
=================
<Row> {
	2字节:                 key.length
	key.length个字节:      key本身的字节
	DeletionTime {
		4字节:                          localDeletionTime
		8字节:                          markedForDeleteAt
	} 见: org.apache.cassandra.db.DeletionTime.Serializer.serialize(DeletionTime, DataOutput)

	多个<Column> {
		2字节:              列名.length
		列名.length个字节:  列名
		1字节:              列MASK
		
		如果是CounterColumn {
		8字节:              timestampOfLastDelete
		}

		如果是ExpiringColumn {
		4字节:              timeToLive
		4字节:              localDeletionTime
		}

		8字节:              timestamp
		4字节:              列值.length
		列值.length个字节:  列值
	} 见: org.apache.cassandra.db.ColumnSerializer.serialize(Column, DataOutput)
} 见: org.apache.cassandra.db.ColumnIndex.Builder的build和add

