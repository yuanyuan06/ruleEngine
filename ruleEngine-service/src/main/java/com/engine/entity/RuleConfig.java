package com.engine.entity;

import com.engine.base.BaseEntity;

import java.util.Date;

/**
 * 任务
 */
public class RuleConfig extends BaseEntity {

    private static final long serialVersionUID = 4861419277164881114L;

    private Long id;
    private String docNum;
    private Integer priority;
    private Integer module;
    private Integer stage;
    private String script;
    private String decription;
    private Date createTime;
    private Long createUser;
    private Long version;
    private Date lastModifyTime;
    private Long lastModifyUser;

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

    public Integer getModule() {
        return module;
    }

    public void setModule(Integer module) {
        this.module = module;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Long getLastModifyUser() {
        return lastModifyUser;
    }

    public void setLastModifyUser(Long lastModifyUser) {
        this.lastModifyUser = lastModifyUser;
    }
}
