package com.engine.entity.ruleEngine;

import com.engine.base.BaseEntity;

/**
 *
 * stage 与规则片段的关系 & snippet 的执行优先级
 * relationship stage snippet
 */
public class StageSnippetRel extends BaseEntity{

    private static final long serialVersionUID = -7452745544360572299L;
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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStageNum() {
        return stageNum;
    }

    public void setStageNum(String stageNum) {
        this.stageNum = stageNum;
    }

    public String getSnippetNum() {
        return snippetNum;
    }

    public void setSnippetNum(String snippetNum) {
        this.snippetNum = snippetNum;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
