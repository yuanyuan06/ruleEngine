package com.engine.dao;

import com.engine.command.StageSnippetCommand;
import com.engine.entity.ruleEngine.RuleSnippet;

import java.util.List;

public interface RuleConfigDao {

    /**
     * 查询所有规则
     * @return
     */
    List<RuleSnippet> findAllRule();


    /**
     * 分组查询stage snippet
     * @return
     */
    List<StageSnippetCommand> querySnippetGroupByStage();


}
