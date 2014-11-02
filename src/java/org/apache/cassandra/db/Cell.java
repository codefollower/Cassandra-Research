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
package org.apache.cassandra.db;

import java.nio.ByteBuffer;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.db.composites.CellName;
import org.apache.cassandra.db.composites.CellNameType;
import org.apache.cassandra.utils.concurrent.OpOrder;
import org.apache.cassandra.utils.memory.AbstractAllocator;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.cassandra.utils.memory.MemtableAllocator;

/**
 * Cell is immutable, which prevents all kinds of confusion in a multithreaded environment.
 */
public interface Cell extends OnDiskAtom
{
    public static final int MAX_NAME_LENGTH = FBUtilities.MAX_UNSIGNED_SHORT;

    public Cell withUpdatedName(CellName newName);

    public Cell withUpdatedTimestamp(long newTimestamp);

    @Override
    public CellName name();

    public ByteBuffer value();

    public boolean isLive();

    public boolean isLive(long now);

    public int cellDataSize();

    // returns the size of the Cell and all references on the heap, excluding any costs associated with byte arrays
    // that would be allocated by a localCopy, as these will be accounted for by the allocator
//<<<<<<< HEAD
//    public long excessHeapSizeExcludingData()
//    {
//        return EMPTY_SIZE + name.excessHeapSizeExcludingData() + ObjectSizes.sizeOnHeapExcludingData(value);
//    }
//
//    public int serializedSize(CellNameType type, TypeSizes typeSizes)
//    {
//        /*
//         * Size of a column is =
//         *   size of a name (short + length of the string)
//         * + 1 byte to indicate if the column has been deleted
//         * + 8 bytes for timestamp
//         * + 4 bytes which basically indicates the size of the byte array
//         * + entire byte array.
//        */
//        int valueSize = value.remaining();
//      //因为列名的最大长度是65535(0xffff)个字节，所以这里转成short
//        return ((int)type.cellSerializer().serializedSize(name, typeSizes)) + 1 + typeSizes.sizeof(timestamp) + typeSizes.sizeof(valueSize) + valueSize;
//    }
//
//    public int serializationFlags()
//    {
//        return 0;
//    }
//
//    public Cell diff(Cell cell) //如果当前Cell的时间戳小于参数Cell cell，则返回此参数Cell cell，否则返回null
//    {
//        if (timestamp() < cell.timestamp())
//            return cell;
//        return null;
//    }
//
//    //摘要包括列名、列值、时间戳、列MASK标志(列MASK见org.apache.cassandra.db.ColumnSerializer中的常量)
//    public void updateDigest(MessageDigest digest)
//    {
//        digest.update(name.toByteBuffer().duplicate());
//        digest.update(value.duplicate());
//
//        DataOutputBuffer buffer = new DataOutputBuffer();
//        try
//        {
//            buffer.writeLong(timestamp);
//            buffer.writeByte(serializationFlags());
//        }
//        catch (IOException e)
//        {
//            throw new RuntimeException(e);
//        }
//        digest.update(buffer.getData(), 0, buffer.getLength());
//    }
//
//    public int getLocalDeletionTime() //子类DeletedCell、ExpiringCell会覆盖此方法
//    {
//        return Integer.MAX_VALUE;
//    }
//
//    //reconcile: 使和解, 使和谐, 使顺从
//    //从当前Cell和参数Cell中选一个
//    public Cell reconcile(Cell cell)
//    {
//        return reconcile(cell, HeapAllocator.instance);
//    }
//
//    public Cell reconcile(Cell cell, AbstractAllocator allocator)
//    {
//        // tombstones take precedence.  (if both are tombstones, then it doesn't matter which one we use.)
//        if (isMarkedForDelete(System.currentTimeMillis()))
//            return timestamp() < cell.timestamp() ? cell : this;
//        if (cell.isMarkedForDelete(System.currentTimeMillis()))
//            return timestamp() > cell.timestamp() ? this : cell;
//        // break ties by comparing values.
//        if (timestamp() == cell.timestamp())
//            return value().compareTo(cell.value()) < 0 ? cell : this;
//        // neither is tombstoned and timestamps are different
//        return timestamp() < cell.timestamp() ? cell : this;
//    }
//
//    @Override
//    public boolean equals(Object o)
//    {
//        if (this == o)
//            return true;
//
//        if (o == null || getClass() != o.getClass())
//            return false;
//
//        Cell cell = (Cell)o;
//
//        return timestamp == cell.timestamp && name.equals(cell.name) && value.equals(cell.value);
//    }
//
//    @Override
//    public int hashCode()
//    {
//        int result = name != null ? name.hashCode() : 0;
//        result = 31 * result + (value != null ? value.hashCode() : 0);
//        result = 31 * result + (int)(timestamp ^ (timestamp >>> 32));
//        return result;
//    }
//
//    public Cell localCopy(ColumnFamilyStore cfs, AbstractAllocator allocator)
//    {
//        return new Cell(name.copy(allocator), allocator.clone(value), timestamp);
//    }
//=======
    public long unsharedHeapSizeExcludingData();

    public int serializedSize(CellNameType type, TypeSizes typeSizes);

    public int serializationFlags();

    public Cell diff(Cell cell);

    public Cell reconcile(Cell cell);

    public Cell localCopy(CFMetaData metadata, AbstractAllocator allocator);

    public Cell localCopy(CFMetaData metaData, MemtableAllocator allocator, OpOrder.Group opGroup);

    public String getString(CellNameType comparator);
}
