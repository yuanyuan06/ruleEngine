package com.engine.service;


import com.alibaba.fastjson.JSON;
import com.engine.entity.RuleConfig;
import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.io.*;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResourcePatternResolver resourcePatternResolver;
    @Autowired
    private ScriptEngine scriptEngine;

    @Override
    public void demoMethod(){

        try {
            Resource[] resources = resourcePatternResolver.getResources("classpath:groovy/*.groovy");
            for(Resource resource: resources){
                InputStream inputStream = resource.getInputStream();
                Reader reader = new InputStreamReader(inputStream);
                BufferedReader br = new BufferedReader(reader);
                String s = null;
                StringBuffer stringBuffer = new StringBuffer();
                while((s = br.readLine()) != null){
                    stringBuffer.append(s+"\n\r");
                }
                System.out.println(stringBuffer.toString());
                scriptEngine.eval(stringBuffer.toString());
            }
            RuleConfig rule = new RuleConfig();
            rule.setDocNum("code");
            Object sayHaHa = ((Invocable) scriptEngine).invokeFunction("sayHelo", rule);
            System.out.println(rule.getDocNum() + "::" + sayHaHa);
        } catch (Exception e) {
            logger.error("系统异常", e);
        }
        logger.debug("hello come in service");
    }
}
