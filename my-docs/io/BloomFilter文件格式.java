对应Filter.db文件，表示BloomFilter，一个表只有一个Filter.db文件

文件格式
=================
{
	4字节:             hashCount

	bitset(OffHeapBitSet) {
		4字节:      (bytes.size() / 8)个
        
		(bytes.size())个 {
		     8字节:     value;
		} 见org.apache.cassandra.utils.obs.OffHeapBitSet.serialize(DataOutput)
	}见org.apache.cassandra.utils.BloomFilterSerializer.serialize(BloomFilter, DataOutputPlus)
} 
见org.apache.cassandra.io.sstable.format.big.BigTableWriter.IndexWriter.close()

