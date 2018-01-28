package com.engine.service.test;

import com.engine.annotations.LogAnnotation;
import com.engine.entity.recordLog.InvokeLog;
import org.springframework.stereotype.Service;


@Service("testLogService")
public class TestLogServiceImpl implements  TestLogService {

    @Override
    @LogAnnotation()
    public void testLog(String str, String dd, String ll){
        InvokeLog invokeLog = new InvokeLog();

        System.out.println("helo ...");
    }
}
