package com.engine.ao;

import com.engine.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("demoAo")
public class DemoAoImpl implements  DemoAo {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DemoService demoService;

    @Override
    public void demoAo() {

        logger.error("hello come in ao");
        demoService.demoMethod();


    }
}
