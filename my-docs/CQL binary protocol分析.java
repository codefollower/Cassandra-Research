Client端:
===================================
	com.datastax.driver.core.Message.Request:
		com.datastax.driver.core.Requests.AuthResponse
		com.datastax.driver.core.Requests.Batch
		com.datastax.driver.core.Requests.Execute
		com.datastax.driver.core.Requests.Options
		com.datastax.driver.core.Requests.Prepare
		com.datastax.driver.core.Requests.Query
		com.datastax.driver.core.Requests.Register
		com.datastax.driver.core.Requests.Startup

	Client端的编码器调用顺序:
		1. com.datastax.driver.core.Message.ProtocolEncoder对上面8个Request子类进行编码
		   得到com.datastax.driver.core.Frame

		2. 可选的，如果使用压缩，再由com.datastax.driver.core.Frame.Compressor对Frame体进行压缩，

		3. 最后再由com.datastax.driver.core.Frame.Encoder 把Frame转换成字节流


	Frame字节流:
	===================================
	分成Header和Body

	Header:

	1字节: VERSION_AND_DIRECTION(固定是2，(0x02))
	1字节: Header.Flag(目前支持COMPRESSED和TRACING两种Flag，通过移位并进行位或运算，可用一个数字代表两种Flag
	                   Flag在Frame.Header中占用一个字节，一个字节有8位，每一位都可代表一种Flag)
	1字节: streamId(用于支持消息异步处理，server端发回的响应消息中也包含同样的streamId)
	1字节: opcode(实际上就是代表不同的Request子类)
	4字节: Body长度

	Body:

	每个Request子类会有不同的Body内容。
	===================================



	opcode:
	===================================
				STARTUP        (1,  Requests.Startup.coder),
				OPTIONS        (5,  Requests.Options.coder),
				QUERY          (7,  Requests.Query.coder),
				PREPARE        (9,  Requests.Prepare.coder),
				EXECUTE        (10, Requests.Execute.coder),
				REGISTER       (11, Requests.Register.coder),
				BATCH          (13, Requests.Batch.coder),
				AUTH_RESPONSE  (15, Requests.AuthResponse.coder);
	===================================



Server端:
===================================
Server端的解码器调用顺序:
org.apache.cassandra.transport.Frame.Decoder (由字节注构造出Frame)
org.apache.cassandra.transport.Frame.Decompressor (对Frame体解压缩)
org.apache.cassandra.transport.Message.ProtocolDecoder (由Frame得到具体的Request)
org.apache.cassandra.transport.Message.Dispatcher (分发Request)


从Client发送给Server端的第一个消息必须是STARTUP或OPTIONS
