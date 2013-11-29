1. IO模块生成的文件:

	为每一个表(也叫列族)生成的文件数最多是9个:
	Data.db
	Index.db
	Filter.db
	Summary.db
	CompressionInfo.db
	Statistics.db
	TOC.txt
	CRC.db
	Digest.sha1


	其中CRC.db、Digest.sha1通常情况下不生成，
	一般只生成前面7个，
	TOC.txt中存放的是生成的文件名目录
	TOC 是"Table Of Contents"的首字母缩写，
	如果生成了前面7个文件，那么TOC.txt的内容就是:
	==========================================
	Data.db
	Index.db
	Filter.db
	Summary.db
	CompressionInfo.db
	Statistics.db
	TOC.txt (把自己也包含进来)
	==========================================


	文件具体用途在org.apache.cassandra.io.sstable.Component类描述。

2. 目录名和文件名的格式:

	目录名格式: <data_file_directories>\<ksname>\<cfname>
	其中<data_file_directories>对应cassandra.yaml配置文件中的data_file_directories参数(当配置多个目录时就均匀存放)
	<ksname>是keyspace名，<cfname>是列族名(在CQL的角度看就是表名)

	文件名格式: <ksname>-<cfname>-[tmp-][<version>-]<gen>-<component>
	其中<data_file_directories>对应cassandra.yaml配置文件中的data_file_directories参数(当配置多个目录时就均匀存放)

	假设data_file_directories参数是:"my-test-data\cluster\node1\data"
	目录名是"my-test-data\cluster\node1\data\system\schema_triggers"
	则目录名中的"my-test-data\cluster\node1\data"对应cassandra.yaml配置文件中的data_file_directories参数
	假如文件名是: "system-schema_triggers-jc-5-Data.db"
	则"system"对应<ksname>、"schema_triggers"对应<cfname>、"jc"对应<version>、"5"对应<gen>、"Data.db"对应<component>
	[tmp-]是可选的，这里没有，
	如果文件名是这样: "system-schema_triggers-tmp-jc-5-Data.db"，那么就有[tmp-]了

	具体描述在org.apache.cassandra.io.sstable.Descriptor类

