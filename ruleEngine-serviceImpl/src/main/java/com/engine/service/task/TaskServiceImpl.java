package com.engine.service.task;

import com.engine.entity.task.HumanTask;
import org.springframework.stereotype.Service;

@Service("taskService")
public class TaskServiceImpl implements TaskService {


    @Override
    public void createTask(Long userId, String description) {
        HumanTask task = new HumanTask();
    }
}
