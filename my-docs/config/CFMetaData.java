//默认17个CFMetaData
//system有15个
org.apache.cassandra.config.CFMetaData@da18ac[
  cfId=0290003c-977e-397c-ac3e-fdfdc01d626b
  ksName=system
  cfName=batchlog
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.UTF8Type)
  subcolumncomparator=<null>
  comment=uncommited batches
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UUIDType
  minCompactionThreshold=2
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=2 cap=2]]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]=ColumnDefinition{name=7772697474656e5f6174, validator=org.apache.cassandra.db.marshal.DateType, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=4 cap=4]=ColumnDefinition{name=64617461, validator=org.apache.cassandra.db.marshal.BytesType, index_type=null, index_name='null', component_index=0}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={min_threshold=2}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@19eda2c[
  cfId=55d76438-4e55-3f8b-9f6e-676d4af3976d
  ksName=system
  cfName=range_xfers
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.UTF8Type)
  subcolumncomparator=<null>
  comment=ranges requested for transfer here
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.BytesType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=12 cap=12]=ColumnDefinition{name=7265717565737465645f6174, validator=org.apache.cassandra.db.marshal.DateType, index_type=null, index_name='null', component_index=0}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@1cef4f7[
  cfId=7ad54392-bcdd-35a6-8417-4e047860b377
  ksName=system
  cfName=local
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.ColumnToCollectionType(7472756e63617465645f6174:org.apache.cassandra.db.marshal.MapType(org.apache.cassandra.db.marshal.UUIDType,org.apache.cassandra.db.marshal.BytesType),746f6b656e73:org.apache.cassandra.db.marshal.SetType(org.apache.cassandra.db.marshal.UTF8Type)))
  subcolumncomparator=<null>
  comment=information about the local node
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UTF8Type
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=3 cap=3]]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=4 cap=4]=ColumnDefinition{name=7261636b, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=12 cap=12]=ColumnDefinition{name=7472756e63617465645f6174, validator=org.apache.cassandra.db.marshal.MapType(org.apache.cassandra.db.marshal.UUIDType,org.apache.cassandra.db.marshal.BytesType), index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=6 cap=6]=ColumnDefinition{name=746f6b656e73, validator=org.apache.cassandra.db.marshal.SetType(org.apache.cassandra.db.marshal.UTF8Type), index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=14 cap=14]=ColumnDefinition{name=7468726966745f76657273696f6e, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=12 cap=12]=ColumnDefinition{name=636c75737465725f6e616d65, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=17 cap=17]=ColumnDefinition{name=676f737369705f67656e65726174696f6e, validator=org.apache.cassandra.db.marshal.Int32Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=12 cap=12]=ColumnDefinition{name=626f6f747374726170706564, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]=ColumnDefinition{name=646174615f63656e746572, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]=ColumnDefinition{name=706172746974696f6e6572, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=7 cap=7]=ColumnDefinition{name=686f73745f6964, validator=org.apache.cassandra.db.marshal.UUIDType, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=14 cap=14]=ColumnDefinition{name=736368656d615f76657273696f6e, validator=org.apache.cassandra.db.marshal.UUIDType, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=15 cap=15]=ColumnDefinition{name=72656c656173655f76657273696f6e, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]=ColumnDefinition{name=63716c5f76657273696f6e, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@14acfcd[
  cfId=37f71aca-7dc2-383b-a706-72528af04d4f
  ksName=system
  cfName=peers
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.ColumnToCollectionType(746f6b656e73:org.apache.cassandra.db.marshal.SetType(org.apache.cassandra.db.marshal.UTF8Type)))
  subcolumncomparator=<null>
  comment=known peers in the cluster
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.InetAddressType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=4 cap=4]]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]=ColumnDefinition{name=646174615f63656e746572, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=4 cap=4]=ColumnDefinition{name=7261636b, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]=ColumnDefinition{name=7270635f61646472657373, validator=org.apache.cassandra.db.marshal.InetAddressType, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=7 cap=7]=ColumnDefinition{name=686f73745f6964, validator=org.apache.cassandra.db.marshal.UUIDType, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=14 cap=14]=ColumnDefinition{name=736368656d615f76657273696f6e, validator=org.apache.cassandra.db.marshal.UUIDType, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=6 cap=6]=ColumnDefinition{name=746f6b656e73, validator=org.apache.cassandra.db.marshal.SetType(org.apache.cassandra.db.marshal.UTF8Type), index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=15 cap=15]=ColumnDefinition{name=72656c656173655f76657273696f6e, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@19113f8[
  cfId=59dfeaea-8db2-3341-91ef-109974d81484
  ksName=system
  cfName=peer_events
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.ColumnToCollectionType(68696e74735f64726f70706564:org.apache.cassandra.db.marshal.MapType(org.apache.cassandra.db.marshal.UUIDType,org.apache.cassandra.db.marshal.Int32Type)))
  subcolumncomparator=<null>
  comment=cf contains events related to peers
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.InetAddressType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=4 cap=4]]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=13 cap=13]=ColumnDefinition{name=68696e74735f64726f70706564, validator=org.apache.cassandra.db.marshal.MapType(org.apache.cassandra.db.marshal.UUIDType,org.apache.cassandra.db.marshal.Int32Type), index_type=null, index_name='null', component_index=0}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@ab54eb[
  cfId=2666e205-73ef-38b3-90fe-fecf96e8f0c7
  ksName=system
  cfName=hints
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.TimeUUIDType,org.apache.cassandra.db.marshal.Int32Type)
  subcolumncomparator=<null>
  comment=hints awaiting delivery
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UUIDType
  minCompactionThreshold=0
  maxCompactionThreshold=0
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=9 cap=9]]
  columnAliases=[java.nio.HeapByteBuffer[pos=0 lim=7 cap=7], java.nio.HeapByteBuffer[pos=0 lim=15 cap=15]]
  valueAlias=java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]
  column_metadata={}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={min_threshold=0, max_threshold=0}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@542529[
  cfId=9f5c6374-d485-3229-9a0a-5094af9ad1e3
  ksName=system
  cfName=IndexInfo
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.UTF8Type
  subcolumncomparator=<null>
  comment=indexes that have been completed
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UTF8Type
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]]
  columnAliases=[java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]]
  valueAlias=java.nio.HeapByteBuffer[pos=0 lim=0 cap=0]
  column_metadata={}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@53ab04[
  cfId=a1b676f3-0c5d-3276-bfd5-07cf43397004
  ksName=system
  cfName=NodeIdInfo
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.TimeUUIDType
  subcolumncomparator=<null>
  comment=counter node IDs
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UTF8Type
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=3 cap=3]]
  columnAliases=[java.nio.HeapByteBuffer[pos=0 lim=2 cap=2]]
  valueAlias=java.nio.HeapByteBuffer[pos=0 lim=0 cap=0]
  column_metadata={}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@e51b2c[
  cfId=b0f22357-4458-3cdb-9631-c43e59ce3676
  ksName=system
  cfName=schema_keyspaces
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.UTF8Type
  subcolumncomparator=<null>
  comment=keyspace definitions
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=8640
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UTF8Type
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=13 cap=13]]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=16 cap=16]=ColumnDefinition{name=73747261746567795f6f7074696f6e73, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null'}, java.nio.HeapByteBuffer[pos=0 lim=14 cap=14]=ColumnDefinition{name=64757261626c655f777269746573, validator=org.apache.cassandra.db.marshal.BooleanType, index_type=null, index_name='null'}, java.nio.HeapByteBuffer[pos=0 lim=14 cap=14]=ColumnDefinition{name=73747261746567795f636c617373, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null'}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@2acc57[
  cfId=45f5b360-24bc-3f83-a363-1034ea4fa697
  ksName=system
  cfName=schema_columnfamilies
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.UTF8Type)
  subcolumncomparator=<null>
  comment=ColumnFamily definitions
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=8640
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UTF8Type
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=13 cap=13]]
  columnAliases=[java.nio.HeapByteBuffer[pos=0 lim=17 cap=17]]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=4 cap=4]=ColumnDefinition{name=74797065, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=25 cap=25]=ColumnDefinition{name=636f6d70616374696f6e5f73747261746567795f636c617373, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]=ColumnDefinition{name=636f6d70617261746f72, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=24 cap=24]=ColumnDefinition{name=6d61785f636f6d70616374696f6e5f7468726573686f6c64, validator=org.apache.cassandra.db.marshal.Int32Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=18 cap=18]=ColumnDefinition{name=7265706c69636174655f6f6e5f7772697465, validator=org.apache.cassandra.db.marshal.BooleanType, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=22 cap=22]=ColumnDefinition{name=636f6d7072657373696f6e5f706172616d6574657273, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=7 cap=7]=ColumnDefinition{name=63616368696e67, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=13 cap=13]=ColumnDefinition{name=6b65795f76616c696461746f72, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=24 cap=24]=ColumnDefinition{name=64656661756c745f726561645f636f6e73697374656e6379, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=25 cap=25]=ColumnDefinition{name=64656661756c745f77726974655f636f6e73697374656e6379, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=24 cap=24]=ColumnDefinition{name=6d696e5f636f6d70616374696f6e5f7468726573686f6c64, validator=org.apache.cassandra.db.marshal.Int32Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=22 cap=22]=ColumnDefinition{name=626c6f6f6d5f66696c7465725f66705f6368616e6365, validator=org.apache.cassandra.db.marshal.DoubleType, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=26 cap=26]=ColumnDefinition{name=706f70756c6174655f696f5f63616368655f6f6e5f666c757368, validator=org.apache.cassandra.db.marshal.BooleanType, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=14 cap=14]=ColumnDefinition{name=636f6c756d6e5f616c6961736573, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=2 cap=2]=ColumnDefinition{name=6964, validator=org.apache.cassandra.db.marshal.Int32Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=9 cap=9]=ColumnDefinition{name=6b65795f616c696173, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=24 cap=24]=ColumnDefinition{name=6c6f63616c5f726561645f7265706169725f6368616e6365, validator=org.apache.cassandra.db.marshal.DoubleType, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]=ColumnDefinition{name=6b65795f616c6961736573, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=17 cap=17]=ColumnDefinition{name=64656661756c745f76616c696461746f72, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=18 cap=18]=ColumnDefinition{name=726561645f7265706169725f6368616e6365, validator=org.apache.cassandra.db.marshal.DoubleType, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=27 cap=27]=ColumnDefinition{name=636f6d70616374696f6e5f73747261746567795f6f7074696f6e73, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=16 cap=16]=ColumnDefinition{name=67635f67726163655f7365636f6e6473, validator=org.apache.cassandra.db.marshal.Int32Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=13 cap=13]=ColumnDefinition{name=737562636f6d70617261746f72, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]=ColumnDefinition{name=76616c75655f616c696173, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=7 cap=7]=ColumnDefinition{name=636f6d6d656e74, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@1fbfd6[
  cfId=296e9c04-9bec-3085-827d-c17d3df2122a
  ksName=system
  cfName=schema_columns
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.UTF8Type)
  subcolumncomparator=<null>
  comment=ColumnFamily column attributes
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=8640
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UTF8Type
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=13 cap=13]]
  columnAliases=[java.nio.HeapByteBuffer[pos=0 lim=17 cap=17], java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=15 cap=15]=ColumnDefinition{name=636f6d706f6e656e745f696e646578, validator=org.apache.cassandra.db.marshal.Int32Type, index_type=null, index_name='null', component_index=2}, java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]=ColumnDefinition{name=696e6465785f74797065, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=2}, java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]=ColumnDefinition{name=696e6465785f6e616d65, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=2}, java.nio.HeapByteBuffer[pos=0 lim=9 cap=9]=ColumnDefinition{name=76616c696461746f72, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=2}, java.nio.HeapByteBuffer[pos=0 lim=13 cap=13]=ColumnDefinition{name=696e6465785f6f7074696f6e73, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=2}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@6b9c84[
  cfId=7b9c509b-141a-3c3d-b1d1-e0dbc1f4720c
  ksName=system
  cfName=LocationInfo
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.BytesType
  subcolumncomparator=<null>
  comment=unused
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.BytesType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={}
  bloomFilterFpChance=<null>
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@1be16f5[
  cfId=58e77918-fd09-3654-95fa-02cc3818edf6
  ksName=system
  cfName=HintsColumnFamily
  cfType=Super
  comparator=org.apache.cassandra.db.marshal.BytesType
  subcolumncomparator=org.apache.cassandra.db.marshal.BytesType
  comment=unused
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.BytesType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={}
  bloomFilterFpChance=<null>
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@d56b37[
  cfId=0e50bdad-d185-337c-ae1d-d47e162662de
  ksName=system
  cfName=Migrations
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.TimeUUIDType
  subcolumncomparator=<null>
  comment=unused
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.BytesType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={}
  bloomFilterFpChance=<null>
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@171f189[
  cfId=e966c40e-4498-3246-95a8-8c18a7f0b2e4
  ksName=system
  cfName=Schema
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.UTF8Type
  subcolumncomparator=<null>
  comment=unused
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.BytesType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={}
  bloomFilterFpChance=<null>
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]

//system_traces有两个
org.apache.cassandra.config.CFMetaData@90832e[
  cfId=c5e99f16-8677-3914-b17e-960613512345
  ksName=system_traces
  cfName=sessions
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.ColumnToCollectionType(706172616d6574657273:org.apache.cassandra.db.marshal.MapType(org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.UTF8Type)))
  subcolumncomparator=<null>
  comment=traced sessions
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UUIDType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]]
  columnAliases=[]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]=ColumnDefinition{name=6475726174696f6e, validator=org.apache.cassandra.db.marshal.Int32Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]=ColumnDefinition{name=706172616d6574657273, validator=org.apache.cassandra.db.marshal.MapType(org.apache.cassandra.db.marshal.UTF8Type,org.apache.cassandra.db.marshal.UTF8Type), index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]=ColumnDefinition{name=737461727465645f6174, validator=org.apache.cassandra.db.marshal.DateType, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=7 cap=7]=ColumnDefinition{name=72657175657374, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=0}, java.nio.HeapByteBuffer[pos=0 lim=11 cap=11]=ColumnDefinition{name=636f6f7264696e61746f72, validator=org.apache.cassandra.db.marshal.InetAddressType, index_type=null, index_name='null', component_index=0}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]
org.apache.cassandra.config.CFMetaData@1724a9d[
  cfId=8826e8e9-e16a-3728-8753-3bc1fc713c25
  ksName=system_traces
  cfName=events
  cfType=Standard
  comparator=org.apache.cassandra.db.marshal.CompositeType(org.apache.cassandra.db.marshal.TimeUUIDType,org.apache.cassandra.db.marshal.UTF8Type)
  subcolumncomparator=<null>
  comment=
  readRepairChance=0.0
  dclocalReadRepairChance=0.0
  replicateOnWrite=true
  gcGraceSeconds=0
  defaultValidator=org.apache.cassandra.db.marshal.BytesType
  keyValidator=org.apache.cassandra.db.marshal.UUIDType
  minCompactionThreshold=4
  maxCompactionThreshold=32
  keyAliases=[java.nio.HeapByteBuffer[pos=0 lim=10 cap=10]]
  columnAliases=[java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]]
  valueAlias=<null>
  column_metadata={java.nio.HeapByteBuffer[pos=0 lim=6 cap=6]=ColumnDefinition{name=736f75726365, validator=org.apache.cassandra.db.marshal.InetAddressType, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=6 cap=6]=ColumnDefinition{name=746872656164, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=8 cap=8]=ColumnDefinition{name=6163746976697479, validator=org.apache.cassandra.db.marshal.UTF8Type, index_type=null, index_name='null', component_index=1}, java.nio.HeapByteBuffer[pos=0 lim=14 cap=14]=ColumnDefinition{name=736f757263655f656c6170736564, validator=org.apache.cassandra.db.marshal.Int32Type, index_type=null, index_name='null', component_index=1}}
  compactionStrategyClass=class org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy
  compactionStrategyOptions={}
  compressionOptions={sstable_compression=org.apache.cassandra.io.compress.SnappyCompressor}
  bloomFilterFpChance=0.01
  caching=KEYS_ONLY
  populateIoCacheOnFlush=false
]