package com.engine.service;

import org.apache.commons.lang3.StringUtils;

public class EngineServiceImpl implements EngineService {


    @Override
    public String applyEngine(String shopNum, String stage, Object obj) {

        // 获取该店铺下规则包


        if(StringUtils.isNotBlank(stage)){     // 指定规则

        }else{                                          // 未指定规则, 该店铺下规则遍历

        }
        return null;
    }
}
