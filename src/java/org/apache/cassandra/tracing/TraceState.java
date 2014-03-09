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
package org.apache.cassandra.tracing;

import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;
import org.slf4j.helpers.MessageFormatter;

import org.apache.cassandra.concurrent.Stage;
import org.apache.cassandra.concurrent.StageManager;
import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.db.ArrayBackedSortedColumns;
import org.apache.cassandra.db.ColumnFamily;
import org.apache.cassandra.db.Mutation;
import org.apache.cassandra.utils.ByteBufferUtil;
import org.apache.cassandra.utils.FBUtilities;
import org.apache.cassandra.utils.UUIDGen;
import org.apache.cassandra.utils.WrappedRunnable;

/**
 * ThreadLocal state for a tracing session. The presence of an instance of this class as a ThreadLocal denotes that an
 * operation is being traced.
 */
//对应system_traces.events表
//表里的记录有效期只有一天
@SuppressWarnings("deprecation")
public class TraceState
{
    public final UUID sessionId;
    public final InetAddress coordinator;
    public final Stopwatch watch;
    public final ByteBuffer sessionIdBytes;

    public TraceState(InetAddress coordinator, UUID sessionId)
    {
        assert coordinator != null;
        assert sessionId != null;

        this.coordinator = coordinator;
        this.sessionId = sessionId;
        sessionIdBytes = ByteBufferUtil.bytes(sessionId);
        watch = Stopwatch.createStarted();
    }

    public int elapsed()
    {
        long elapsed = watch.elapsed(TimeUnit.MICROSECONDS);
        return elapsed < Integer.MAX_VALUE ? (int) elapsed : Integer.MAX_VALUE;
    }

    public void trace(String format, Object arg)
    {
        trace(MessageFormatter.format(format, arg).getMessage());
    }

    public void trace(String format, Object arg1, Object arg2)
    {
        trace(MessageFormatter.format(format, arg1, arg2).getMessage());
    }

    public void trace(String format, Object[] args)
    {
        trace(MessageFormatter.arrayFormat(format, args).getMessage());
    }

    public void trace(String message)
    {
        TraceState.trace(sessionIdBytes, message, elapsed());
    }

    //往system_traces.events表中插入一条记录，
    //其中event_id是CLUSTERING_COLUMN列，会放在普通列之前，所以下面没有包含它
    //普通列有4个，session_id是PARTITION_KEY，
    //system_traces.events是system_traces.sessions表的从表
    //       CREATE TABLE events (
    //            session_id uuid,
    //            event_id timeuuid,
    //            source inet,
    //            thread text,
    //            activity text,
    //            source_elapsed int,
    //            PRIMARY KEY (session_id, event_id)
    //        )
    public static void trace(final ByteBuffer sessionIdBytes, final String message, final int elapsed)
    {
        final ByteBuffer eventId = ByteBuffer.wrap(UUIDGen.getTimeUUIDBytes());
        final String threadName = Thread.currentThread().getName();

        StageManager.getStage(Stage.TRACING).execute(new WrappedRunnable()
        {
            public void runMayThrow()
            {
                CFMetaData cfMeta = CFMetaData.TraceEventsCf;
                ColumnFamily cf = ArrayBackedSortedColumns.factory.create(cfMeta);
                Tracing.addColumn(cf, Tracing.buildName(cfMeta, eventId, ByteBufferUtil.bytes("activity")), message);
                Tracing.addColumn(cf, Tracing.buildName(cfMeta, eventId, ByteBufferUtil.bytes("source")), FBUtilities.getBroadcastAddress());
                if (elapsed >= 0)
                    Tracing.addColumn(cf, Tracing.buildName(cfMeta, eventId, ByteBufferUtil.bytes("source_elapsed")), elapsed);
                Tracing.addColumn(cf, Tracing.buildName(cfMeta, eventId, ByteBufferUtil.bytes("thread")), threadName);
                Tracing.mutateWithCatch(new Mutation(Tracing.TRACE_KS, sessionIdBytes, cf));
            }
        });
    }
}
