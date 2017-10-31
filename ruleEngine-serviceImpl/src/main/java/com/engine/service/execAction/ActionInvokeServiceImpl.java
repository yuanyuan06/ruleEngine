package com.engine.service.execAction;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service("actionInvokeService")
public class ActionInvokeServiceImpl implements  ActionInvokeService {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void invoke() {
        System.out.println("come in");
        Object bean = applicationContext.getBean("bean");


    }
}