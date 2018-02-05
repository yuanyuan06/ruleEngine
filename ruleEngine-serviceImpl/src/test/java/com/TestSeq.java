package com;

import org.junit.Test;

public class TestSeq {




    @Test
    public void testSeq(){
        Snowflake sf = new Snowflake(1024);
        long id = sf.next();
        System.out.println(Long.toBinaryString(id)+"---"+Long.toBinaryString(id).length());//首位有个0，总长为64位
        System.out.println(id);
    }

    class Snowflake {
        public static final int NODE_SHIFT = 10;
        public static final int SEQ_SHIFT = 12;

        public static final short MAX_NODE = 1024; // 机器总数量
        public static final short MAX_SEQUENCE = 4096; // 毫秒最大数量

        private short sequence;  // 计数
        private long referenceTime; // 引用时间

        private int node;

        public Snowflake(int node) {
            if (node < 0 || node > MAX_NODE) {
                throw new IllegalArgumentException(String.format("node must be between %s and %s", 0, MAX_NODE));
            }
            this.node = node;
        }

        public long next() {

            long currentTime = System.currentTimeMillis();
            long counter;

            synchronized (this) {

                if (currentTime < referenceTime) {
                    throw new RuntimeException(
                            String.format("Last referenceTime %s is after reference time %s", referenceTime, currentTime));
                } else if (currentTime > referenceTime) {
                    this.sequence = 0;
                } else {
                    if (this.sequence < Snowflake.MAX_SEQUENCE) {
                        this.sequence++;
                    } else {
                        throw new RuntimeException("Sequence exhausted at " + this.sequence);
                    }
                }
                counter = this.sequence;
                referenceTime = currentTime;
            }

            return currentTime << NODE_SHIFT << SEQ_SHIFT | node << SEQ_SHIFT | counter;
        }
    }
}
