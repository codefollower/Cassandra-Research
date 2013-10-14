A与B两节点通信:

A发GossipDigestSyn => B执行GossipDigestSynVerbHandler => B发GossipDigestAck =>
A执行GossipDigestAckVerbHandler => A发GossipDigestAck2 => B执行GossipDigestAck2VerbHandler

总共需要三次网络通信


总结列表如下:

A端                            B端
--------------------           --------------------
GossipDigestSyn                GossipDigestSynVerbHandler
GossipDigestAckVerbHandler     GossipDigestAck
GossipDigestAck2               GossipDigestAck2VerbHandler

