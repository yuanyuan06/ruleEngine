package com.engine.dao;

import com.engine.entity.RuleConfig;

import java.util.List;

public interface RuleConfigDao {

    /**
     * 查询所有规则
     * @return
     */
    List<RuleConfig> findAllRule();


}
