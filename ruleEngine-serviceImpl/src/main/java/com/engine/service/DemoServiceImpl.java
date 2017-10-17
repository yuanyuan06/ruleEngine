package com.engine.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void demoMethod() {
        logger.debug("hello come in service");
    }
}
