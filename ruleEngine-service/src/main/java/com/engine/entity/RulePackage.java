package com.engine.entity;

import com.engine.base.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 规则包裹
 */
public class RulePackage extends BaseEntity {

    private static final long serialVersionUID = -7802598259145341963L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 编码
     */
    private String docNum;
    /**
     * 规则配置编码
     */
    private String ruleDocNum;

    /**
     * 阶段
     */
    private Integer stage;
    /**
     * 模块
     */
    private Integer module;

    /**
     * 优先级
     */
    private Integer priority;

    /**
     * 包裹涵盖配置
     */
    private List<RuleConfig> configs;


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

    public String getRuleDocNum() {
        return ruleDocNum;
    }

    public void setRuleDocNum(String ruleDocNum) {
        this.ruleDocNum = ruleDocNum;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public List<RuleConfig> getConfigs() {
        return configs;
    }

    public void setConfigs(List<RuleConfig> configs) {
        this.configs = configs;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
