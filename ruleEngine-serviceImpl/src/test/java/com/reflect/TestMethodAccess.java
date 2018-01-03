package com.reflect;

import com.alibaba.fastjson.JSON;
import com.engine.entity.task.HumanTask;
import com.engine.service.execAction.ActionInvokeService;
import com.engine.service.execAction.ActionInvokeServiceImpl;
import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestMethodAccess {

    @Test
    public void testInvoke(){
        MethodAccess methodAccess = MethodAccess.get(ActionInvokeService.class);
        ConstructorAccess constructorAccess = ConstructorAccess.get(ActionInvokeServiceImpl.class);
        Object o = constructorAccess.newInstance();
        methodAccess.invoke(o, "invoke", null);
    }


    @Test
    public void testSpringRef() throws InvocationTargetException, IllegalAccessException {
        PropertyDescriptor docNum = BeanUtils.getPropertyDescriptor(HumanTask.class, "docNum");
        Method writeMethod = docNum.getWriteMethod();

        HumanTask task = new HumanTask();
        Object sss = writeMethod.invoke(task, "sss");
        System.out.println(JSON.toJSONString(task));

    }
}
