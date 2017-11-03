package com.context;


import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.xml"})
public class RootAppContextTest {

    @Autowired
    protected ApplicationContext applicationContext;

    @Test
    public void testLoad(){
        System.out.println("come in");
    }


}
