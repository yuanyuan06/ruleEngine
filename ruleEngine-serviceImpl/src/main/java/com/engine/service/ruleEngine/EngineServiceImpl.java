package com.engine.service.ruleEngine;

import com.engine.service.ruleEngine.EngineService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.script.ScriptEngine;


@Service("engineService")
public class EngineServiceImpl implements EngineService {



    @Autowired
    private RuleConfigService ruleConfigService;

    @Override
    public void applyEngine(String shopNum, String stage, Object obj) {

        ScriptEngine engine = ruleConfigService.getEngine();

        // 获取该店铺下规则包
        if (StringUtils.isNotBlank(stage)) {               // 指定规则

        } else {                                           // 未指定规则, 该店铺下规则遍历

        }

        // execAction
    }
}
