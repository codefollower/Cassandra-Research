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
package org.apache.cassandra.cql3;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.db.*;
import org.apache.cassandra.db.composites.CellName;
import org.apache.cassandra.db.filter.ColumnSlice;
import org.apache.cassandra.exceptions.InvalidRequestException;

/**
 * A simple container that simplify passing parameters for collections methods.
 */
public class UpdateParameters
{
    public final CFMetaData metadata;
    public final List<ByteBuffer> variables;
    public final long timestamp; //有可能是client端指定的时间
    private final int ttl;
    public final int localDeletionTime; //server端的当前时间(以秒为单位)

    // For lists operation that require a read-before-write. Will be null otherwise.
    private final Map<ByteBuffer, CQL3Row> prefetchedLists;

    public UpdateParameters(CFMetaData metadata, List<ByteBuffer> variables, long timestamp, int ttl, Map<ByteBuffer, CQL3Row> prefetchedLists)
    {
        this.metadata = metadata;
        this.variables = variables;
        this.timestamp = timestamp; //纳秒
        this.ttl = ttl;
        this.localDeletionTime = (int)(System.currentTimeMillis() / 1000); //秒
        this.prefetchedLists = prefetchedLists;
    }

    public Cell makeColumn(CellName name, ByteBuffer value) throws InvalidRequestException
    {
        QueryProcessor.validateCellName(name, metadata.comparator);
        return Cell.create(name, value, timestamp, ttl, metadata);
    }

    public Cell makeTombstone(CellName name) throws InvalidRequestException
    {
        QueryProcessor.validateCellName(name, metadata.comparator);
        return new DeletedCell(name, localDeletionTime, timestamp);
    }

    public RangeTombstone makeRangeTombstone(ColumnSlice slice) throws InvalidRequestException
    {
        QueryProcessor.validateComposite(slice.start, metadata.comparator);
        QueryProcessor.validateComposite(slice.finish, metadata.comparator);
        return new RangeTombstone(slice.start, slice.finish, timestamp, localDeletionTime);
    }

    public RangeTombstone makeTombstoneForOverwrite(ColumnSlice slice) throws InvalidRequestException
    {
        QueryProcessor.validateComposite(slice.start, metadata.comparator);
        QueryProcessor.validateComposite(slice.finish, metadata.comparator);
        return new RangeTombstone(slice.start, slice.finish, timestamp - 1, localDeletionTime);
    }

    public List<Cell> getPrefetchedList(ByteBuffer rowKey, ColumnIdentifier cql3ColumnName)
    {
        if (prefetchedLists == null)
            return Collections.emptyList();

        CQL3Row row = prefetchedLists.get(rowKey);
        return row == null ? Collections.<Cell>emptyList() : row.getCollection(cql3ColumnName);
    }
}
