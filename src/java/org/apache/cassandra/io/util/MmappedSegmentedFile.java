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

import java.io.*;

import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.cassandra.db.TypeSizes;
import org.apache.cassandra.io.sstable.format.Version;
import org.apache.cassandra.utils.JVMStabilityInspector;

public class MmappedSegmentedFile extends SegmentedFile
{
    private static final Logger logger = LoggerFactory.getLogger(MmappedSegmentedFile.class);

//<<<<<<< HEAD
//    // in a perfect world, MAX_SEGMENT_SIZE would be final, but we need to test with a smaller size to stay sane.
//    //JVM最大内存映射是2G，而2G = 2 * 1024 * 1024 * 1024 = 2,147,483,648 = 2的31次方{约等于Integer.MAX_VALUE(2的31次方-1)}
//    public static long MAX_SEGMENT_SIZE = Integer.MAX_VALUE; //2,147,483,647 = 2的31次方-1
//=======
    private final MmappedRegions regions;

    public MmappedSegmentedFile(ChannelProxy channel, int bufferSize, long length, MmappedRegions regions)
    {
        super(new Cleanup(channel, regions), channel, bufferSize, length);
        this.regions = regions;
    }

    private MmappedSegmentedFile(MmappedSegmentedFile copy)
    {
        super(copy);
        this.regions = copy.regions;
    }

    public MmappedSegmentedFile sharedCopy()
    {
        return new MmappedSegmentedFile(this);
    }

    public RandomAccessReader createReader()
    {
//<<<<<<< HEAD
//        assert 0 <= position && position < length: String.format("%d >= %d in %s", position, length, path());
//        Segment seg = new Segment(position, null);
//        int idx = Arrays.binarySearch(segments, seg);
//        assert idx != -1 : String.format("Bad position %d for segments %s in %s", position, Arrays.toString(segments), path());
//        if (idx < 0)
//            // round down to entry at insertion point
//            idx = -(idx + 2); //前面那个开始位置小于position的Segment
//        return segments[idx];
//=======
        return new RandomAccessReader.Builder(channel)
               .overrideLength(length)
               .regions(regions)
               .build();
    }

    public RandomAccessReader createReader(RateLimiter limiter)
    {
//<<<<<<< HEAD
//        Segment segment = floor(position);
//        if (segment.right != null)
//        {
//            // segment is mmap'd
//            return new ByteBufferDataInput(segment.right, path(), segment.left, (int) (position - segment.left));
//        }
//
//        //超过2G的情况，见Builder.createSegments(String)中的注释
//        // we can have single cells or partitions larger than 2Gb, which is our maximum addressable range in a single segment;
//        // in this case we open as a normal random access reader
//        // FIXME: brafs are unbounded, so this segment will cover the rest of the file, rather than just the row
//        RandomAccessReader file = RandomAccessReader.open(channel, bufferSize, -1L);
//        file.seek(position);
//        return file;
//=======
        return new RandomAccessReader.Builder(channel)
               .overrideLength(length)
               .bufferSize(bufferSize)
               .regions(regions)
               .limiter(limiter)
               .build();
    }

    private static final class Cleanup extends SegmentedFile.Cleanup
    {
        private final MmappedRegions regions;

        Cleanup(ChannelProxy channel, MmappedRegions regions)
        {
            super(channel);
            this.regions = regions;
        }

        public void tidy()
        {
            Throwable err = regions.close(null);
            if (err != null)
            {
                JVMStabilityInspector.inspectThrowable(err);

                // This is not supposed to happen
                logger.error("Error while closing mmapped regions", err);
            }

            super.tidy();
        }
    }

    /**
     * Overrides the default behaviour to create segments of a maximum size.
     */
    static class Builder extends SegmentedFile.Builder
    {
        private MmappedRegions regions;

        Builder()
        {
            super();
//<<<<<<< HEAD
//            boundaries = new ArrayList<>();
//            boundaries.add(0L); //先填0
//        }
//
//        public void addPotentialBoundary(long boundary)
//        {
//            if (boundary - currentStart <= MAX_SEGMENT_SIZE) //不到2G
//            {
//                // boundary fits into current segment: expand it
//                currentSize = boundary - currentStart;
//                return;
//            }
//
//            // close the current segment to try and make room for the boundary
//            if (currentSize > 0)
//            {
//                currentStart += currentSize;
//                boundaries.add(currentStart);
//            }
//            currentSize = boundary - currentStart;
//
//            // if we couldn't make room, the boundary needs its own segment
//            if (currentSize > MAX_SEGMENT_SIZE) //新的size还大于2G
//            {
//                currentStart = boundary;
//                boundaries.add(currentStart);
//                currentSize = 0;
//            }
//=======
//>>>>>>> 5bb80362d2d0533884f5a3af8892e6ff62d0bfff
        }

        public SegmentedFile complete(ChannelProxy channel, int bufferSize, long overrideLength)
        {
            long length = overrideLength > 0 ? overrideLength : channel.size();
            updateRegions(channel, length);

            return new MmappedSegmentedFile(channel, bufferSize, length, regions.sharedCopy());
        }

        private void updateRegions(ChannelProxy channel, long length)
        {
//<<<<<<< HEAD
//            // if we're early finishing a range that doesn't span multiple segments, but the finished file now does,
//            // we remove these from the end (we loop incase somehow this spans multiple segments, but that would
//            // be a loco dataset
//            while (length < boundaries.get(boundaries.size() - 1)) //因为get(0)是开始位置，当要计算片段个数时必须减1
//                boundaries.remove(boundaries.size() -1);
//
//            // add a sentinel value == length
//            List<Long> boundaries = new ArrayList<>(this.boundaries);
//            if (length != boundaries.get(boundaries.size() - 1))
//                boundaries.add(length);
//
//            int segcount = boundaries.size() - 1;
//            Segment[] segments = new Segment[segcount];
//            for (int i = 0; i < segcount; i++)
//            {
//                long start = boundaries.get(i);
//                long size = boundaries.get(i + 1) - start;
//                MappedByteBuffer segment = size <= MAX_SEGMENT_SIZE
//                                           ? channel.map(FileChannel.MapMode.READ_ONLY, start, size)
//                                           : null; //超过2G了，在调用getSegment时直接用RandomAccessReader读
//                segments[i] = new Segment(start, segment);
//=======
            if (regions != null && !regions.isValid(channel))
            {
                Throwable err = regions.close(null);
                if (err != null)
                    logger.error("Failed to close mapped regions", err);

                regions = null;
            }

            if (regions == null)
                regions = MmappedRegions.map(channel, length);
            else
                regions.extend(length);
        }

        @Override
        public void serializeBounds(DataOutput out, Version version) throws IOException
        {
//<<<<<<< HEAD
//            super.serializeBounds(out);
//            out.writeInt(boundaries.size()); //开始的0位置也算在内
//            for (long position: boundaries)
//                out.writeLong(position);
//=======
            if (!version.hasBoundaries())
                return;

            super.serializeBounds(out, version);
            out.writeInt(0);
        }

        @Override
        public void deserializeBounds(DataInput in, Version version) throws IOException
        {
            if (!version.hasBoundaries())
                return;

            super.deserializeBounds(in, version);
            in.skipBytes(in.readInt() * TypeSizes.sizeof(0L));
        }

        @Override
        public Throwable close(Throwable accumulate)
        {
            return super.close(regions == null
                               ? accumulate
                               : regions.close(accumulate));
        }
    }
}
