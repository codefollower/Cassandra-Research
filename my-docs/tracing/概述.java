对应的包是: org.apache.cassandra.tracing


当org.apache.cassandra.transport.Message.Request.tracingRequested为true时
用来跟踪下面这4种请求消息的执行:
QueryMessage、PrepareMessage、ExecuteMessage、BatchMessage

跟踪记录放在system_traces keyspace中的这两个表:
====================================================================
	CREATE TABLE sessions (
		session_id uuid PRIMARY KEY,
		coordinator inet,
		request text,
		started_at timestamp,
		parameters map<text, text>,
		duration int
	) WITH COMMENT='traced sessions'
	对应org.apache.cassandra.tracing.Tracing类
	

	CREATE TABLE events (
		session_id uuid,
		event_id timeuuid,
		source inet,
		thread text,
		activity text,
		source_elapsed int,
		PRIMARY KEY (session_id, event_id)
	)
	对应org.apache.cassandra.tracing.TraceState类

这两表也是分布式的，
两个表里的记录有效期都只有一天

