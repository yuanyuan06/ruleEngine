package com.engine.entity.task;

import com.engine.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;

public class HumanTask extends BaseEntity {

    private static final long serialVersionUID = -8125221784293871208L;

    private Long id;								//主键
    private String docNum;							//任务编码
    private String name;							//任务名称
    private String role;							//角色编码
    private Integer orderType;						//单据类型
    private Integer type;							//任务类型
    private Long user;								//任务所属用户
    private Integer status;							//任务状态
    private Long ordeId;							//相关单据

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Long getOrdeId() {
        return ordeId;
    }

    public void setOrdeId(Long ordeId) {
        this.ordeId = ordeId;
    }
}
