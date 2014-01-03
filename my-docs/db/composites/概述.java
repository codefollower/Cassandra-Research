org.apache.cassandra.db.composites包中的东西主要分两块:

org.apache.cassandra.db.composites.Composite
org.apache.cassandra.db.composites.CType
围绕这两个接口做事

Composite延伸出列名
CType延伸出列类型



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
1. 没有定义聚簇列时都是Sparse
2. 只有定义了聚簇列的情况下，并且使用了COMPACT STORAGE才会使用SimpleDenseCellNameType或CompoundDenseCellNameType
3. 除了1和2之外的，也全是Sparse

CellNameType类型                            满足下列条件时使用
================================================================================
SimpleSparseCellNameType                    无聚簇列、使用COMPACT STORAGE
SimpleDenseCellNameType                     只有一个聚簇列、使用COMPACT STORAGE

CompoundDenseCellNameType                   有多个聚簇列、使用COMPACT STORAGE
CompoundSparseCellNameType                  0个或多个聚簇列、未使用COMPACT STORAGE、普通列中不包含Collection类型的列
CompoundSparseCellNameType.WithCollection   0个或多个聚簇列、未使用COMPACT STORAGE、普通列中包含Collection类型的列


Dense不允许在普通列中包含Collection类型的列


CellNameType类型                            AbstractType
================================================================================
SimpleSparseCellNameType                    UTF8Type
SimpleDenseCellNameType                     聚簇列的类型

CompoundDenseCellNameType                   CompositeType(所有聚簇列的类型)
CompoundSparseCellNameType                  CompositeType(所有聚簇列的类型)
CompoundSparseCellNameType.WithCollection   CompositeType(所有聚簇列的类型 + UTF8Type(用于列名本身的序列化) + ColumnToCollectionType)

基中ColumnToCollectionType是普通列中所有Collection类型的列的组合类型
