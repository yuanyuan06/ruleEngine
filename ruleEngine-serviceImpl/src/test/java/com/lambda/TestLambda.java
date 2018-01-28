package com.lambda;

import org.junit.Test;

/**
 * @author yuan.yuan1
 * @date 2017/12/14 13:43
 */
public class TestLambda {

    @Test
    public void test() throws InterruptedException {
        new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
        Thread.sleep(1000L);

    }
}
