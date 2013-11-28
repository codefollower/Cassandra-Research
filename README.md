Cassandra-Research
==================

Cassandra数据库源代码学习研究(包括代码注释、文档、用于代码分析的测试用例)

## 构建与运行环境

需要JDK7


## 生成Eclipse工程

* 生成Cassandra Server端

  ant generate-eclipse-files

* 生成Cassandra Client端

  进入java-driver目录，运行mvn eclipse:eclipse

* 在eclipse中分别导入Server和Client项目

  File->Import->General->Existing Projects into Workspace


## 运行Cassandra Server

在eclipse中直接运行my.test.start.CassandraDaemonStart


## 运行Client端例子

在eclipse中直接运行my.test.cql.SimpleClient

