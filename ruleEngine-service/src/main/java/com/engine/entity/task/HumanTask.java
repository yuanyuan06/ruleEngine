package com.engine.entity.task;

import com.engine.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class HumanTask extends BaseEntity {

    private static final long serialVersionUID = -8125221784293871208L;

    private String docNum;							// 任务编码
    private String name;							// 任务名称
    private String role;							// 角色编码
    private Integer orderType;						// 单据类型
    private Integer type;							// 任务类型
    private Long user;								// 任务所属用户
    private Integer status;							// 任务状态
    private Long orderId;							// 相关单据


    private List<Incident> incidents;               // 包含明细事件

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


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public List<Incident> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incident> incidents) {
        this.incidents = incidents;
    }
}
