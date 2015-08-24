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

import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.db.marshal.AsciiType;
import org.apache.cassandra.dht.IPartitioner;
import org.apache.cassandra.io.sstable.Downsampling;
import org.apache.commons.lang.StringUtils;

public class DownsamplingTest {

    public static void main(String[] args) {
        // samplingLevel必须是2的n次方，否则会java.lang.ArrayIndexOutOfBoundsException
        int samplingLevel = 1;
        for (int i = 0; samplingLevel < 128; i++) {
            samplingLevel = 1 << i;
            System.out.println(samplingLevel + " " + Downsampling.getSamplingPattern(samplingLevel));
        }

        samplingLevel = 4;
        System.out.println(Downsampling.getOriginalIndexes(samplingLevel));

        samplingLevel = 5;
        System.out.println(Downsampling.getOriginalIndexes(samplingLevel));

        int currentSamplingLevel = 4;
        int newSamplingLeve = 8; // 16时出错

        System.out.println(join(Downsampling.getStartPoints(currentSamplingLevel, newSamplingLeve)));

        int index = 127;
        samplingLevel = 128;
        int minIndexInterval = 128;

        System.out.println(Downsampling.getEffectiveIndexIntervalAfterIndex(index, samplingLevel, minIndexInterval));

        IPartitioner partitioner = DatabaseDescriptor.getPartitioner();

        for (int i = 0; i < 1000; i += 100) {
            // System.out.println(partitioner.getTokenFactory().fromString(i + ""));
            ByteBuffer b = ByteBuffer.allocate(4);
            b.putInt(i);
            b.flip();
            System.out.println(partitioner.decorateKey(b));

        }
        System.out.println(partitioner.decorateKey(AsciiType.instance.fromString(String.valueOf(1000))));
        System.out.println(partitioner.decorateKey(AsciiType.instance.fromString(String.valueOf(1999))));
    }

    static String join(int[] a) {
        ArrayList<Integer> list = new ArrayList<>(a.length);
        for (int i : a)
            list.add(i);
        return "[" + StringUtils.join(list, ", ") + "]";
    }
}
