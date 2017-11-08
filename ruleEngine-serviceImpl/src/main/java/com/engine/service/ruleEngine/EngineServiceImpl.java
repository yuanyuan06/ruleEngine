package com.engine.service.ruleEngine;

import com.engine.command.StageSnippetCommand;
import com.engine.dao.RuleConfigDao;
import com.engine.service.execAction.ActionCache;
import com.esotericsoftware.reflectasm.MethodAccess;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service("engineService")
public class EngineServiceImpl implements EngineService {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RuleConfigService ruleConfigService;
    @Autowired
    private RuleConfigDao ruleConfigDao;


    private Map<String, List<String>> stageSnippet = new LinkedHashMap<>();

    @Override
    public void applyEngine(String shopNum, String stage, Object obj) throws ScriptException, NoSuchMethodException {

        // 获取该店铺下规则包
        if (StringUtils.isNotBlank(stage)) {               // 指定规则
            List<String> snippets = stageSnippet.get(stage);
            execSnippet(snippets);
        } else {                                           // 未指定规则, 该店铺下规则遍历
            for(Map.Entry<String, List<String>> entry: stageSnippet.entrySet()){
                List<String> snippets = entry.getValue();
                execSnippet(snippets);
            }
        }

        // exec Action one by one
        for (ActionCache.ActionEntity action: ActionCache.entities) {
            Object actualAction = applicationContext.getBean(action.getClazz());
            MethodAccess methodAccess = ActionCache.getCache(action.getClazz());
            Object method = methodAccess.invoke(actualAction, action.getMethod(), action.getArgs());
        }
    }


    private void execSnippet(List<String> snippetNums) throws ScriptException, NoSuchMethodException {
        for (String snippetNum : snippetNums) {
            ScriptEngine engine = ruleConfigService.getEngine();
            ActionCache.ActionEntity action = ActionCache.newAction();
            Object o = ((Invocable) engine).invokeFunction(snippetNum, action);
            ActionCache.addAction(action);
        }
    }


    @Override
    public void cacheStage() {
        List<StageSnippetCommand> stages = ruleConfigDao.querySnippetGroupByStage();
        for (StageSnippetCommand stage : stages) {
            stageSnippet.put(stage.getStageNum(), stage.getSnippetNums());
        }
    }
}
