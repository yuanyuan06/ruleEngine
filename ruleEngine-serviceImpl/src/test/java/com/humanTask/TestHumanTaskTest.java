package com.humanTask;


import com.engine.dao.HumanTaskDao;
import com.engine.entity.task.HumanTask;
import com.engine.entity.task.Incident;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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


    @Test
    public void testInsertIncident(){
        Incident incident = new Incident();
        incident.setDocNum("incident");
        humanTaskDao.insertIncident(incident);
    }

    @Test
    public void testBatchInsert(){
        List<Incident> list = new ArrayList<>();
        for(int i =0; i < 10; i++){
            Incident incident = new Incident();
            incident.setDocNum("incident");
            list.add(incident);
        }
        humanTaskDao.batchInsertIncident(list);
    }


}
