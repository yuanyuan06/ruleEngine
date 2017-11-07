package com.engine.service.ruleEngine;

import com.engine.service.execAction.ActionCache;
import com.engine.service.ruleEngine.EngineService;
import com.esotericsoftware.reflectasm.MethodAccess;
import javafx.application.Application;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import javax.swing.*;


@Service("engineService")
public class EngineServiceImpl implements EngineService {



    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RuleConfigService ruleConfigService;

    @Override
    public void applyEngine(String shopNum, String stage, Object obj) throws ScriptException, NoSuchMethodException {

        ScriptEngine engine = ruleConfigService.getEngine();

        // 获取该店铺下规则包
        if (StringUtils.isNotBlank(stage)) {               // 指定规则

        } else {                                           // 未指定规则, 该店铺下规则遍历

        }

        // 执行一组组脚本代码块
        for (String snippet : new String[]{"snippet"}) {
            ActionCache.ActionEntity action = new ActionCache.ActionEntity();
            Object o = ((Invocable) engine).invokeFunction(snippet, action);
            ActionCache.addAction(action);
        }
        

        // exec Action one by one
        for (ActionCache.ActionEntity action: ActionCache.entities) {
            Object actualAction = applicationContext.getBean(action.getClazz());
            MethodAccess methodAccess = ActionCache.getCache(action.getClazz());
            Object method = methodAccess.invoke(actualAction, action.getMethod(), action.getArgs());
        }

    }
}
