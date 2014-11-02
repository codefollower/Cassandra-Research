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
package org.apache.cassandra.io.util;

import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;

public interface DataOutputPlus extends DataOutput
{

    // write the buffer without modifying its position
    void write(ByteBuffer buffer) throws IOException;

    void write(Memory memory) throws IOException;

//<<<<<<< HEAD:src/java/org/apache/cassandra/db/columniterator/SimpleAbstractColumnIterator.java
////目前没有子类
//public abstract class SimpleAbstractColumnIterator extends AbstractIterator<OnDiskAtom> implements OnDiskAtomIterator
//{
//    public void close() throws IOException {}
//=======
//>>>>>>> f314c61f81af7be86c719a9851a49da272bd7963:src/java/org/apache/cassandra/io/util/DataOutputPlus.java
}
