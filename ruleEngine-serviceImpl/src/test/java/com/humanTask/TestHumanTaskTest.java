package com.humanTask;


import com.engine.dao.HumanTaskDao;
import com.engine.entity.task.HumanTask;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations={"classpath*:spring/spring.xml"})
public class TestHumanTaskTest {

    @Autowired
    private HumanTaskDao humanTaskDao;

    @Test
    public void testInsert(){

        HumanTask humanTask = new HumanTask();
        humanTask.setDocNum("test");
        humanTaskDao.insertHumanTask(humanTask);


    }
}
