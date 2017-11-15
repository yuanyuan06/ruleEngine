package com.engine.service.task;

import com.engine.entity.task.Incident;
import com.engine.entity.task.Task;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service("taskService")
public class TaskServiceImpl implements TaskService {


    @Override
    public void createTask(Long userId, String description) {
        Task task = new Task();
    }
}
