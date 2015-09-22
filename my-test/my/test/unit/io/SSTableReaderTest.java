/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package my.test.unit.io;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.cassandra.OrderedJUnit4ClassRunner;
import org.apache.cassandra.SchemaLoader;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.Keyspace;
import org.apache.cassandra.db.RowUpdateBuilder;
import org.apache.cassandra.db.compaction.CompactionManager;
import org.apache.cassandra.db.marshal.AsciiType;
import org.apache.cassandra.dht.*;
import org.apache.cassandra.io.sstable.format.SSTableReader;
import org.apache.cassandra.schema.KeyspaceParams;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.Pair;

@RunWith(OrderedJUnit4ClassRunner.class)
public class SSTableReaderTest {
    public static final String KEYSPACE1 = "SSTableReaderTest";
    public static final String CF_STANDARD = "Standard1";
    public static final String CF_STANDARD2 = "Standard2";
    public static final String CF_INDEXED = "Indexed1";
    public static final String CF_STANDARDLOWINDEXINTERVAL = "StandardLowIndexInterval";

    private IPartitioner partitioner;

    Token t(int i) {
        return partitioner.getToken(ByteBufferUtil.bytes(String.valueOf(i)));
    }

    @BeforeClass
    public static void defineSchema() throws Exception {
        SchemaLoader.prepareServer();
        SchemaLoader.createKeyspace(KEYSPACE1, KeyspaceParams.simple(1),
                SchemaLoader.standardCFMD(KEYSPACE1, CF_STANDARD));
        // SchemaLoader.standardCFMD(KEYSPACE1, CF_STANDARD2),
        // SchemaLoader.compositeIndexCFMD(KEYSPACE1, CF_INDEXED, true),
        // SchemaLoader.standardCFMD(KEYSPACE1, CF_STANDARDLOWINDEXINTERVAL)
        // .minIndexInterval(8)
        // .maxIndexInterval(256)
        // .caching(CachingParams.CACHE_NOTHING));
    }

    @Test
    public void testGetPositionsForRanges() {
        Keyspace keyspace = Keyspace.open(KEYSPACE1);
        ColumnFamilyStore store = keyspace.getColumnFamilyStore("Standard1");
        partitioner = store.getPartitioner();

        // insert data and compact to a single sstable
        CompactionManager.instance.disableAutoCompaction();
        for (int j = 1000; j < 2000; j++) {
            String key = String.valueOf(j);
            String val = "v-" + key;
            new RowUpdateBuilder(store.metadata, j, key).clustering("0").add("val", val).build().applyUnsafe();
        }
        store.forceBlockingFlush();
        // CompactionManager.instance.performMaximal(store, false);

        List<Range<Token>> ranges = new ArrayList<Range<Token>>();
        // // 1 key
        // ranges.add(new Range<>(t(0), t(1)));
        // // 2 keys
        // ranges.add(new Range<>(t(2), t(4)));
        // // wrapping range from key to end
        // ranges.add(new Range<>(t(6), partitioner.getMinimumToken()));
        // // empty range (should be ignored)
        // ranges.add(new Range<>(t(9), t(91)));

        // ranges.add(new Range<>(t(0), t(5)));
        // ranges.add(new Range<>(t(6), t(9)));

        // ranges.add(new Range<>(t(300), t(500)));

        ranges.add(new Range<>(t(0), t(1000)));

        // confirm that positions increase continuously
        SSTableReader sstable = store.getLiveSSTables().iterator().next();
        System.out.println(sstable.getIndexSummarySize());

        // 如果是Operator.EQ，key的类型只能是DecoratedKey(或它的子类)
        // sstable.getPosition(partitioner.decorateKey(AsciiType.instance.fromString(String.valueOf(1500))).getToken().maxKeyBound(),
        // SSTableReader.Operator.EQ);

        sstable.getPosition(partitioner.decorateKey(AsciiType.instance.fromString(String.valueOf(1500))),
                SSTableReader.Operator.EQ);
        long previous = -1;
        for (Pair<Long, Long> section : sstable.getPositionsForRanges(ranges)) {
            assert previous <= section.left : previous + " ! < " + section.left;
            assert section.left < section.right : section.left + " ! < " + section.right;
            previous = section.right;
        }
    }
}