package com.engine.entity;

import com.engine.base.BaseEntity;

import java.util.Date;

/**
 * 任务
 */
public class Rule extends BaseEntity {

    private static final long serialVersionUID = 4861419277164881114L;

    private Long id;                                   //主键
    private String docNum;                             //编码
    private Integer level;                             //等级
    private Integer type;                              //类型
    private String decription;                         //描述
    private Date createTime;                           //创建时间
    private Long createUser;                           //创建人
    private Long version;                              //版本号
    private Date lastModifyTime;                       //最后修改时间
    private Long lastModifyUser;                       //最后修改人


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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
