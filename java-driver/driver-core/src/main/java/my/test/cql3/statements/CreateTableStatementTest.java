package my.test.cql3.statements;

import my.test.TestBase;

public class CreateTableStatementTest extends TestBase {
    public static void main(String[] args) throws Exception {
        new CreateTableStatementTest().start();
    }

    @Override
    public void startInternal() throws Exception {
        tableName = "CreateTableStatementTest";
        //按org.apache.cassandra.cql3.statements.CreateTableStatement.RawStatement.prepare()中的代码测试

        //表名不能使用中文
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + "中sss ( block_id uuid)");

        //表名不能超过48个字符
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + "toolonglonglonglonglonglonglong ( block_id uuid)");

        //定义了重复的字段
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, block_id uuid)");

        //min_threshold属性不支持 (Unknown property 'min_threshold')
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid ) WITH min_threshold=2");

        //Create Table语句不能使用占位符
        //session.prepare("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid ) WITH gc_grace_seconds=?");

        //每个表必须有主键
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, breed text, emails set<text>)");

        //partition key和clustering key中的字段类型不能是CollectionType
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName
                + " ( block_id uuid, breed set<text>, color set<text>, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed), color, short_hair))");

        //主键字段不能是counter类型
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id counter PRIMARY KEY, breed text)");

        //没有clustering key、使用COMPACT STORAGE、且所有的字段都是partition key时是不允许的
        //错误是: No definition found that is not part of the PRIMARY KEY
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text," //
                + "PRIMARY KEY ((block_id, breed))) WITH COMPACT STORAGE");

        //没有clustering key、使用COMPACT STORAGE、且包含Collection类型的字段时是不允许的
        //错误是: Collection types are not supported with COMPACT STORAGE
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, emails set<text>," //
                + "PRIMARY KEY ((block_id, breed))) WITH COMPACT STORAGE");

        //这样就正常了，org.apache.cassandra.cql3.statements.CreateTableStatement.comparator默认使用UTF8Type
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean," //
                + "PRIMARY KEY ((block_id, breed))) WITH COMPACT STORAGE");

        execute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean, emails set<text>," //
                + "PRIMARY KEY ((block_id, breed)))");

        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName
                + " ( block_id uuid PRIMARY KEY, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed), color, short_hair))");

        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName
                + " ( block_id uuid PRIMARY KEY, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed), color, short_hair))");

        execute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed), color, short_hair))");

        execute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY (block_id, breed, color, short_hair))");

        execute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed, color, short_hair)))");

        cql = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + //
                "block_id uuid," + //
                "species text," + //
                "alias text," + //
                "population varint," + //
                "PRIMARY KEY (block_id, population)" + //

                ") WITH compression = { 'sstable_compression' : 'DeflateCompressor', 'chunk_length_kb' : 64 }" + //
                "AND compaction = { 'class' : 'SizeTieredCompactionStrategy', 'min_threshold' : 6 }" + //
                " AND CLUSTERING ORDER BY (population DESC)" + //
                " AND COMPACT STORAGE";
        tryExecute();
    }
}
