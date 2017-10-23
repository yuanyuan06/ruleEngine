package com.engine.service;

import com.alibaba.fastjson.JSON;
import com.engine.dao.RuleConfigDao;
import com.engine.entity.RuleConfig;
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptException;
import java.util.List;
import java.util.Map;

@Service("ruleConfigService")
public class RuleConfigServiceImpl implements RuleConfigService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 脚本缓存
     */
    private Map<String, Invocable> scriptCache;

    private GroovyScriptEngineImpl groovyScriptEngine;

    private Map<String, List<String>> map;

    @Autowired
    private RuleConfigDao ruleConfigDao;



    @Override
    public List<RuleConfig> loadAllScript() {
        return ruleConfigDao.findAllRule();
    }

    /**
     * 加载脚本并放入缓存
     * @return
     */
    @Override
    public void initScripts() {

        List<RuleConfig> allRule = ruleConfigDao.findAllRule();
        for (RuleConfig config: allRule){
            try {
                Invocable eval = (Invocable) groovyScriptEngine.eval(config.getScript());
                scriptCache.put(config.getDocNum(), eval);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }

    }


    /**
     * by 脚本编码执行相应的脚本
     * @param docNum
     * @param object
     * @return String
     */
    @Override
    public String execScript(String docNum, Object object) {

        String result = null;
//        Invocable invocable = scriptCache.get(docNum);
        try {
            Object o = groovyScriptEngine.invokeFunction(docNum, object);
            result = JSON.toJSONString(o);
        } catch (ScriptException | NoSuchMethodException e) {
            logger.error("groovy 脚本执行异常", e);
        }
        return result;
    }


}
