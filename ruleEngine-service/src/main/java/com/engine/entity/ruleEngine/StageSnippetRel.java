package com.engine.entity.ruleEngine;

import com.engine.base.BaseEntity;

/**
 *
 * stage 与规则片段的关系 & snippet 的执行优先级
 * relationship stage snippet
 */
public class StageSnippetRel extends BaseEntity{

    /**
     * 主键
     */
    private Long id;
    /**
     * stage编码
     */
    private String stageNum;
    /**
     * 规则片段编码
     */
    private String snippetNum;

    /**
     * stage 内 snippet 的执行优先级
     */
    private Integer priority;
}
