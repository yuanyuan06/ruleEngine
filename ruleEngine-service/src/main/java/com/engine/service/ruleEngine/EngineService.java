package com.engine.service.ruleEngine;

import javax.script.ScriptException;
import java.util.List;

public interface EngineService {

    /**
     *
     * @param shopNum
     * @param stageNum
     * @param obj
     * @return
     */
    List<Feedback> applyEngine(String shopNum, String stageNum, Object obj) throws ScriptException, NoSuchMethodException;


    /**
     * stage & snippet 缓存维护
     */
    void cacheStage();

    /**
     * 执行反馈
     */
    abstract class Feedback{

          abstract void putFeedback(Object snippet, Object action);
    }


}
