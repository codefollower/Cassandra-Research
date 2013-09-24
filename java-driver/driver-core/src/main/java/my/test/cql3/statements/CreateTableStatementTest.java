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

        //定义了多个PRIMARY KEY
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName
                + " ( block_id uuid PRIMARY KEY, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed), color, short_hair))");

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

        //clustering key只有一个、使用COMPACT STORAGE、且包含Collection类型的字段时是不允许的
        //错误是: Collection types are not supported with COMPACT STORAGE
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean, emails set<text>," //
                + "PRIMARY KEY ((block_id, breed), short_hair)) WITH COMPACT STORAGE");

        //clustering key中的字段不能是counter类型
        //错误是: counter type is not supported for PRIMARY KEY part java.nio.HeapByteBuffer[pos=0 lim=6 cap=6]
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, emails counter," //
                + "PRIMARY KEY ((block_id, breed), emails)) WITH COMPACT STORAGE");

        //使用COMPACT STORAGE时，除了partition key和clustering key中的字段外，剩下的字段不能大于1个
        //错误是: 
        //COMPACT STORAGE with composite PRIMARY KEY allows no more than one column not part of the PRIMARY KEY (got: f2, f1)
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean, f1 text, f2 text," //
                + "PRIMARY KEY ((block_id, breed), short_hair)) WITH COMPACT STORAGE");

        //正常
        execute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text, short_hair boolean, f1 text," //
                + "PRIMARY KEY ((block_id, breed), short_hair)) WITH COMPACT STORAGE");

        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName //
                + " ( block_id uuid, breed text," //
                + "PRIMARY KEY ((block_id, breed))) WITH COMPACT STORAGE");

        //ORDER BY (color DESC, short_hair)少了ASC
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed), color)) " //
                + "WITH CLUSTERING ORDER BY (color DESC, short_hair)");
        
        //排序key中的字段比clustering key中的字段多
        //错误是:Only clustering key columns can be defined in CLUSTERING ORDER directive
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed), color)) " //
                + "WITH CLUSTERING ORDER BY (color DESC, short_hair ASC)");
        
        
        //排序key中的字段与clustering key中的字段顺序必须一样
        //错误是:
        //The order of columns in the CLUSTERING ORDER directive 
        //must be the one of the clustering key (short_hair must appear before color)
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed),short_hair, color)) " //
                + "WITH CLUSTERING ORDER BY (color DESC, short_hair ASC)");
        
        //排序key中的字段必须是clustering key中的字段
        //错误是:Missing CLUSTERING ORDER for column color
        tryExecute("CREATE TABLE IF NOT EXISTS " + tableName + " ( block_id uuid, breed text, color text, short_hair boolean,"
                + "PRIMARY KEY ((block_id, breed), color)) " //
                + "WITH CLUSTERING ORDER BY (short_hair ASC)");

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
