package com.engine.service;

import com.engine.entity.RuleConfig;

import java.util.List;

public interface RuleConfigService {

    /**
     * 加载所有脚本
     * @return List<RuleConfig>
     */
    List<RuleConfig> loadAllScript();

    /**
     *初始化脚本
     */
    void initScripts();


    /**
     * 执行脚本编码执行脚本 by (stage/ docNum)
     * 不指定 全量 按优先级 顺序执行
     * @param docNum
     * @return
     */
    String execScript(String docNum, Object object);

    /**
     * 重新加载脚本
     */
    void reloadScripts();

}
