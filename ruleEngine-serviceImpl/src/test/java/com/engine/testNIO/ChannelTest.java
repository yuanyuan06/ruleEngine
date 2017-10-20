package com.engine.testNIO;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class ChannelTest {

    @Test
    public void rFile() throws Exception {
        RandomAccessFile file = new RandomAccessFile("C:\\Users\\yuan.yuan1\\Desktop\\平台退款数据结构.md", "rw");

        String str = null;
        while ((str = file.readLine()) != null){
            System.out.println(new String(str.getBytes("8859_1"), "utf-8"));
        }
    }


    @Test
    public void mappedByteBufferTest() throws IOException {
//        int length = 0x8FFFFFF; // 128 Mb
        int length = 100; // 128 Mb
        byte[] ds = new byte[(int) length];
        MappedByteBuffer out = new RandomAccessFile("C:\\Users\\yuan.yuan1\\Desktop\\平台退款数据结构.md", "rw")
                .getChannel()
                    .map(FileChannel.MapMode.READ_WRITE, 0, length);

        for(int i = 0; i < length; i++){
            byte b = out.get();
            ds[i] = b;
        }

        Scanner scan = new Scanner(new ByteArrayInputStream(ds)).useDelimiter(" ");
        while (scan.hasNext()) {
            System.out.print(scan.next() + " ");
        }
    }


    @Test
    public void bufferTest(){
        byte[] bytes = new byte[10];
        ByteBuffer bb = ByteBuffer.wrap(bytes);
        ByteBuffer allocate = ByteBuffer.allocate(10);
        System.out.println(bb.capacity() + "::" + allocate.capacity());

        CharBuffer cb = CharBuffer.allocate(10);
        char[] chars = new char[10];
        CharBuffer cbb = CharBuffer.wrap(chars);
        System.out.println(cb.capacity() + "::" + cbb.capacity());
        System.out.println(bb.remaining() + ":: remaining ::" + cb.remaining());
        System.out.println(bb.hasRemaining() + ":: hasRemaining ::" + cb.hasRemaining());

    }

}
