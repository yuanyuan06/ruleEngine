package com.engine.service.task;

public interface TaskService {


    /**
     * 谁
     * 单据
     * 单据明细
     * 什么任务
     * 描述
     * @param userId
     * @param description
     */
    void createTask(Long userId, String description);
}
