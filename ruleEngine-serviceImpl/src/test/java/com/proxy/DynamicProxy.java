package com.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy {

    @Test
    public void testJdkProxy() throws Throwable {
        JdkProxyTest test = new JdkProxyTest();
        Hello hello = new Hello();
        Method sayHello = hello.getClass().getMethod("sayHello", null);
        Object invoke = test.invoke(hello, sayHello, new Object[]{});
        System.out.println(invoke);
    }

    @Test
    public void testSpringProxy() throws Throwable {
        SpringProxyTest test = new SpringProxyTest();
        Hello hello = new Hello();
        Method sayHello = hello.getClass().getMethod("sayHello", null);
        Object invoke = test.invoke(hello, sayHello, new Object[]{});
        System.out.println(invoke);
    }
}


class JdkProxyTest implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("start");
        method.invoke(proxy,args);
        System.out.println("out");
        return "proxy";
    }
}

class Hello{

    public void sayHello(){
        System.out.println("hello");
    }
}

class SpringProxyTest implements org.springframework.cglib.proxy.InvocationHandler{

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("start");
        method.invoke(o,objects);
        System.out.println("out");
        return "proxy";
    }
}