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
package my.test.unit.db;

import java.nio.ByteBuffer;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.ColumnDefinition;
import org.apache.cassandra.cql3.ColumnIdentifier;
import org.apache.cassandra.db.ClusteringComparator;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.RowUpdateBuilder;
import org.apache.cassandra.db.Slice;
import org.apache.cassandra.db.Slices;
import org.apache.cassandra.db.context.CounterContext;
import org.apache.cassandra.db.filter.ColumnFilter;
import org.apache.cassandra.db.marshal.AbstractType;
import org.apache.cassandra.db.marshal.AsciiType;
import org.apache.cassandra.db.marshal.ListType;
import org.apache.cassandra.db.marshal.MapType;
import org.apache.cassandra.db.marshal.SetType;
import org.apache.cassandra.db.partitions.PartitionUpdate;
import org.apache.cassandra.db.rows.Cell;
import org.apache.cassandra.db.rows.CellPath;
import org.apache.cassandra.db.rows.ColumnData;
import org.apache.cassandra.db.rows.ComplexColumnData;
import org.apache.cassandra.db.rows.Row;
import org.apache.cassandra.db.rows.Unfiltered;
import org.apache.cassandra.db.rows.UnfilteredRowIterator;
import org.apache.cassandra.utils.CounterId;
import org.junit.Test;

public class RowUpdateBuilderTest {
    private static DecoratedKey makeKey(CFMetaData metadata, Object... partitionKey) {
        if (partitionKey.length == 1 && partitionKey[0] instanceof DecoratedKey)
            return (DecoratedKey) partitionKey[0];

        ByteBuffer key = CFMetaData.serializePartitionKey(metadata.getKeyValidatorAsClusteringComparator().make(
                partitionKey));
        return metadata.decorateKey(key);
    }

    ColumnFamilyStore cfs;
    ColumnIdentifier staticColumn1;
    CFMetaData metadata;

    @Test
    public void test() {
        String ksName = "k1";
        String tableName = "t1";
        CFMetaData.Builder builder = CFMetaData.Builder.create(ksName, tableName);

        builder.addPartitionKey("pk1", AsciiType.instance);
        builder.addPartitionKey("pk2", AsciiType.instance);

        builder.addClusteringColumn("cc1", AsciiType.instance);
        builder.addClusteringColumn("cc2", AsciiType.instance);

        staticColumn1 = new ColumnIdentifier("StaticColumn1", true);

        // 默认会转成小写
        // builder.addStaticColumn("StaticColumn1", AsciiType.instance);
        builder.addStaticColumn(staticColumn1, AsciiType.instance);
        builder.addRegularColumn(new ColumnIdentifier("RegularColumn1", true), AsciiType.instance);
        builder.addRegularColumn(new ColumnIdentifier("RegularColumn2", true), //
                ListType.getInstance(AsciiType.instance, true)); // isMultiCell=true

        builder.addRegularColumn(new ColumnIdentifier("RegularColumn3", true), //
                SetType.getInstance(AsciiType.instance, true)); // isMultiCell=true

        builder.addRegularColumn(new ColumnIdentifier("RegularColumn4", true), //
                MapType.getInstance(AsciiType.instance, AsciiType.instance, true)); // isMultiCell=true

        metadata = builder.build();

        // CFMetaDataTest.createKeyspace(ksName, KeyspaceParams.simple(1), metadata);
        //
        // cfs = Keyspace.open(ksName).getColumnFamilyStore(tableName);
        // String file = cfs.getSSTablePath(cfs.getDirectories().getDirectoryForNewSSTables());
        // System.out.println(file);

        write();
    }

    void write() {
        int count = 1;
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

            // markedForDeleteAt++;
            // localDeletionTime++;
            // RowUpdateBuilder rowUpdateBuilder = new RowUpdateBuilder(partitionUpdate, markedForDeleteAt, ttl,
            // localDeletionTime);
            // rowUpdateBuilder.delete("RegularColumn1");
            // rowUpdateBuilder.build();
            //
            // markedForDeleteAt++;
            // localDeletionTime++;
            // rowUpdateBuilder = new RowUpdateBuilder(partitionUpdate, markedForDeleteAt, ttl, localDeletionTime);
            // ClusteringComparator cmp = metadata.comparator;
            // Slice slice = Slice.make(cmp.make("cc1-0", "cc2-0"), cmp.make("cc1-9", "cc2-9"));
            // rowUpdateBuilder.addRangeTombstone(slice);
            // rowUpdateBuilder.build();
            //
            // markedForDeleteAt++;
            // localDeletionTime++;
            // DeletionTime deletionTime = new DeletionTime(markedForDeleteAt, localDeletionTime);
            // partitionUpdate.addPartitionDeletion(deletionTime);
            //
            // markedForDeleteAt++;
            // localDeletionTime++;
            // DeletionTime deletionTime2 = new DeletionTime(markedForDeleteAt, localDeletionTime);
            // ClusteringComparator cmp2 = metadata.comparator;
            // Clustering start2 = cmp2.make("cc1-0", "cc2-0");
            // Clustering end2 = cmp2.make("cc1-9", "cc2-9");
            // Slice slice2 = Slice.make(start2, end2);
            // RangeTombstone rangeTombstone = new RangeTombstone(slice2, deletionTime2);
            // partitionUpdate.add(rangeTombstone);

            UnfilteredRowIterator uri = partitionUpdate.unfilteredIterator();
            // scan(uri);

            ColumnFilter.Builder columnFilterBuilder = new ColumnFilter.Builder(null);
            ColumnDefinition c = metadata.getColumnDefinition(new ColumnIdentifier("RegularColumn1", true));
            // columnFilterBuilder.add(c);

            c = metadata.getColumnDefinition(new ColumnIdentifier("RegularColumn3", true));
            ByteBuffer byteBuffer = createByteBuffer("a1", ((SetType<?>) c.type).getElementsType());
            CellPath cellPath = CellPath.create(byteBuffer);
            // ColumnSubselection subSelection = ColumnSubselection.element(c, cellPath);
            // columnFilterBuilder.select(c, cellPath);

            CellPath cellPathFrom = cellPath;
            ByteBuffer byteBufferTo = createByteBuffer("a3", ((SetType<?>) c.type).getElementsType());
            CellPath cellPathTo = CellPath.create(byteBufferTo);
            // 相当于只找RegularColumn3列满足[cellPathFrom, cellPathTo]的
            columnFilterBuilder.slice(c, cellPathFrom, cellPathTo);

            uri = partitionUpdate.unfilteredIterator(columnFilterBuilder.build(), Slices.ALL, false);
            //scan(uri);

            // 按聚簇列过滤
            ClusteringComparator clusteringComparator = new ClusteringComparator(AsciiType.instance, AsciiType.instance);
            Slices.Builder slicesBuilder = new Slices.Builder(clusteringComparator, 2);
            ByteBuffer byteBufferStart1 = createByteBuffer("cc1-1", AsciiType.instance);
            ByteBuffer byteBufferStart2 = createByteBuffer("cc2-1", AsciiType.instance);
            Slice.Bound start1 = Slice.Bound.inclusiveStartOf(byteBufferStart1, byteBufferStart2);
            ByteBuffer byteBufferEnd1 = createByteBuffer("cc1-3", AsciiType.instance);
            ByteBuffer byteBufferEnd2 = createByteBuffer("cc2-3", AsciiType.instance);
            Slice.Bound end1 = Slice.Bound.inclusiveEndOf(byteBufferEnd1, byteBufferEnd2);
            slicesBuilder.add(start1, end1);

            byteBufferStart1 = createByteBuffer("cc1-8", AsciiType.instance);
            byteBufferStart2 = createByteBuffer("cc2-8", AsciiType.instance);
            start1 = Slice.Bound.inclusiveStartOf(byteBufferStart1, byteBufferStart2);
            slicesBuilder.add(start1, Slice.Bound.TOP);

            uri = partitionUpdate.unfilteredIterator(ColumnFilter.all(metadata), slicesBuilder.build(), false);
            //scan(uri);
            
            uri = partitionUpdate.unfilteredIterator(ColumnFilter.all(metadata),Slices.NONE, false);
            scan(uri);

        }
    }

    void scan(UnfilteredRowIterator uri) {
        Row staticRow = uri.staticRow();
        ColumnDefinition columnDefinition = metadata.getColumnDefinition(staticColumn1);
        Cell cell = staticRow.getCell(columnDefinition);
        if (cell != null)
            System.out.println(columnDefinition.type.getString(cell.value()));
        // int j = 0;
        while (uri.hasNext()) {
            Unfiltered unfiltered = uri.next();
            // System.out.println((j++) + " " + unfiltered.kind());
            if (unfiltered.kind() == Unfiltered.Kind.ROW) {
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
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private static ByteBuffer createByteBuffer(Object value, AbstractType<?> type) {
        if (value == null)
            return null;

        if (value instanceof ByteBuffer)
            return (ByteBuffer) value;

        if (type.isCounter()) {
            // See UpdateParameters.addCounter()
            assert value instanceof Long : "Attempted to adjust Counter cell with non-long value.";
            return CounterContext.instance().createGlobal(CounterId.getLocalId(), 1, (Long) value);
        }
        return ((AbstractType) type).decompose(value);
    }
}
