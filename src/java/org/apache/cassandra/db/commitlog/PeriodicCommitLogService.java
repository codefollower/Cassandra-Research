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
package org.apache.cassandra.db.commitlog;

import org.apache.cassandra.config.DatabaseDescriptor;
import org.apache.cassandra.utils.concurrent.WaitQueue;

class PeriodicCommitLogService extends AbstractCommitLogService
{
    private static final int blockWhenSyncLagsMillis = (int) (DatabaseDescriptor.getCommitLogSyncPeriod() * 1.5);

    public PeriodicCommitLogService(final CommitLog commitLog)
    {
        super(commitLog, "PERIODIC-COMMIT-LOG-SYNCER", DatabaseDescriptor.getCommitLogSyncPeriod());
    }

    protected void maybeWaitForSync(CommitLogSegment.Allocation alloc)
    {
        //因为Long.MAX_VALUE > Long.MAX_VALUE + 1
        //lastSyncedAt是long类型，当lastSyncedAt为Long.MAX_VALUE时，
        //再加一个int类型的blockWhenSyncLagsMillis时还是小于Long.MAX_VALUE；
        //当lastSyncedAt + blockWhenSyncLagsMillis正好等于Long.MAX_VALUE时，就不阻塞了
        //也就是这个if只有lastSyncedAt + blockWhenSyncLagsMillis正好等于Long.MAX_VALUE时才是false
        if (waitForSyncToCatchUp(Long.MAX_VALUE))
        {
            // wait until periodic sync() catches up with its schedule
            long started = System.currentTimeMillis();
            pending.incrementAndGet();
            while (waitForSyncToCatchUp(started))
            {
                WaitQueue.Signal signal = syncComplete.register(commitLog.metrics.waitingOnCommit.time());
                if (waitForSyncToCatchUp(started))
                    signal.awaitUninterruptibly();
                else
                    signal.cancel();
            }
            pending.decrementAndGet();
        }
    }

    /**
     * @return true if sync is currently lagging behind inserts
     */
    private boolean waitForSyncToCatchUp(long started)
    {
        //如果当前时间第10毫秒，上次同步时间是在第5毫秒，同步间隔是10毫秒，说时当前时间还是同步周期内，就不用阻塞了
        //如果当前时间第16毫秒，超过了同步周期，需要阻塞
        return started > lastSyncedAt + blockWhenSyncLagsMillis;
    }
}