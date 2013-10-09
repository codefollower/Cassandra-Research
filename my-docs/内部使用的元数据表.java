内部有3个keyspace:
system
system_traces
system_auth


内部有19个表(或称列族):
属于system有14个:
====================================================================
CREATE TABLE "IndexInfo" (table_name text,index_name text,PRIMARY KEY (table_name, index_name)) WITH COMPACT STORAGE AND COMMENT='indexes that have been completed'
CREATE TABLE "NodeIdInfo" (key text,id timeuuid,PRIMARY KEY (key, id)) WITH COMPACT STORAGE AND COMMENT='counter node IDs'
CREATE TABLE schema_keyspaces (keyspace_name text PRIMARY KEY,durable_writes boolean,strategy_class text,strategy_options text) WITH COMPACT STORAGE AND COMMENT='keyspace definitions' AND gc_grace_seconds=8640
CREATE TABLE schema_columnfamilies (keyspace_name text,columnfamily_name text,type text,comparator text,subcomparator text,comment text,read_repair_chance double,local_read_repair_chance double,replicate_on_write boolean,gc_grace_seconds int,default_validator text,key_validator text,min_compaction_threshold int,max_compaction_threshold int,memtable_flush_period_in_ms int,key_aliases text,bloom_filter_fp_chance double,caching text,default_time_to_live int,compaction_strategy_class text,compression_parameters text,value_alias text,column_aliases text,compaction_strategy_options text,speculative_retry text,populate_io_cache_on_flush boolean,index_interval int,dropped_columns map<text, bigint>,PRIMARY KEY (keyspace_name, columnfamily_name)) WITH COMMENT='ColumnFamily definitions' AND gc_grace_seconds=8640
CREATE TABLE schema_columns (keyspace_name text,columnfamily_name text,column_name text,validator text,index_type text,index_options text,index_name text,component_index int,type text,PRIMARY KEY(keyspace_name, columnfamily_name, column_name)) WITH COMMENT='ColumnFamily column attributes' AND gc_grace_seconds=8640
CREATE TABLE schema_triggers (keyspace_name text,columnfamily_name text,trigger_name text,trigger_options map<text, text>,PRIMARY KEY (keyspace_name, columnfamily_name, trigger_name)) WITH COMMENT='triggers metadata table'
CREATE TABLE hints (target_id uuid,hint_id timeuuid,message_version int,mutation blob,PRIMARY KEY (target_id, hint_id, message_version)) WITH COMPACT STORAGE AND COMPACTION={'class' : 'SizeTieredCompactionStrategy', 'enabled' : false} AND COMMENT='hints awaiting delivery'AND gc_grace_seconds=0
CREATE TABLE peers (peer inet PRIMARY KEY,host_id uuid,tokens set<varchar>,schema_version uuid,release_version text,rpc_address inet,preferred_ip inet,data_center text,rack text) WITH COMMENT='known peers in the cluster'
CREATE TABLE peer_events (peer inet PRIMARY KEY,hints_dropped map<uuid, int>) WITH COMMENT='cf contains events related to peers'
CREATE TABLE local (key text PRIMARY KEY,tokens set<varchar>,cluster_name text,gossip_generation int,bootstrapped text,host_id uuid,release_version text,thrift_version text,cql_version text,native_protocol_version text,data_center text,rack text,partitioner text,schema_version uuid,truncated_at map<uuid, blob>) WITH COMMENT='information about the local node'
CREATE TABLE batchlog (id uuid PRIMARY KEY,written_at timestamp,data blob) WITH COMMENT='uncommited batches' AND gc_grace_seconds=0 AND COMPACTION={'class' : 'SizeTieredCompactionStrategy', 'min_threshold' : 2}
CREATE TABLE range_xfers (token_bytes blob PRIMARY KEY,requested_at timestamp) WITH COMMENT='ranges requested for transfer here'
CREATE TABLE compactions_in_progress (id uuid PRIMARY KEY,keyspace_name text,columnfamily_name text,inputs set<int>) WITH COMMENT='unfinished compactions'
CREATE TABLE paxos (row_key blob,cf_id UUID,in_progress_ballot timeuuid,proposal blob,most_recent_commit_at timeuuid,most_recent_commit blob,PRIMARY KEY (row_key, cf_id)) WITH COMMENT='in-progress paxos proposals'


属于system_traces有2个:
====================================================================
CREATE TABLE sessions (session_id uuid PRIMARY KEY,coordinator inet,request text,started_at timestamp,parameters map<text, text>,duration int) WITH COMMENT='traced sessions'
CREATE TABLE events (session_id uuid,event_id timeuuid,source inet,thread text,activity text,source_elapsed int,PRIMARY KEY (session_id, event_id))


属于system_auth有3个:
====================================================================
CREATE TABLE system_auth.users (
    name text,
    super boolean,
    PRIMARY KEY(name)
) WITH gc_grace_seconds=90 * 24 * 60 * 60 // 3 months(相当于有效期是3个月)

默认的超级用户是cassandra密码也是cassandra


CREATE TABLE system_auth.credentials (
    username text,
    salted_hash text, //使用BCrypt算法
	options map<text,text>, //这个字段目前未使用
    PRIMARY KEY(username)
) WITH gc_grace_seconds=90 * 24 * 60 * 60 // 3 months


CREATE TABLE system_auth.permissions (
    username text,
    resource text,
	permissions set<text>,
    PRIMARY KEY(username, resource)
) WITH gc_grace_seconds=90 * 24 * 60 * 60 // 3 months

