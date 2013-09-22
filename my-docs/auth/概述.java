org.apache.cassandra.auth
与认证(authenticate)和受权(authorize)相关的模块

认证包括CREATE/ALTER/DROP USER语句
受权包括GRANT/REVOKE/LIST PERMISSIONS语句

通过把信息存入表中来实现，keyspace是system_auth，总共有三张表
system_auth.users        在org.apache.cassandra.auth.Auth中建立
system_auth.credentials  在org.apache.cassandra.auth.PasswordAuthenticator中建立
system_auth.permissions  在org.apache.cassandra.auth.CassandraAuthorizer中建立


//注意，此表并不存密码，而是放到system_auth.credentials中
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


