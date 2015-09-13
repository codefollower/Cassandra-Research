在org.apache.cassandra.cql3.statements.SelectStatement.RawStatement.prepare()调用

如果是select * from
入口是: org.apache.cassandra.cql3.selection.Selection.wildcard(CFMetaData)
否则是:
org.apache.cassandra.cql3.selection.Selection.fromSelectors(CFMetaData, List<RawSelector>)


Parser解析完select语句的selection表达式后会得到org.apache.cassandra.cql3.selection.Selectable.Raw接口的几个实现类的实例
org.apache.cassandra.cql3.ColumnIdentifier.Literal //对应普通字段
org.apache.cassandra.cql3.selection.Selectable.WritetimeOrTTL.Raw //对应ttl(字段)、writetime(字段)
org.apache.cassandra.cql3.selection.Selectable.WithFieldSelection.Raw //对应自定义字段类型
org.apache.cassandra.cql3.selection.Selectable.WithFunction.Raw //对应普通函数或聚合

然后对上面Selectable.Raw接口子类实现进行prepare后会得到4个Selectable类的子类实例:
org.apache.cassandra.cql3.ColumnIdentifier
org.apache.cassandra.cql3.selection.Selectable.WritetimeOrTTL
org.apache.cassandra.cql3.selection.Selectable.WithFieldSelection
org.apache.cassandra.cql3.selection.Selectable.WithFunction

接者调用它们的newSelectorFactory方法得到不同的org.apache.cassandra.cql3.selection.Selector.Factory子类实例

调用Selector.Factory的newInstance方法得到
org.apache.cassandra.cql3.selection.Selector子类实例

org.apache.cassandra.cql3.selection.Selection.ResultSetBuilder中持有一个Selection.Selectors接口的引用
Selection.Selectors接口有两个子类:
org.apache.cassandra.cql3.selection.Selection.SimpleSelection
org.apache.cassandra.cql3.selection.Selection.SelectionWithProcessing

它们两者都有一个org.apache.cassandra.cql3.selection.SelectorFactories
而SelectorFactories中包含了所有Selector,
当往ResultSetBuilder中增加从db/io层返回的记录时，一个个让Selector取出对应的字段，对它们进行相应的操作
经过处理后的记录加到org.apache.cassandra.cql3.ResultSet中，
最后再通过org.apache.cassandra.transport.messages.ResultMessage.Rows对ResultSet序列化后返回给client

