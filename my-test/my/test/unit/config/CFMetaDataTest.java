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
package my.test.unit.config;

import java.io.File;
import java.util.ArrayList;

import junit.framework.Assert;

import org.apache.cassandra.UpdateBuilder;
import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.ColumnDefinition;
import org.apache.cassandra.cql3.ColumnIdentifier;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.Keyspace;
import org.apache.cassandra.db.SerializationHeader;
import org.apache.cassandra.db.marshal.AsciiType;
import org.apache.cassandra.db.marshal.ListType;
import org.apache.cassandra.db.rows.Cell;
import org.apache.cassandra.db.rows.EncodingStats;
import org.apache.cassandra.db.rows.Row;
import org.apache.cassandra.db.rows.Unfiltered;
import org.apache.cassandra.db.rows.UnfilteredRowIterator;
import org.apache.cassandra.io.sstable.Component;
import org.apache.cassandra.io.sstable.Descriptor;
import org.apache.cassandra.io.sstable.ISSTableScanner;
import org.apache.cassandra.io.sstable.SSTableTxnWriter;
import org.apache.cassandra.io.sstable.format.SSTableReader;
import org.apache.cassandra.schema.KeyspaceMetadata;
import org.apache.cassandra.schema.KeyspaceParams;
import org.apache.cassandra.schema.Tables;
import org.apache.cassandra.service.MigrationManager;
import org.apache.cassandra.utils.concurrent.AbstractTransactionalTest.TestableTransaction;
import org.junit.Test;

public class CFMetaDataTest {

    public static final String ksName = "k1";
    public static final String tableName = "t1";
    public static ColumnFamilyStore cfs;
    public static ColumnIdentifier staticColumn1;

    public static void createKeyspace(String name, KeyspaceParams params, CFMetaData... tables) {
        MigrationManager.announceNewKeyspace(KeyspaceMetadata.create(name, params, Tables.of(tables)), true);
    }

    public static CFMetaData getCFMetaData() {

        // SchemaLoader.prepareServer();

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

        CFMetaData md = builder.build();

        createKeyspace(ksName, KeyspaceParams.simple(1), md);

        return md;
    }

    public static Descriptor getDescriptor() {
        cfs = Keyspace.open(ksName).getColumnFamilyStore(tableName);
        String file = cfs.getSSTablePath(cfs.getDirectories().getDirectoryForNewSSTables());
        return Descriptor.fromFilename(file);
    }

    @Test
    public void test() {
        getCFMetaData();

        cfs = Keyspace.open(ksName).getColumnFamilyStore(tableName);
        String file = cfs.getSSTablePath(cfs.getDirectories().getDirectoryForNewSSTables());
        System.out.println(file);

        new TestableBTW();

        // try {
        // write();
        // read();
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

    }

    void write() {
        for (int i = 0; i < 100; i++) {
            String pk1 = "pk1-" + i;
            String pk2 = "pk2-" + i;
            UpdateBuilder update = UpdateBuilder.create(cfs.metadata, pk1, pk2);
            for (int j = 0; j < 10; j++) {
                String cc1 = "cc1-" + j;
                String cc2 = "cc2-" + j;
                update.newRow(cc1, cc2);

                String sc1 = "sc-" + j;
                String rc1 = "rc-" + j;
                update.add("StaticColumn1", sc1); // 同一个PartitionKey只有一个StaticColumn，这里总是rc-9，因为会覆盖上一个
                update.add("RegularColumn1", rc1);
                ArrayList<String> list = new ArrayList<>();
                list.add("a" + j);
                list.add("b" + j);
                update.add("RegularColumn2", list);
            }
            update.applyUnsafe();
        }

        cfs.forceBlockingFlush();
    }

    void read() throws Exception {
        SSTableReader sstable = cfs.getLiveSSTables().iterator().next();

        // full range scan
        ISSTableScanner fullScanner = sstable.getScanner(null);
        int i = 1;
        while (fullScanner.hasNext()) {
            UnfilteredRowIterator uri = fullScanner.next();
            Row staticRow = uri.staticRow();
            ColumnDefinition columnDefinition = cfs.metadata.getColumnDefinition(staticColumn1);
            Cell cell = staticRow.getCell(columnDefinition);
            System.out.println(columnDefinition.type.getString(cell.value()));
            while (uri.hasNext()) {
                Unfiltered row = uri.next();
                System.out.println((i++) + " " + row.kind());
            }
        }
        //
        // List<FilteredPartition> partitions;
        //
        // partitions = Util.getAll(Util.cmd(cfs).fromKeyIncl("pk1-1", "pk2-1").toKeyIncl("pk1-9",
        // "pk2-9").build());
        // assertEquals(9, partitions.size());
    }

    class TestableBTW extends TestableTransaction {
        final File file;
        final Descriptor descriptor;
        final SSTableTxnWriter writer;

        private TestableBTW() {
            this(cfs.getSSTablePath(cfs.getDirectories().getDirectoryForNewSSTables()));
        }

        private TestableBTW(String file) {
            this(file, SSTableTxnWriter.create(cfs, file, 0, 0,
                    new SerializationHeader(cfs.metadata, cfs.metadata.partitionColumns(), EncodingStats.NO_STATS)));
        }

        void write() {
            for (int i = 0; i < 100; i++) {
                String pk1 = "pk1-" + i;
                String pk2 = "pk2-" + i;
                UpdateBuilder update = UpdateBuilder.create(cfs.metadata, pk1, pk2);
                for (int j = 0; j < 10; j++) {
                    String cc1 = "cc1-" + j;
                    String cc2 = "cc2-" + j;
                    update.newRow(cc1, cc2);

                    String sc1 = "sc-" + j;
                    String rc1 = "rc-" + j;
                    update.add("StaticColumn1", sc1);
                    update.add("RegularColumn1", rc1);
                    // ArrayList<String> list = new ArrayList<>();
                    // list.add("a" + j);
                    // list.add("b" + j);
                    // update.add("RegularColumn2", list);

                    String e1 = "a" + j;
                    String e2 = "b" + j;
                    update.addListEntry("RegularColumn2", e1);
                    update.addListEntry("RegularColumn2", e2);
                }
                writer.append(update.build().unfilteredIterator());
            }

            writer.finish();
            // writer.commit();

            writer.close();
        }

        void read() throws Exception {
            // cfs.clearUnsafe();
            //
            // cfs.forceBlockingFlush();
            // cfs.switchMemtable();
            // SSTableReader sstable = cfs.getLiveSSTables().iterator().next();

            SSTableReader sstable = SSTableReader.open(descriptor);

            // full range scan
            ISSTableScanner fullScanner = sstable.getScanner(null);
            while (fullScanner.hasNext()) {
                UnfilteredRowIterator uri = fullScanner.next();

                while (uri.hasNext()) {
                    Unfiltered row = uri.next();
                    System.out.println(row.kind());
                }
            }
            //
            // List<FilteredPartition> partitions;
            //
            // partitions = Util.getAll(Util.cmd(cfs).fromKeyIncl("pk1-1", "pk2-1").toKeyIncl("pk1-9",
            // "pk2-9").build());
            // assertEquals(9, partitions.size());
        }

        private TestableBTW(String file, SSTableTxnWriter sw) {
            super(sw);
            // file = "my-test-data\\data\\k1\\t1-79358c5048ae11e5852de55c4935fb86\\ma-2-big-Data.db";
            this.file = new File(file);
            this.descriptor = Descriptor.fromFilename(file);
            this.writer = sw;

            write();
            try {
                read();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        protected void assertInProgress() throws Exception {
            assertExists(Component.DATA, Component.PRIMARY_INDEX);
            assertNotExists(Component.FILTER, Component.SUMMARY);
            Assert.assertTrue(file.length() > 0);
        }

        protected void assertPrepared() throws Exception {
            assertExists(Component.DATA, Component.PRIMARY_INDEX, Component.FILTER, Component.SUMMARY);
        }

        protected void assertAborted() throws Exception {
            assertNotExists(Component.DATA, Component.PRIMARY_INDEX, Component.FILTER, Component.SUMMARY);
            Assert.assertFalse(file.exists());
        }

        protected void assertCommitted() throws Exception {
            assertPrepared();
        }

        @Override
        protected boolean commitCanThrow() {
            return true;
        }

        private void assertExists(Component... components) {
            for (Component component : components)
                Assert.assertTrue(new File(descriptor.filenameFor(component)).exists());
        }

        private void assertNotExists(Component... components) {
            for (Component component : components)
                Assert.assertFalse(component.toString(), new File(descriptor.filenameFor(component)).exists());
        }
    }
}
