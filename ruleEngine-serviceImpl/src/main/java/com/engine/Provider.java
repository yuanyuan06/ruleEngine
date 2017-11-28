package com.engine;

import com.alibaba.dubbo.common.utils.ConfigUtils;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.FileInputStream;

public class Provider {

    public static final String SPRING_CONFIG = "dubbo.spring.config";
    public static final String DEFAULT_SPRING_CONFIG = "classpath*:spring/*.xml";
    static ClassPathXmlApplicationContext context;


    public static void main(String[] args) throws Exception {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:log4j2.xml");
        String path = resource.getURL().getPath();


        ConfigurationSource configurationSource = new ConfigurationSource(new FileInputStream(path));
        Configurator.initialize(null, configurationSource);


        String configPath = ConfigUtils.getProperty(SPRING_CONFIG);
        if (configPath == null || configPath.length() == 0) {
            configPath = DEFAULT_SPRING_CONFIG;
        }
        context = new ClassPathXmlApplicationContext(configPath.split("[,\\s]+"));
        context.start();
        context.start();
        System.out.println("dubbo service start successful");

        System.in.read(); // 按任意键退出
    }
}
