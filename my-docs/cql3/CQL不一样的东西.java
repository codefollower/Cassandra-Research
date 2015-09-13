SQL只有where子句，
而CQL分开成where子句和if子句
where子句只能出现primary key(sharding key和聚簇列)
if子句不能出现primary key(sharding key和聚簇列)

where子句只能使用and，每个条件对应一个org.apache.cassandra.cql3.Relation
if子句也只能使用and，每个条件对应一个org.apache.cassandra.cql3.ColumnCondition


CQL中的标识符，如果不加双引号，都是小写，加双引号后保持原样
