package com.engine.entity.ruleEngine;

import com.engine.base.BaseEntity;

import java.util.Date;

/**
 * 任务
 */
public class RuleSnippet extends BaseEntity {

    private static final long serialVersionUID = 4861419277164881114L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 编码
     */
    private String docNum;
    /**
     * 优先级
     */
    private Integer priority;
    /**
     * 脚本
     */
    private String script;
    /**
     * 描述
     */
    private String decription;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

}
