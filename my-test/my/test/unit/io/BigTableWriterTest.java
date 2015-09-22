/*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*//*
* Licensed to the Apache Software Foundation (ASF) under one
* or more contributor license agreements.  See the NOTICE file
* distributed with this work for additional information
* regarding copyright ownership.  The ASF licenses this file
* to you under the Apache License, Version 2.0 (the
* "License"); you may not use this file except in compliance
* with the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing,
* software distributed under the License is distributed on an
* "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
* KIND, either express or implied.  See the License for the
* specific language governing permissions and limitations
* under the License.
*/
package my.test.unit.io;

import my.test.unit.TestBase;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.DeletionTime;
import org.apache.cassandra.db.RowUpdateBuilder;
import org.apache.cassandra.db.SerializationHeader;
import org.apache.cassandra.db.compaction.OperationType;
import org.apache.cassandra.db.lifecycle.LifecycleTransaction;
import org.apache.cassandra.db.partitions.PartitionUpdate;
import org.apache.cassandra.db.rows.EncodingStats;
import org.apache.cassandra.io.sstable.Descriptor;
import org.apache.cassandra.io.sstable.format.SSTableWriter;
import org.junit.Test;

public class BigTableWriterTest extends TestBase {

    @Test
    public void test() {
        CFMetaData metadata = getCFMetaData(true);
        Descriptor descriptor = getDescriptor();
        System.out.println(descriptor);
        long keyCount = 0;
        long repairedAt = 0;
        int sstableLevel = 0;
        SerializationHeader header = new SerializationHeader(metadata, metadata.partitionColumns(),
                EncodingStats.NO_STATS);
        LifecycleTransaction txn = LifecycleTransaction.offline(OperationType.WRITE, metadata);

        SSTableWriter writer = SSTableWriter.create(metadata, descriptor, keyCount, repairedAt, sstableLevel, header,
                txn);

        write(metadata, writer);

        writer.prepareToCommit();
        writer.commit(null);
        writer.close();
    }

    void write(CFMetaData metadata, SSTableWriter writer) {
        int count = 128 * 3 + 1;
        for (int i = 0; i < count; i++) {
            String pk1 = "pk1-" + i;
            String pk2 = "pk2-" + i;

            DecoratedKey partitionKey = makeKey(metadata, pk1, pk2);

            PartitionUpdate partitionUpdate = new PartitionUpdate(metadata, partitionKey, metadata.partitionColumns(),
                    4);

            long markedForDeleteAt = 100;
            int localDeletionTime = 200;
            int ttl = 20;

            for (int j = 0; j < 10; j++) {
                RowUpdateBuilder rowUpdateBuilder = new RowUpdateBuilder(partitionUpdate, markedForDeleteAt, ttl,
                        localDeletionTime);
                String cc1 = "cc1-" + j;
                String cc2 = "cc2-" + j;

                rowUpdateBuilder.clustering(cc1, cc2);

                String sc1 = "sc-" + j;
                String rc1 = "rc-" + j;
                // 同一个PartitionKey只有一个StaticColumn，这里总是rc-9，因为会覆盖上一个
                rowUpdateBuilder.add("StaticColumn1", sc1);
                rowUpdateBuilder.add("RegularColumn1", rc1);
                // ArrayList<String> list = new ArrayList<>();
                // list.add("a" + j);
                // list.add("b" + j);
                // rowUpdateBuilder.add("RegularColumn2", list);

                String e1 = "a" + j;
                String e2 = "b" + j;
                if (i == 0) {
                    StringBuilder s = new StringBuilder();
                    s.append(e2);
                    for (int m = 0; m < 500; m++) {
                        s.append(m).append(StringBuilder.class.getName());
                    }
                    e2 = s.toString();
                }
                rowUpdateBuilder.addListEntry("RegularColumn2", e1);
                rowUpdateBuilder.addListEntry("RegularColumn2", e2);

                rowUpdateBuilder.addSetEntry("RegularColumn3", e1);
                rowUpdateBuilder.addSetEntry("RegularColumn3", e2);

                String k1 = "k" + j;
                String k2 = "k" + j * 2;
                rowUpdateBuilder.addMapEntry("RegularColumn4", k1, e1);
                rowUpdateBuilder.addMapEntry("RegularColumn4", k2, e2);

                // 没有用，还是会用前面的add加入的值
                // rowUpdateBuilder.delete("RegularColumn1");

                // ClusteringComparator cmp = metadata.comparator;
                // Slice slice = Slice.make(cmp.make("cc1-0", "cc2-0"), cmp.make("cc1-9", "cc2-9"));
                // rowUpdateBuilder.addRangeTombstone(slice);

                rowUpdateBuilder.build();
            }

            if (i == 0) {
                DeletionTime dt = new DeletionTime(2000, 200);
                partitionUpdate.addPartitionDeletion(dt);
            }
            writer.append(partitionUpdate.unfilteredIterator());
        }
    }
}
