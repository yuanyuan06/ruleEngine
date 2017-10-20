package com.engine.dao;

import com.engine.entity.RuleConfig;

import java.util.List;
import java.util.Map;

public interface DemoDao {

    List<RuleConfig> queryRuleConfig(Map<String, Object> param);
}
