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
package my.test.nodetool;

import java.util.ArrayList;

import org.apache.cassandra.tools.NodeTool;

public class NodeToolTest {

    public static void main(String[] args) {
        // String[] options = { "-h", "127.0.0.1", "-p", "7010", "-u", "cassandra", "-pw", "cassandra", "status" };

        // String[] options = { "-p", "7070", "status" };
        // String[] options = { "-p", "7070","bootstrap","resume" };

        // String[] options = { "-h", "127.0.0.1", "-p", "7070", "removenode", "5e8b63cc-387d-49c0-bb60-b551943918b1"};
        // String[] options = { "-h", "127.0.0.1", "-p", "7070", "help", "decommission"};

        ArrayList<String> options = new ArrayList<>();
        options.add("-h");
        options.add("127.0.0.1");
        // options.add("127.0.0.2");
        // options.add("127.0.0.3");
        options.add("-p");
        options.add("7070");

        // options.add("help");
        // options.add("assassinate");
        // options.add("decommission");

        // options.add("removenode");
        // options.add("force");
        // options.add("5e8b63cc-387d-49c0-bb60-b551943918b1");

        // options.add("drain");

        // options.add("status");

        // options.add("move");
        // options.add("100");

        // options.add("assassinate");
        // options.add("127.0.0.3");

        // options.add("bootstrap");
        // options.add("resume");

        // options.add("flush");
        // options.add("mytest");
        // options.add("users");

        // options.add("tablehistograms");
        // options.add("mytest");
        // options.add("users");

        // options.add("gossipinfo");
        // options.add("info");

        // options.add("netstats");
        // options.add("--human-readable");

        // options.add("rangekeysample");

        // options.add("tpstats");

        options.add("stopdaemon");

        NodeTool.main(options.toArray(new String[0]));
    }

}
