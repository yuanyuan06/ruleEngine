package com.engine.dao;

import com.engine.entity.ruleEngine.RuleSnippet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DemoDao {

    List<RuleSnippet> queryRules();

    @Select("SELECT * FROM rule_conf t where t.id = #{pk}")
    List<RuleSnippet> queryRuleList(@Param("pk")Long id);


    @Insert("INSERT INTO test (json) VALUES (#{json})")
    void testSave(@Param("json") String json);
}
