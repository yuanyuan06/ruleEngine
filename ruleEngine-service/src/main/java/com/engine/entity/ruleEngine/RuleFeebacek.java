package com.engine.entity.ruleEngine;

import com.engine.base.BaseEntity;

/**
 * 应用规则反馈结果
 */
public class RuleFeebacek extends BaseEntity {

    private static final long serialVersionUID = -5545057350168689040L;

    /**
     * 规则执行反馈
     */
    private String resultMsg;

    /**
     * 执行action
     */
    private String execAction;


    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }

    public String getExecAction() {
        return execAction;
    }

    public void setExecAction(String execAction) {
        this.execAction = execAction;
    }
}
