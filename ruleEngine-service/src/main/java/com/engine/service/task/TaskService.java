package com.engine.service.task;

import com.engine.entity.task.HumanTask;

public interface TaskService {


    /**
     * 谁
     * 单据
     * 单据明细
     * 什么任务
     * 描述
     * @param userId
     * @param humanTask
     */
    void createTask(Long userId, HumanTask humanTask);
}
