package my.test.io;

import org.apache.cassandra.SchemaLoader;
import org.apache.cassandra.io.sstable.SSTableWriter;
import org.junit.Test;

public class SSTableWriterTest extends SchemaLoader {

    @Test
    public void testWrite() {
        String file = "my-test-data/io-test/myks-mycf-tmp-a-60-Data.db";
        SSTableWriter w = new SSTableWriter(file, 20);

    }

}
