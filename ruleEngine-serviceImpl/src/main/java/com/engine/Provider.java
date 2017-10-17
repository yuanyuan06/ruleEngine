package com.engine;

import com.alibaba.dubbo.common.utils.ConfigUtils;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Provider {

    public static final String SPRING_CONFIG = "dubbo.spring.config";
    public static final String DEFAULT_SPRING_CONFIG = "classpath*:spring/*.xml";
    static ClassPathXmlApplicationContext context;


    public static void main(String[] args) throws Exception {
        String configPath = ConfigUtils.getProperty(SPRING_CONFIG);
        if (configPath == null || configPath.length() == 0) {
            configPath = DEFAULT_SPRING_CONFIG;
        }
        context = new ClassPathXmlApplicationContext(configPath.split("[,\\s]+"));
        context.start();
        context.start();
        System.in.read(); // 按任意键退出
    }
}
