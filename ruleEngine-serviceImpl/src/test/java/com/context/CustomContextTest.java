package com.context;


import org.springframework.test.context.ContextConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.xml"})
public @interface CustomContextTest {
}
