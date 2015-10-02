对应Statistics.db文件


文件格式
=================
components头 {
	4字节:        components.size()

	components.size()个:
	{
		4字节:    MetadataType(enum类型，存放ordinal)
		4字节:    lastPosition (4 + (8 * sortedComponents.size()))，
				  这里的4就是components.size()占的字节数，8就是每个component占8字节，
				  lastPosition就是写完components头后此component在components头中的开始位置
	}
}

components体 {
	ValidationMetadata {
		UTF(String):  partitioner类名，如org.apache.cassandra.dht.Murmur3Partitioner
		8字节      :  bloomFilterFPChance (是一个Double值，但是按Double.doubleToLongBits转成Long)
			          见: org.apache.cassandra.io.util.AbstractDataOutput.writeDouble(double)
	}见: org.apache.cassandra.io.sstable.metadata.ValidationMetadata.ValidationMetadataSerializer.serialize(ValidationMetadata, DataOutputPlus)

    CompactionMetadata {
		4字节      :  ancestors.size()
		ancestors.size()个:
	    {
		    4字节:    ancestor
	    }
		4字节      :                   cardinalityEstimator.length
		cardinalityEstimator.length个: cardinalityEstimator
	}见: org.apache.cassandra.io.sstable.metadata.CompactionMetadata.CompactionMetadataSerializer.serialize(CompactionMetadata, DataOutputPlus)

	
    StatsMetadata {
        public void serialize(StatsMetadata component, DataOutputPlus out) throws IOException
        {
            EstimatedHistogram.serializer.serialize(component.estimatedRowSize, out);
            EstimatedHistogram.serializer.serialize(component.estimatedColumnCount, out);
            ReplayPosition.serializer.serialize(component.replayPosition, out);
            out.writeLong(component.minTimestamp);
            out.writeLong(component.maxTimestamp);
            out.writeInt(component.maxLocalDeletionTime);
            out.writeDouble(component.compressionRatio);
            StreamingHistogram.serializer.serialize(component.estimatedTombstoneDropTime, out);
            out.writeInt(component.sstableLevel);
            out.writeLong(component.repairedAt);
            out.writeInt(component.minColumnNames.size());
            for (ByteBuffer columnName : component.minColumnNames)
                ByteBufferUtil.writeWithShortLength(columnName, out);
            out.writeInt(component.maxColumnNames.size());
            for (ByteBuffer columnName : component.maxColumnNames)
                ByteBufferUtil.writeWithShortLength(columnName, out);
            out.writeBoolean(component.hasLegacyCounterShards);
        }
	}见: org.apache.cassandra.io.sstable.metadata.StatsMetadata.StatsMetadataSerializer.serialize(StatsMetadata, DataOutputPlus)
}
