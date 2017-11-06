package com.engine.service.ruleEngine;

import com.alibaba.fastjson.JSON;
import com.engine.dao.RuleConfigDao;
import com.engine.entity.ruleEngine.RuleSnippet;
import groovy.lang.Binding;
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("ruleConfigService")
public class RuleConfigServiceImpl implements RuleConfigService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 脚本缓存
     */
    private Map<String, Invocable> scriptCache;

    private ScriptEngine groovyScriptEngine;

    /**
     * 脚本 stage 关系
     */
    private Map<String, List<String>> stageSnippet = new HashMap<>();

    @Autowired
    private RuleConfigDao ruleConfigDao;


    @Override
    public void testMethod() {
        System.out.println("come in");
    }

    /**
     * 加载脚本并放入缓存
     * @return
     */
    @Override
    public void initScripts() {
        reloadScripts();
    }


    @Override
    public void reloadScripts() {
        List<RuleSnippet> allRule = ruleConfigDao.findAllRule();
        groovyScriptEngine  = new GroovyScriptEngineImpl();
        SimpleScriptContext ssc = new SimpleScriptContext();
        for (RuleSnippet config: allRule){
            try {
                Invocable eval = (Invocable) groovyScriptEngine.eval(config.getScript());
            } catch (ScriptException e) {
                logger.error("groovy 脚本初始化异常", e);
            }
        }
    }

    @Override
    public ScriptEngine getEngine() {
        return groovyScriptEngine;
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
        try {
            Object o = ((Invocable) groovyScriptEngine).invokeFunction(docNum, object);
            result = JSON.toJSONString(o);
        } catch (ScriptException | NoSuchMethodException e) {
            logger.error("groovy 脚本执行异常", e);
        }
        return result;
    }

    public ScriptEngine getGroovyScriptEngine() {
        return groovyScriptEngine;
    }
}
