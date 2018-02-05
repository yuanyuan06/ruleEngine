package com.common;

import com.alibaba.fastjson.JSON;
import com.engine.entity.ruleEngine.RuleSnippet;
import com.engine.entity.task.Incident;
import com.services.TestService;
import org.junit.Test;

import javax.net.ssl.SNIHostName;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import java.util.Iterator;
import java.util.ServiceLoader;

public class CommonTest {

    @Test
    public void test(){
        int i=1, j=0;
        switch (i){
            case 1:
                j+=100;
            case 2:
                j+=6;
            case 0:
                j+=4;
            case 5:
                j+=5;
            default:
                j+=2;
            case 4:
                j+=1;
        }
        System.out.println(j);
    }

    @Test
    public void testFast(){
        Incident incident = new Incident();
        incident.setDocNum("hh");
        String s = JSON.toJSONString(incident);
        System.out.println(s);
    }

    @Test
    public void tet(){
        ServiceLoader<TestService> ss = ServiceLoader.load(TestService.class);
        Iterator<TestService> iterator = ss.iterator();

        while (iterator.hasNext()){
            iterator.next().hello();
        }
    }

    @Test
    public void testCons() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Constructor<RuleSnippet> constructor = RuleSnippet.class.getConstructor();
        RuleSnippet snippet = constructor.newInstance("33", "22","11");
        System.out.println(snippet);
    }
}
