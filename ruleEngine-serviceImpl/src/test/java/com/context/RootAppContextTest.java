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

import javax.xml.transform.Source;
import java.util.List;
import java.util.Map;

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

        List<StageSnippetCommand> stringObjectMap = ruleConfigDao.querySnippetGroupByStage();
        System.out.println(JSON.toJSONString(stringObjectMap));
    }



}
