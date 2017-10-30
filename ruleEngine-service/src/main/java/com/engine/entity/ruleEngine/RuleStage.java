package com.engine.entity.ruleEngine;

import com.engine.base.BaseEntity;

import java.util.List;


/**
 * 表: rule_stage
 */
public class RuleStage extends BaseEntity {

    private static final long serialVersionUID = 8917418790147547797L;

    /**
     * stage编码
     */
    private String docNum;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
