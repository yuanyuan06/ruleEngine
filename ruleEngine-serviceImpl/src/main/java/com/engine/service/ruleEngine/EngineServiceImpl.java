package com.engine.service.ruleEngine;

import com.engine.service.ruleEngine.EngineService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;


@Service("engineService")
public class EngineServiceImpl implements EngineService {

    @Override
    public void applyEngine(String shopNum, String stage, Object obj) {

        // 获取该店铺下规则包
        if (StringUtils.isNotBlank(stage)) {               // 指定规则

        } else {                                           // 未指定规则, 该店铺下规则遍历

        }

        // execAction
    }
}
