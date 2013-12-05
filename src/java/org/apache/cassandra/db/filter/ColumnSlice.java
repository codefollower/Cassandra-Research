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
package org.apache.cassandra.db.filter;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableMap;

import com.google.common.collect.AbstractIterator;

import org.apache.cassandra.db.*;
import org.apache.cassandra.db.marshal.AbstractType;
import org.apache.cassandra.io.IVersionedSerializer;
import org.apache.cassandra.utils.ByteBufferUtil;

//代表列名区间
public class ColumnSlice
{
    public static final Serializer serializer = new Serializer();

    public static final ColumnSlice ALL_COLUMNS = new ColumnSlice(ByteBufferUtil.EMPTY_BYTE_BUFFER, ByteBufferUtil.EMPTY_BYTE_BUFFER);
    public static final ColumnSlice[] ALL_COLUMNS_ARRAY = new ColumnSlice[]{ ALL_COLUMNS };

    public final ByteBuffer start;
    public final ByteBuffer finish;

    //start和finish都是列名
    public ColumnSlice(ByteBuffer start, ByteBuffer finish)
    {
        assert start != null && finish != null;
        this.start = start;
        this.finish = finish;
    }

    //当start大于finish时认为是空
    public boolean isAlwaysEmpty(AbstractType<?> comparator, boolean reversed)
    {
        Comparator<ByteBuffer> orderedComparator = reversed ? comparator.reverseComparator : comparator;
        return (start.remaining() > 0 && finish.remaining() > 0 && orderedComparator.compare(start, finish) > 0);
    }

    //name在[start, finish]这个闭区间或者在[start, 无穷大)这个区间中
    public boolean includes(Comparator<ByteBuffer> cmp, ByteBuffer name)
    {
        return cmp.compare(start, name) <= 0 && (finish.equals(ByteBufferUtil.EMPTY_BYTE_BUFFER) || cmp.compare(finish, name) >= 0);
    }

    //name在finish之后就说明当前的ColumnSlice在name之前
    public boolean isBefore(Comparator<ByteBuffer> cmp, ByteBuffer name)
    {
        return !finish.equals(ByteBufferUtil.EMPTY_BYTE_BUFFER) && cmp.compare(finish, name) < 0;
    }


    @Override
    public final int hashCode()
    {
        int hashCode = 31 + start.hashCode();
        return 31*hashCode + finish.hashCode();
    }

    @Override
    public final boolean equals(Object o)
    {
        if(!(o instanceof ColumnSlice))
            return false;
        ColumnSlice that = (ColumnSlice)o;
        return start.equals(that.start) && finish.equals(that.finish);
    }

    @Override
    public String toString()
    {
        return "[" + ByteBufferUtil.bytesToHex(start) + ", " + ByteBufferUtil.bytesToHex(finish) + "]";
    }

    public static class Serializer implements IVersionedSerializer<ColumnSlice>
    {
        public void serialize(ColumnSlice cs, DataOutput out, int version) throws IOException
        {
            ByteBufferUtil.writeWithShortLength(cs.start, out);
            ByteBufferUtil.writeWithShortLength(cs.finish, out);
        }

        public ColumnSlice deserialize(DataInput in, int version) throws IOException
        {
            ByteBuffer start = ByteBufferUtil.readWithShortLength(in);
            ByteBuffer finish = ByteBufferUtil.readWithShortLength(in);
            return new ColumnSlice(start, finish);
        }

        public long serializedSize(ColumnSlice cs, int version)
        {
            TypeSizes sizes = TypeSizes.NATIVE;

            int startSize = cs.start.remaining();
            int finishSize = cs.finish.remaining();

            int size = 0;
            //列名的长度不能大于64K，所以要转short
            //见org.apache.cassandra.db.Column.MAX_NAME_LENGTH
            size += sizes.sizeof((short) startSize) + startSize;
            size += sizes.sizeof((short) finishSize) + finishSize;
            return size;
        }
    }

    public static class NavigableMapIterator extends AbstractIterator<Column>
    {
        private final NavigableMap<ByteBuffer, Column> map;
        private final ColumnSlice[] slices;

        private int idx = 0;
        private Iterator<Column> currentSlice;

        //按ColumnSlice[] slices来遍历有序map中的列
        public NavigableMapIterator(NavigableMap<ByteBuffer, Column> map, ColumnSlice[] slices)
        {
            this.map = map;
            this.slices = slices;
        }

        protected Column computeNext()
        {
            if (currentSlice == null)
            {
                if (idx >= slices.length)
                    return endOfData();

                ColumnSlice slice = slices[idx++];
                // Note: we specialize the case of start == "" and finish = "" because it is slightly more efficient, but also they have a specific
                // meaning (namely, they always extend to the beginning/end of the range).
                if (slice.start.remaining() == 0)
                {
                    if (slice.finish.remaining() == 0)
                        currentSlice = map.values().iterator(); //start和finish都是空，则用整个map
                    else //start空，finish不空，则用finish(包含它)之前的map
                        currentSlice = map.headMap(slice.finish, true).values().iterator();
                }
                else if (slice.finish.remaining() == 0) //start不空，finish空，则用start开始(包含它)之后的map
                {
                    currentSlice = map.tailMap(slice.start, true).values().iterator();
                }
                else
                {
                    //start和finish都不空，则用start开始(包含它)到finish(包含它)之间的map
                    currentSlice = map.subMap(slice.start, true, slice.finish, true).values().iterator();
                }
            }

            if (currentSlice.hasNext())
                return currentSlice.next();

            currentSlice = null;
            return computeNext();
        }
    }
}
