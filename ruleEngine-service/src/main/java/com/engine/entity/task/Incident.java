package com.engine.entity.task;

import com.engine.base.BaseEntity;

import java.util.Date;

/**
 * 事件
 */
public class Incident extends BaseEntity {

    private static final long serialVersionUID = -3857976520021706643L;

    private String docNum;                          //事件编码
    private String name;                            //事件名称
    private Long taskId;                            //所属任务
    private Long orderItem;                         //关联单据明细
    private String inducement;                      //事件触发原因, json封装

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

    public Long getTaskId() {
        return taskId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(Long orderItem) {
        this.orderItem = orderItem;
    }

    public String getInducement() {
        return inducement;
    }

    public void setInducement(String inducement) {
        this.inducement = inducement;
    }

}
