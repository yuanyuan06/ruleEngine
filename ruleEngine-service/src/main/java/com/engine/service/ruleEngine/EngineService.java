package com.engine.service.ruleEngine;

import javax.script.ScriptException;

public interface EngineService {

    /**
     *
     * @param shopNum
     * @param stageNum
     * @param obj
     * @return
     */
    void applyEngine(String shopNum, String stageNum, Object obj) throws ScriptException, NoSuchMethodException;


    /**
     * stage & snippet 缓存维护
     */
    void cacheStage();



}
