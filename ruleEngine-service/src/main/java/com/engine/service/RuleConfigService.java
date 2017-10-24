package com.engine.service;

import com.engine.entity.RuleConfig;

import javax.script.ScriptEngine;
import java.util.List;

public interface RuleConfigService {

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


    ScriptEngine getEngine();

}
