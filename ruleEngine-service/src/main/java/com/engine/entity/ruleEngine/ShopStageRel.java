package com.engine.entity.ruleEngine;

import com.engine.base.BaseEntity;

public class ShopStageRel extends BaseEntity {

    /**
     * 主键
     */
    private Long id;
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

}
