package com.testDao;


import com.engine.dao.RuleConfigDao;
import com.engine.entity.ruleEngine.RuleSnippet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring.xml"})
public class TestDao {

    @Autowired
    private RuleConfigDao ruleConfigDao;

    @Test
    public void tt(){
        List<RuleSnippet> allRuleByDate = ruleConfigDao.findAllRuleByDate(new Date());

    }

}
