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
package my.test.start;

import org.apache.cassandra.config.Config;
import org.apache.cassandra.config.YamlConfigurationLoader;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.cassandra.service.CassandraDaemon;

public class CassandraDaemonStart extends YamlConfigurationLoader {

    public static void main(String[] args) {
        setConfigLoader(CassandraDaemonStart.class);
        run(args);
    }

    protected String listen_address;
    protected String dir;

    //在org.apache.cassandra.utils.FBUtilities.construct(String, String)中必须使用无参数的构造函数
    public CassandraDaemonStart() {
        this.listen_address = "127.0.0.1";
        this.dir = "standalone";
    }

    @Override
    public Config loadConfig() throws ConfigurationException {

        this.dir = "my-test-data/" + dir + "/";
        Config config = super.loadConfig();
        config.listen_address = listen_address;
        config.commitlog_directory = dir + "commitlog";
        config.saved_caches_directory = dir + "saved_caches";
        config.data_file_directories = new String[] { dir + "data" };

        //config.dynamic_snitch_update_interval_in_ms = 100000;
        return config;
    }

    public static void setConfigLoader(Class<?> clz) {
        System.setProperty("cassandra.config.loader", clz.getName());
    }

    public static void run(String[] args) {
        run(args, "dc-cassandra.yaml");
    }

    public static void run(String[] args, String yaml) {

        System.setProperty("cassandra.rpc_port", "9160");
        System.setProperty("cassandra.start_native_transport", "true"); // 启用native
                                                                        // server，用于支持CQL
        System.setProperty("cassandra.native_transport_port", "9042");

        System.setProperty("cassandra.config", yaml);

        System.setProperty("log4j.defaultInitOverride", "true");
        System.setProperty("log4j.configuration", "my-log4j-server.properties");

        System.setProperty("cassandra.start_rpc", "false"); // 不启用thrift server

        System.setProperty("cassandra-foreground", "true"); // 打印输出到控制台

        System.setProperty("cassandra-pidfile", "pidfile.txt");

        //System.setProperty("cassandra.load_ring_state", "false"); // 不从system.peers表加载ring状态信息

        //见org.apache.cassandra.service.StorageService.getRingDelay()
        //默认30秒，等太久了
        System.setProperty("cassandra.ring_delay_ms", "7000");

        //org.apache.cassandra.db.Memtable里的默认值是10万，这会触发大量的JVMTI方法进入退出事件
        System.setProperty("cassandra.memtable_row_overhead_computation_step", "100");

        System.setProperty("cassandra.unsafesystem", "true"); //不要每次更新元数据就刷新到硬盘，产生大量文件，只在测试时用
        
        CassandraDaemon.main(args);
    }

}
