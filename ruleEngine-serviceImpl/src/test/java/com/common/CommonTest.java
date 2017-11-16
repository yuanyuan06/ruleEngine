package com.common;

import com.alibaba.fastjson.JSON;
import com.engine.entity.task.Incident;
import org.junit.Test;

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
}
