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

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;

import org.apache.cassandra.batchlog.LegacyBatchlogMigrator;
import org.apache.cassandra.exceptions.WriteTimeoutException;
import org.apache.cassandra.io.util.FastByteArrayInputStream;
import org.apache.cassandra.net.*;
import org.apache.cassandra.tracing.Tracing;

//两个异地机房A和B
//A有三个server: s1/s2/s3
//B有三个server: s4/s5/s6
//client连到s1，然后并行写s1/s2/s3/s4，并让s4并行转发给s5/s6
//最后s4/s5/s6都直接给s1发送响应，虽然s5/s6没有事先与s1有直接交互，但是每个server都能随时接收消息的，通过id就能确定了
public class MutationVerbHandler implements IVerbHandler<Mutation>
{
//<<<<<<< HEAD
//    private static final boolean TEST_FAIL_WRITES = System.getProperty("cassandra.test.fail_writes", "false").equalsIgnoreCase("true");
//
//    //最开始时是s4接到Mutation.FORWARD_TO
//    //然后s5/s6接到Mutation.FORWARD_FROM
//    public void doVerb(MessageIn<Mutation> message, int id)  throws IOException
//    {
//            // Check if there were any forwarding headers in this message
//            byte[] from = message.parameters.get(Mutation.FORWARD_FROM); //对应的是s1
//            InetAddress replyTo;
//            if (from == null)
//            {
//                replyTo = message.from; //message.from对应的是s1
//                byte[] forwardBytes = message.parameters.get(Mutation.FORWARD_TO);
//                if (forwardBytes != null)
//                    forwardToLocalNodes(message.payload, message.verb, forwardBytes, message.from);
//            }
//            else
//            {
//                replyTo = InetAddress.getByAddress(from);
//            }
//=======
    public void doVerb(MessageIn<Mutation> message, int id)  throws IOException
    {
        // Check if there were any forwarding headers in this message
        byte[] from = message.parameters.get(Mutation.FORWARD_FROM);
        InetAddress replyTo;
        if (from == null)
        {
            replyTo = message.from;
            byte[] forwardBytes = message.parameters.get(Mutation.FORWARD_TO);
            if (forwardBytes != null)
                forwardToLocalNodes(message.payload, message.verb, forwardBytes, message.from);
        }
        else
        {
            replyTo = InetAddress.getByAddress(from);
        }

        try
        {
            if (message.version < MessagingService.VERSION_30 && LegacyBatchlogMigrator.isLegacyBatchlogMutation(message.payload))
                LegacyBatchlogMigrator.handleLegacyMutation(message.payload);
            else
                message.payload.apply();

            Tracing.trace("Enqueuing response to {}", replyTo);
            MessagingService.instance().sendReply(WriteResponse.createMessage(), id, replyTo);
        }
        catch (WriteTimeoutException wto)
        {
            Tracing.trace("Payload application resulted in WriteTimeout, not replying");
        }
    }

    /**
     * Older version (< 1.0) will not send this message at all, hence we don't
     * need to check the version of the data.
     */
    private static void forwardToLocalNodes(Mutation mutation, MessagingService.Verb verb, byte[] forwardBytes, InetAddress from) throws IOException
    {
        try (DataInputStream in = new DataInputStream(new FastByteArrayInputStream(forwardBytes)))
        {
            int size = in.readInt();

            // tell the recipients who to send their ack to
            MessageOut<Mutation> message = new MessageOut<>(verb, mutation, Mutation.serializer).withParameter(Mutation.FORWARD_FROM, from.getAddress());
            // Send a message to each of the addresses on our Forward List
            for (int i = 0; i < size; i++)
            {
                InetAddress address = CompactEndpointSerializationHelper.deserialize(in);
                int id = in.readInt();
                Tracing.trace("Enqueuing forwarded write to {}", address);
                MessagingService.instance().sendOneWay(message, id, address);
            }
        }
    }
}
