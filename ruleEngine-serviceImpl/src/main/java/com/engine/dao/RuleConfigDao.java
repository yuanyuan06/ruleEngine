package com.engine.dao;

import com.engine.entity.ruleEngine.RuleSnippet;

import java.util.List;

public interface RuleConfigDao {

    /**
     * 查询所有规则
     * @return
     */
    List<RuleSnippet> findAllRule();


}
