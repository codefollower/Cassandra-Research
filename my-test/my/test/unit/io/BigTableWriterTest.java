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

import java.util.concurrent.ConcurrentSkipListMap;

import my.test.unit.TestBase;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.ColumnDefinition;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.RowUpdateBuilder;
import org.apache.cassandra.db.SerializationHeader;
import org.apache.cassandra.db.compaction.OperationType;
import org.apache.cassandra.db.filter.ColumnFilter;
import org.apache.cassandra.db.lifecycle.LifecycleTransaction;
import org.apache.cassandra.db.marshal.ListType;
import org.apache.cassandra.db.marshal.MapType;
import org.apache.cassandra.db.marshal.SetType;
import org.apache.cassandra.db.partitions.PartitionUpdate;
import org.apache.cassandra.db.rows.Cell;
import org.apache.cassandra.db.rows.CellPath;
import org.apache.cassandra.db.rows.ColumnData;
import org.apache.cassandra.db.rows.ComplexColumnData;
import org.apache.cassandra.db.rows.EncodingStats;
import org.apache.cassandra.db.rows.Row;
import org.apache.cassandra.db.rows.SliceableUnfilteredRowIterator;
import org.apache.cassandra.db.rows.Unfiltered;
import org.apache.cassandra.db.rows.UnfilteredRowIterator;
import org.apache.cassandra.io.sstable.Descriptor;
import org.apache.cassandra.io.sstable.ISSTableScanner;
import org.apache.cassandra.io.sstable.format.SSTableReader;
import org.apache.cassandra.io.sstable.format.SSTableWriter;
import org.apache.cassandra.utils.FBUtilities;
import org.junit.Test;

public class BigTableWriterTest extends TestBase {

    @Test
    public void test() {
        // write();
       read();
    }

    void read() {
        try {
            CFMetaData metadata = getCFMetaData(false);
            Descriptor descriptor = Descriptor
                    .fromFilename("my-test-data/test/data/k1/t1-9de348f84dbe4b7887184f75d96668ca/ma-14-big-Data.db");
            SSTableReader sstable = SSTableReader.open(descriptor);
            // SSTableReader sstable = cfs.getLiveSSTables().iterator().next();
            // SSTableReader sstable = SSTableReader.openNoValidation(descriptor, metadata);

            testScan(sstable, metadata);

            testIterator(sstable, metadata);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void testIterator(SSTableReader sstable, CFMetaData metadata) {
        String pk1 = "pk1-1";
        String pk2 = "pk2-1";

        DecoratedKey partitionKey = makeKey(metadata, pk1, pk2);

        boolean reversed = false;
        boolean isForThrift = false;
        ColumnFilter selectedColumns = ColumnFilter.all(metadata);
        SliceableUnfilteredRowIterator iterator = sstable
                .iterator(partitionKey, selectedColumns, reversed, isForThrift);

        while (iterator.hasNext()) {
            Unfiltered unfiltered = iterator.next();
            printUnfiltered(unfiltered);
        }

    }

    void testScan(SSTableReader sstable, CFMetaData metadata) {
        // full range scan
        ISSTableScanner fullScanner = sstable.getScanner(null);
        while (fullScanner.hasNext()) {
            UnfilteredRowIterator uri = fullScanner.next();

            scan(uri, metadata);

            // while (uri.hasNext()) {
            // Unfiltered row = uri.next();
            // System.out.println(row.kind());
            // }
        }
    }

    void scan(UnfilteredRowIterator uri, CFMetaData metadata) {
        System.out.println(uri.partitionKey());
        Row staticRow = uri.staticRow();
        ColumnDefinition columnDefinition = metadata.getColumnDefinition(staticColumn1);
        Cell cell = staticRow.getCell(columnDefinition);
        if (cell != null)
            System.out.println(columnDefinition.type.getString(cell.value()));
        // int j = 0;
        while (uri.hasNext()) {
            Unfiltered unfiltered = uri.next();
            // System.out.println((j++) + " " + unfiltered.kind());

            printUnfiltered(unfiltered);

        }
    }

    void printUnfiltered(Unfiltered unfiltered) {
        if (unfiltered.kind() == Unfiltered.Kind.ROW) {
            ColumnDefinition columnDefinition = null;
            Cell cell = null;
            Row row = (Row) unfiltered;
            for (ColumnData c : row) {

                System.out.println(c.column().name);
                if (c instanceof Cell) {
                    cell = (Cell) c;
                    columnDefinition = c.column();
                    if (cell != null)
                        System.out.println(columnDefinition.type.getString(cell.value()));
                } else if (c instanceof ComplexColumnData) {
                    ComplexColumnData ccd = (ComplexColumnData) c;

                    for (Cell c2 : ccd) {
                        cell = c2;
                        columnDefinition = cell.column();
                        CellPath cp = cell.path();
                        cp.size();
                        if (columnDefinition.type instanceof ListType<?>) {
                            ListType<?> lt = (ListType<?>) columnDefinition.type;
                            System.out.println(lt.getElementsType().getString(cell.value()));
                        } else if (columnDefinition.type instanceof SetType<?>) {
                            SetType<?> st = (SetType<?>) columnDefinition.type;
                            // System.out.println(st.getElementsType().getString(cell.value()));
                            System.out.println(st.getElementsType().getString(cp.get(0)));
                        } else if (columnDefinition.type instanceof MapType<?, ?>) {
                            MapType<?, ?> mt = (MapType<?, ?>) columnDefinition.type;
                            String key = mt.getKeysType().getString(cp.get(0));
                            String value = mt.getValuesType().getString(cell.value());
                            System.out.println(key + " " + value);
                        }
                    }
                    // for (int i = 0; i < ccd.cellsCount(); i++) {
                    // cell = ccd.getCellByIndex(i);
                    // columnDefinition = cell.column();
                    // if (columnDefinition.type instanceof ListType<?>) {
                    // ListType<?> lt = (ListType<?>) columnDefinition.type;
                    // System.out.println(lt.getElementsType().getString(cell.value()));
                    // } else if (columnDefinition.type instanceof SetType<?>) {
                    // SetType<?> st = (SetType<?>) columnDefinition.type;
                    // System.out.println(st.getElementsType().getString(cell.value()));
                    // } else if (columnDefinition.type instanceof MapType<?,?>) {
                    // MapType<?,?> mt = (MapType<?,?>) columnDefinition.type;
                    // System.out.println(mt.getKeysType().getString(cell.value()));
                    // }
                    // }
                }
            }
        }

    }

    void write() {
        CFMetaData metadata = getCFMetaData(false);
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

        // writer.setOpenResult(true);
        write(metadata, writer);

        writer.prepareToCommit();
        writer.commit(null);
        writer.close();
        // writer.openEarly();
    }

    void write(CFMetaData metadata, SSTableWriter writer) {
        // 先排好序，再写到SSTableWriter，否则在读的时候会不正确
        ConcurrentSkipListMap<DecoratedKey, PartitionUpdate> partitions = new ConcurrentSkipListMap<>();

        int count = 128 * 3 + 1;
        for (int i = 0; i < count; i++) {
            String pk1 = "pk1-" + i;
            String pk2 = "pk2-" + i;

            DecoratedKey partitionKey = makeKey(metadata, pk1, pk2);

            PartitionUpdate partitionUpdate = new PartitionUpdate(metadata, partitionKey, metadata.partitionColumns(),
                    4);

            partitions.put(partitionKey, partitionUpdate);

            long markedForDeleteAt = 100;
            int localDeletionTime = 200;
            int ttl = 20;

            markedForDeleteAt = System.nanoTime() / 1000;
            localDeletionTime = FBUtilities.nowInSeconds();
            ttl = -1;

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

            // if (i == 0) {
            // DeletionTime dt = new DeletionTime(2000, 200);
            // partitionUpdate.addPartitionDeletion(dt);
            // }
            // writer.append(partitionUpdate.unfilteredIterator());

        }

        for (PartitionUpdate partitionUpdate : partitions.values()) {
            writer.append(partitionUpdate.unfilteredIterator());
        }
    }
}
