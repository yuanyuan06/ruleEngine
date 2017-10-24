package com.engine.entity;

import com.engine.base.BaseEntity;

import java.util.List;

public class ShopRulePackage extends BaseEntity {

    private static final long serialVersionUID = -7780604399643893974L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 编码
     */
    private String docNum;
    /**
     * 店铺编码
     */
    private String shopDocNum;
    /**
     * 规则包裹编码
     */
    private String packageDocNum;

    /**
     * 是否默认配置
     */
    private Boolean defaultConfig;


    /**
     * 优先级
     */
    private Integer priority;


    /**
     * 店铺规则包裹
     */
    private List<RulePackage> packages;


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

    public String getShopDocNum() {
        return shopDocNum;
    }

    public void setShopDocNum(String shopDocNum) {
        this.shopDocNum = shopDocNum;
    }

    public String getPackageDocNum() {
        return packageDocNum;
    }

    public void setPackageDocNum(String packageDocNum) {
        this.packageDocNum = packageDocNum;
    }


    public List<RulePackage> getPackages() {
        return packages;
    }

    public void setPackages(List<RulePackage> packages) {
        this.packages = packages;
    }

    public Boolean getDefaultConfig() {
        return defaultConfig;
    }

    public void setDefaultConfig(Boolean defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}
