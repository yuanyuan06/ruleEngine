package com.engine.service;

import com.engine.entity.ShopRulePackage;
import org.apache.commons.lang3.StringUtils;

public class EngineServiceImpl implements EngineService {


    @Override
    public String applyEngine(String shopNum, String stage, Object obj) {

        // 获取该店铺下规则包
        ShopRulePackage packages = null;


        if(StringUtils.isNotBlank(stage)){     // 指定规则
            packages.getPackages().contains(stage);

        }else{                                          // 未指定规则, 该店铺下规则遍历

        }
        return null;
    }
}
