package com.context;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.xml"})
public @interface CustomContextTest {
}
