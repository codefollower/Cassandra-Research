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
package my.test.standalone;

import my.test.start.CassandraDaemonStart;

//加vm参数-javaagent:"E:/cassandra/lib/jamm-0.2.5.jar"
//加-Dcom.sun.management.jmxremote可以启用jmx
public class CassandraStandalone extends CassandraDaemonStart {
    public static void main(String[] args) {
        //org.apache.cassandra.db.Memtable里的默认值是10万
        System.setProperty("cassandra.memtable_row_overhead_computation_step", "1000");
        System.setProperty("cassandra.join_ring", "false"); //不加入ring，因为是单独运行
        System.setProperty("cassandra.load_ring_state", "true"); //从system.peers表加载ring状态信息
        setConfigLoader(CassandraStandalone.class);
        run(args, "my-cassandra.yaml");
    }

    public CassandraStandalone() {
        this.listen_address = "127.0.0.1";
        this.dir = "standalone";
    }
}
