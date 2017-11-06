package com.context;


import com.alibaba.fastjson.JSON;
import com.engine.command.StageSnippetCommand;
import com.engine.dao.RuleConfigDao;
import com.engine.service.ruleEngine.RuleConfigService;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring.xml"})
public class RootAppContextTest {

    @Autowired
    private RuleConfigDao ruleConfigDao;


    @Test
    public void testLoad(){
        System.out.println("come in");
    }



    @Test
    public void testDao(){

        List<StageSnippetCommand> strings = ruleConfigDao.querySnippetGroupByStage();
        String s = JSON.toJSONString(strings);
        System.out.println(s);
    }



}
