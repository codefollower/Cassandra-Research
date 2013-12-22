Cassandra的表中的列细分为4中类型:
对应org.apache.cassandra.config.ColumnDefinition.Kind类:
    public enum Kind
    {
        PARTITION_KEY, //分区键
        CLUSTERING_COLUMN, //聚簇列
        REGULAR, //普通列
        COMPACT_VALUE; //紧凑列
	}


org.apache.cassandra.db.composites包中有东西都与聚簇列相关

两对关健词:
Sparse(稀疏)与Dense(稠密) //与数据库中的稀疏索引和稠密索引有相似之处
Simple(单一的)与Compound(复合的)

在建表时:
1. 没有定义聚簇列
	1.1 使用了COMPACT STORAGE，那么使用SimpleSparseCellNameType(包装类型是UTF8Type)
	1.2 没有使用COMPACT STORAGE
		1.2.1 普通列中有集合类型(CollectionType)，那么使用CompoundSparseCellNameType.WithCollection
		1.2.2 没有，则使用CompoundSparseCellNameType

2. 定义了聚簇列
	2.1 只有一个聚簇列并且使用了COMPACT STORAGE，那么使用SimpleDenseCellNameType(包装类型是此聚簇列的类型)
	2.2 使用了COMPACT STORAGE，那么使用CompoundDenseCellNameType(包装类型是所有聚簇列的类型)
	2.3 没有使用COMPACT STORAGE
		2.3.1 普通列中有集合类型(CollectionType)，那么使用CompoundSparseCellNameType.WithCollection
		2.3.2 没有，则使用CompoundSparseCellNameType

由上面总结如下:
只有定义了聚簇列的情况下，并且使用了COMPACT STORAGE才会使用SimpleDenseCellNameType或CompoundDenseCellNameType
