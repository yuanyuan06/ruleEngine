package com.engine.service.ruleEngine;

import com.engine.command.StageSnippetCommand;
import com.engine.dao.RuleConfigDao;
import com.engine.service.execAction.ActionCache;
import com.esotericsoftware.reflectasm.MethodAccess;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.script.Invocable;
import javax.script.ScriptException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@Service("engineService")
public class EngineServiceImpl implements EngineService, InitializingBean {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RuleConfigService ruleConfigService;
    @Autowired
    private RuleConfigDao ruleConfigDao;


    private Map<String, List<String>> stageSnippet = new LinkedHashMap<>();


    private ScriptFeedback execSnippet(List<String> snippetNums) throws ScriptException, NoSuchMethodException {
        ScriptFeedback feedback = new ScriptFeedback();
        for (String snippetNum : snippetNums) {
            // 执行脚本
            Invocable invocable = ruleConfigService.getInvocable();
            ActionCache.ActionEntity action = ActionCache.newAction();
            Boolean bindAction = false;
            Object o = invocable.invokeFunction(snippetNum, bindAction, action);

            feedback.putFeedback(o, null);
        }
        return  feedback;
    }


    @Override
    public List<Feedback> applyEngine(String shopNum, String stage, Object obj) throws ScriptException, NoSuchMethodException {
        List<Feedback> list = new ArrayList<>();
        // 获取该店铺下规则包
        // 获取规则反馈 & 需要执行的 action(method, class, args)
        if (StringUtils.isNotBlank(stage)) {               // 指定规则
            List<String> snippets = stageSnippet.get(stage);
            ScriptFeedback feedback = execSnippet(snippets);
            list.add(feedback);
        } else {                                           // 未指定规则, 该店铺下规则遍历
            for(Map.Entry<String, List<String>> entry: stageSnippet.entrySet()){
                List<String> snippets = entry.getValue();
                ScriptFeedback feedback = execSnippet(snippets);
                list.add(feedback);
            }
        }

        // 根据所有执行结果, 获取需要执行的action
        Invocable invocable = ruleConfigService.getInvocable();
        List<ActionCache.ActionEntity> actionList = (List<ActionCache.ActionEntity>) invocable.invokeFunction("voteAction", list);

        for(ActionCache.ActionEntity action: actionList){
            // 执行 action list
            Object actualAction = applicationContext.getBean(action.getClazz());
            MethodAccess methodAccess = ActionCache.getCache(action.getClazz());
            Object method = methodAccess.invoke(actualAction, action.getMethod(), action.getArgs());
        }

        return  list;
    }

    @Override
    public void cacheStage() {
        List<StageSnippetCommand> stages = ruleConfigDao.querySnippetGroupByStage();
        for (StageSnippetCommand stage : stages) {
            stageSnippet.put(stage.getStageNum(), stage.getSnippetNums());
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        cacheStage();
    }


    public class ScriptFeedback extends Feedback{

        private List<Object> snippetFeedback = new ArrayList<>();
        private List<Object> actionFeedback = new ArrayList<>();

        @Override
        void putFeedback(Object snippet, Object action){
            snippetFeedback.add(snippet);
            actionFeedback.add(action);
        }

        public List<Object> getSnippetFeedback() {
            return snippetFeedback;
        }

        public List<Object> getActionFeedback() {
            return actionFeedback;
        }
    }
}
