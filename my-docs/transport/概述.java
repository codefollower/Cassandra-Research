更详细的内容见: doc\native_protocol_v2.spec

总共有17种消息(Message)，分两大类: REQUEST、RESPONSE
======================================================================
	REQUEST消息(有9个):
	===================================
        STARTUP        (1,  Direction.REQUEST,  StartupMessage.codec),
        CREDENTIALS    (4,  Direction.REQUEST,  CredentialsMessage.codec), //只用于支持旧版本，被废弃了，用AUTH_RESPONSE替换
        OPTIONS        (5,  Direction.REQUEST,  OptionsMessage.codec),
        QUERY          (7,  Direction.REQUEST,  QueryMessage.codec),
        PREPARE        (9,  Direction.REQUEST,  PrepareMessage.codec),
        EXECUTE        (10, Direction.REQUEST,  ExecuteMessage.codec),
        REGISTER       (11, Direction.REQUEST,  RegisterMessage.codec),
        BATCH          (13, Direction.REQUEST,  BatchMessage.codec),
        AUTH_RESPONSE  (15, Direction.REQUEST,  AuthResponse.codec),
	===================================

	RESPONSE消息(有8个):
	===================================
        ERROR          (0,  Direction.RESPONSE, ErrorMessage.codec),
        READY          (2,  Direction.RESPONSE, ReadyMessage.codec),
        AUTHENTICATE   (3,  Direction.RESPONSE, AuthenticateMessage.codec),
        SUPPORTED      (6,  Direction.RESPONSE, SupportedMessage.codec),
        RESULT         (8,  Direction.RESPONSE, ResultMessage.codec),
        EVENT          (12, Direction.RESPONSE, EventMessage.codec),
        AUTH_CHALLENGE (14, Direction.RESPONSE, AuthChallenge.codec),
        AUTH_SUCCESS   (16, Direction.RESPONSE, AuthSuccess.codec);
	===================================
======================================================================

请求=>响应

请求             响应
======================================================================
STARTUP          正常: READY  需要认证: AUTHENTICATE  发生错误: ERROR(以下都一样，只要发生错误就返回ERROR)
OPTIONS          SUPPORTED
AUTH_RESPONSE    AuthSuccess 或 AuthChallenge(需要client进一步提供信息)，目前没用到AuthChallenge
CREDENTIALS      READY
REGISTER         READY
QUERY            RESULT
PREPARE          RESULT
EXECUTE          RESULT
BATCH            RESULT
======================================================================

从Client发送给Server端的第一个消息必须是STARTUP或OPTIONS，
给Server端发送OPTIONS消息叫Server返回SUPPORTED消息,
SUPPORTED消息包括CQL_VERSION和COMPRESSION两个参数，
CQL_VERSION代表server端的当前CQL协议版本，COMPRESSION代表server端支持的压缩算法名(目前支持snappy和lz4)

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




Client端:
===================================
(1) Client端对请求编码时的调用顺序:

org.apache.cassandra.transport.Message.ProtocolEncoder (将Request子类编码为Frame)
org.apache.cassandra.transport.Frame.Compressor (对Frame体压缩)
org.apache.cassandra.transport.Frame.Encoder (将Frame编码为字节流)

(4) Client端对响应解码时的调用顺序:

org.apache.cassandra.transport.Frame.Decoder (由字节流构造出Frame)
org.apache.cassandra.transport.Frame.Decompressor (对Frame体解压缩)
org.apache.cassandra.transport.Message.ProtocolDecoder (由Frame得到具体的Response子类)


从Client发送给Server端的第一个消息必须是STARTUP或OPTIONS


Server端:
===================================
(2) Server端对请求解码时的调用顺序:

org.apache.cassandra.transport.Frame.Decoder (由字节流构造出Frame)
org.apache.cassandra.transport.Frame.Decompressor (对Frame体解压缩)
org.apache.cassandra.transport.Message.ProtocolDecoder (由Frame得到具体的Request子类)
org.apache.cassandra.transport.Message.Dispatcher (分发Request)

(3) Server端对响应编码时的调用顺序:

org.apache.cassandra.transport.Message.ProtocolEncoder (将Response子类编码为Frame)
org.apache.cassandra.transport.Frame.Compressor (对Frame体压缩)
org.apache.cassandra.transport.Frame.Encoder (将Frame编码为字节流)
