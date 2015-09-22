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
package my.test.unit;

import java.nio.ByteBuffer;
import java.util.UUID;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.Schema;
import org.apache.cassandra.cql3.ColumnIdentifier;
import org.apache.cassandra.db.ColumnFamilyStore;
import org.apache.cassandra.db.DecoratedKey;
import org.apache.cassandra.db.Keyspace;
import org.apache.cassandra.db.marshal.AsciiType;
import org.apache.cassandra.db.marshal.ListType;
import org.apache.cassandra.db.marshal.MapType;
import org.apache.cassandra.db.marshal.SetType;
import org.apache.cassandra.io.sstable.Descriptor;
import org.apache.cassandra.schema.CompressionParams;
import org.apache.cassandra.schema.KeyspaceMetadata;
import org.apache.cassandra.schema.KeyspaceParams;
import org.apache.cassandra.schema.Tables;
import org.apache.cassandra.service.MigrationManager;

public class TestBase {
    public static final String ksName = "k1";
    public static final String tableName = "t1";
    public static ColumnFamilyStore cfs;
    public static ColumnIdentifier staticColumn1;

    public static void createKeyspace(String name, KeyspaceParams params, CFMetaData... tables) {
        Schema.instance.load(KeyspaceMetadata.create(name, params, Tables.of(tables)));

        // if (Schema.instance.getKSMetaData(ksName) != null)
        // MigrationManager.announceKeyspaceDrop(name, true);
        // MigrationManager.announceNewKeyspace(KeyspaceMetadata.create(name, params, Tables.of(tables)), true);
    }

    public static CFMetaData getCFMetaData() {
        return getCFMetaData(false);
    }

    public static CFMetaData getCFMetaData(boolean noCompression) {

        // SchemaLoader.prepareServer();

        String tableId = "9de348f8-4dbe-4b78-8718-4f75d96668ca";

        CFMetaData.Builder builder = CFMetaData.Builder.create(ksName, tableName);
        builder.withId(UUID.fromString(tableId));

        // String uuid = UUID.randomUUID().toString();
        // builder.withId(UUID.fromString(uuid));

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

        CFMetaData md = builder.build();

        if (noCompression)
            md.compression(CompressionParams.noCompression());

        createKeyspace(ksName, KeyspaceParams.simple(1), md);

        return md;
    }

    public static Descriptor getDescriptor() {
        cfs = Keyspace.open(ksName).getColumnFamilyStore(tableName);
        String file = cfs.getSSTablePath(cfs.getDirectories().getDirectoryForNewSSTables());
        return Descriptor.fromFilename(file);
    }

    public static DecoratedKey makeKey(CFMetaData metadata, Object... partitionKey) {
        if (partitionKey.length == 1 && partitionKey[0] instanceof DecoratedKey)
            return (DecoratedKey) partitionKey[0];

        ByteBuffer key = CFMetaData.serializePartitionKey(metadata.getKeyValidatorAsClusteringComparator().make(
                partitionKey));
        return metadata.decorateKey(key);
    }
}
