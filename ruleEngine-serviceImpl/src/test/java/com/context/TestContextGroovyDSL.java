package com.context;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring.groovy"})
public class TestContextGroovyDSL {


    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testLoad(){
        Object bean = applicationContext.getBean("demoDao");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            System.out.println(stackTraceElement.getClassName() + " " + stackTraceElement.getMethodName() + " " + stackTraceElement.getLineNumber());
        }
    }

}
