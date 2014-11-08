/*
 * Copyright 2011 The Apache Software Foundation
 *
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
package my.test.datacenter;

public class Main {

    static class NodeThread extends Thread {
        int i;
        String[] args;

        public NodeThread(int i, String[] args) {
            super("NodeThread-" + i);
            this.i = i;
            this.args = args;
        }

        public void run() {
            switch (i) {
            case 1:
                Node1.main(args);
                break;
            case 2:
                Node2.main(args);
                break;
            case 3:
                Node3.main(args);
                break;
            case 4:
                Node4.main(args);
                break;
            case 5:
                Node5.main(args);
                break;
            case 6:
                Node6.main(args);
                break;
            default:
                throw new Error("i=" + i);
            }

        }
    }

    /**
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        int count = 3;
        NodeThread[] threads = new NodeThread[count];
        for (int i = 0; i < count; i++) {
            threads[i] = new NodeThread(i + 1, args);
        }

        for (int i = 0; i < count; i++) {
            threads[i].start();
        }

        for (int i = 0; i < count; i++) {
            threads[i].join();
        }

    }

}
