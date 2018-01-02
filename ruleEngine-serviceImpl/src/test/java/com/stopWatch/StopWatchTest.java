package com.stopWatch;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

/**
 * @author yuan.yuan1
 * @date 2017/12/8 14:12
 */
public class StopWatchTest {

    private ThreadLocal<Stopwatch> googleWatch = new ThreadLocal<>();
    private ThreadLocal<org.springframework.util.StopWatch> springWatch = new ThreadLocal<>();
    private ThreadLocal<StopWatch> apacheWatch = new ThreadLocal<>();

    /**
     * google stopwatch
     * @throws InterruptedException
     */
    @Test
    public void testGoogleStopWatch() throws InterruptedException {
        googleWatch.set(Stopwatch.createStarted());
        Stopwatch stopwatch = googleWatch.get();
        Thread.sleep(1000L);
        stopwatch.stop();
        stopwatch.start();

        Thread.sleep(2000L);
        stopwatch.stop();

        System.out.println(stopwatch.toString());
    }

    @Test
    public void testSpringStopWatch() throws InterruptedException {
        springWatch.set(new org.springframework.util.StopWatch());
        org.springframework.util.StopWatch stopWatch = springWatch.get();



        stopWatch.start("haha");
        Thread.sleep(1000L);
        stopWatch.stop();


        stopWatch.start("hehe");
        Thread.sleep(2000L);
        stopWatch.stop();



        stopWatch.start("wawa");
        Thread.sleep(2000L);
        stopWatch.stop();

        System.out.println(stopWatch.prettyPrint());
        System.out.println(stopWatch.shortSummary());
    }

    @Test
    public void tsetApacheStopWatch() throws InterruptedException {
        apacheWatch.set(new StopWatch());
        StopWatch stopWatch = apacheWatch.get();

        stopWatch.start();
        Thread.sleep(1000L);
        stopWatch.stop();


        stopWatch.reset();
        stopWatch.start();
        Thread.sleep(2000L);
        stopWatch.stop();



        stopWatch.reset();
        stopWatch.start();
        Thread.sleep(2000L);
        stopWatch.stop();

        System.out.println(stopWatch.toString());

    }

    @Test
    public void multThreadStopWatchForSpring(){
//        for(int i = 0 ){
//
//        }


    }


}

