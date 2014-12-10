Insert
====================
所有的clustering列会加到普通列的列名前

同一个PartitionKey下的那些列可以指定不同的clustering列



Delete
====================
必须指定where
不能用delete xxx from这种格式删除partition_key和clustering_column这两种字段

where中必须指定partition_key


Update和Delete的where子句必须包含，where子句中只支持and，
并且只能出现partition_key和clustering_column，
并且只有partition_key和clustering_column能使用"="操作符，
并且只有partition_key能使用"in"操作符。


执行Insert、Update、Delete时都必须指定partition_key


Insert可以使用IF NOT EXISTS
而Update、Delete可以使用if子句
partition_key和clustering_column不能出现在if子句中



CompoundComposite

CompoundSparseCellName

CompoundSparseCellName.WithCollection

如果id是partition_key，
f2、f3是clustering_column，
f_set是set<int>，
那么DELETE f_set[1] FROM mytable WHERE id=1 and f2=1 and f3=2
CompoundComposite包含f2、f3的值，
CompoundSparseCellName包含f_set这个列名，
CompoundSparseCellName.WithCollection包含f_set[1]中的1，

CompoundSparseCellName.WithCollection的序列化格式:
==============================
2字节: isStatic (可选的，只有是static列时才会有)

会把clustering_column和f_set这个列名以及f_set[1]中的1转成ByteBuffer
然后按下面的格式存
{
	2字节:  ByteBuffer的长度(不能超过65536，也就是2的16次方
	ByteBuffer值(以字节形式存放)
    1字节:  分隔位，值固定是0
} 
见org.apache.cassandra.db.composites.AbstractComposite.toByteBuffer()


组合后的Composite的长度也不能大于65536

