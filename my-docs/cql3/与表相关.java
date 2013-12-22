create table时能使用的表选项有14项:
====================
	comment
	read_repair_chance
	dclocal_read_repair_chance
	gc_grace_seconds
	replicate_on_write
	caching
	default_time_to_live
	index_interval
	speculative_retry
	populate_io_cache_on_flush
	bloom_filter_fp_chance
	memtable_flush_period_in_ms
	compaction
	compression

只有compaction和compression允许有子选项

相关类:org.apache.cassandra.cql3.CFPropDefs


