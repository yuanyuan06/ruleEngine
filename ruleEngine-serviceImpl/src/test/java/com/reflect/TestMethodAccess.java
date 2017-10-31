package com.reflect;

import com.engine.service.execAction.ActionInvokeService;
import com.engine.service.execAction.ActionInvokeServiceImpl;
import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import org.junit.Test;
import sun.reflect.MethodAccessor;

import java.lang.reflect.Method;

public class TestMethodAccess {

    @Test
    public void testInvoke(){
        MethodAccess methodAccess = MethodAccess.get(ActionInvokeService.class);
        ConstructorAccess constructorAccess = ConstructorAccess.get(ActionInvokeServiceImpl.class);
        Object o = constructorAccess.newInstance();
        methodAccess.invoke(o, "invoke", null);
    }
}
