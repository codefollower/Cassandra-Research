Insert
====================
所有的clustering列会加到普通列的列名前

同一个PartitionKey下的那些列可以指定不同的clustering列



Delete
====================
必须指定where


Update和Delete的where子句必须包含，where子句中只支持and，
并且只能出现PARTITION_KEY和CLUSTERING_COLUMN，
并且只有PARTITION_KEY和CLUSTERING_COLUMN能使用"="操作符，
并且只有PARTITION_KEY能使用"in"操作符。


