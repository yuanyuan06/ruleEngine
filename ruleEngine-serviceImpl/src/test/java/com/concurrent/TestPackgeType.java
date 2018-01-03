package com.concurrent;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class TestPackgeType {

    private volatile AtomicInteger atomicInteger = new AtomicInteger();

    private volatile AtomicLong atomicLong = new AtomicLong();

    private boolean flag = true;


    @Test
    public void testAtomicInteger() throws InterruptedException {
       while(true){
           Thread.sleep(1000L);
           System.out.println(atomicInteger.getAndIncrement());
       }
    }

    @Test
    public void testAtomicLong() throws Exception {

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + " now: atomicLong " + atomicLong.getAndIncrement());
            }
        });

        while (flag){
            Thread.sleep(1000L);
            LocalDateTime now = LocalDateTime.now();
            System.out.println(now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME) + " " + atomicLong.getAndIncrement());
            if(atomicLong.get() == 15){
                LocalDate localDate = LocalDate.now();

                LocalTime localTime = LocalTime.now();

                System.out.println(localDate.format(DateTimeFormatter.ISO_LOCAL_DATE) + " " + localTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
                throw new Exception();
            }
        }


    }

}
