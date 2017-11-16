package com.engine.service.task;

import com.engine.dao.HumanTaskDao;
import com.engine.entity.task.HumanTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

    @Autowired
    private HumanTaskDao humanTaskDao;


    @Override
    public void createTask(Long userId, HumanTask humanTask) {
        HumanTask task = new HumanTask();
        humanTaskDao.insertHumanTask(task);
        humanTaskDao.batchInsertIncident(task.getIncidents());
    }
}
