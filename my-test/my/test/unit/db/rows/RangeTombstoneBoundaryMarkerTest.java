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
package my.test.unit.db.rows;

import java.nio.ByteBuffer;

import org.apache.cassandra.db.DeletionTime;
import org.apache.cassandra.db.rows.RangeTombstoneBoundaryMarker;

public class RangeTombstoneBoundaryMarkerTest {

    public static void main(String[] args) {
        boolean reversed = false;

        ByteBuffer boundValue1 = ByteBuffer.allocate(4);
        boundValue1.putInt(10);
        boundValue1.flip();
        ByteBuffer boundValue2 = ByteBuffer.allocate(4);
        boundValue1.putInt(20);
        boundValue1.flip();
        ByteBuffer[] boundValues = { boundValue1, boundValue2 };

        DeletionTime closeDeletion = new DeletionTime(10, 20);

        DeletionTime openDeletion = new DeletionTime(30, 40);

        RangeTombstoneBoundaryMarker marker = RangeTombstoneBoundaryMarker.exclusiveCloseInclusiveOpen(reversed,
                boundValues, closeDeletion, openDeletion);

        marker.isOpen(reversed);
    }
}
