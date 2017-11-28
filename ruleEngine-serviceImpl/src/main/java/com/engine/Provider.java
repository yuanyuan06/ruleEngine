package com.engine;

import com.alibaba.dubbo.common.utils.ConfigUtils;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.FileInputStream;
import java.io.IOException;

public class Provider {

    public static final String DEFAULT_SPRING_CONFIG = "classpath*:spring/*.xml";
    public static final String DEFAULT_LOG_CONFIG = "classpath:log4j2.xml";

    static ClassPathXmlApplicationContext context;

    private static void initLog4j2() throws IOException {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource(DEFAULT_LOG_CONFIG);
        String path = resource.getURL().getPath();


        ConfigurationSource configurationSource = new ConfigurationSource(new FileInputStream(path));
        Configurator.initialize(null, configurationSource);
    }


    public static void main(String[] args) throws Exception {

        initLog4j2();

        context = new ClassPathXmlApplicationContext(DEFAULT_SPRING_CONFIG);
        context.start();
        context.start();
        System.out.println("dubbo service start successful");

        System.in.read(); // 按任意键退出
    }
}
