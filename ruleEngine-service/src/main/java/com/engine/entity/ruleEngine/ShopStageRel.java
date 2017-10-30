package com.engine.entity.ruleEngine;

import com.engine.base.BaseEntity;

/**
 * 店铺与stage 关联关系& stage 执行优先级
 */
public class ShopStageRel extends BaseEntity {

    private static final long serialVersionUID = 1608663849530691202L;

    /**
     * 店铺编码
     * 店铺关系上需表示是否开启特殊规则
     * 0*docNum defaule
     * 1*docNum 开启定制逻辑
     *
     * 数据初始化阶段 该字段必含0
     */
    private String shopNum;
    /**
     * stage 编码
     */
    private String stageNum;
    /**
     * 店铺下stage执行优先级
     */
    private Integer priority;


    public String getShopNum() {
        return shopNum;
    }

    public void setShopNum(String shopNum) {
        this.shopNum = shopNum;
    }

    public String getStageNum() {
        return stageNum;
    }

    public void setStageNum(String stageNum) {
        this.stageNum = stageNum;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
