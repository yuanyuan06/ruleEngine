package com.engine.dao;

import com.engine.entity.task.HumanTask;
import com.engine.entity.task.Incident;

import java.util.List;

public interface HumanTaskDao {

    void insertHumanTask(HumanTask humanTask);

    void insertIncident(Incident incident);

    void batchInsertIncident(List<Incident> list);
}
