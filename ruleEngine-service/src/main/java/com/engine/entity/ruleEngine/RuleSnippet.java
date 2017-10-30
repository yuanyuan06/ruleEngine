package com.engine.entity.ruleEngine;

import com.engine.base.BaseEntity;

import java.util.Date;

/**
 * 任务
 * 表: rule_snippet
 */
public class RuleSnippet extends BaseEntity {

    private static final long serialVersionUID = 4861419277164881114L;

    /**
     * 编码
     */
    private String docNum;

    /**
     * 脚本
     */
    private String script;
    /**
     * 描述
     */
    private String description;

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
