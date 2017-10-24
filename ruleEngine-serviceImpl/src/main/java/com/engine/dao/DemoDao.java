package com.engine.dao;

import com.engine.entity.RuleConfig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoDao {

    List<RuleConfig> queryRules();

    @Select("SELECT * FROM rule_conf t where t.id = #{pk}")
    List<RuleConfig> queryRuleList(@Param("pk")Long id);


    @Insert("INSERT INTO test (json) VALUES (#{json})")
    void testSave(@Param("json") String json);
}
