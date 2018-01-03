package com.concurrent;

import org.junit.Test;
import sun.misc.Unsafe;
import sun.reflect.Reflection;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

public class TestLock {


    private AtomicLong atomicLong = new AtomicLong();


    @Test
    public void testCAS(){
        atomicLong.compareAndSet(0, 2);
        System.out.println(atomicLong);
    }

    /**
     * jvm 层会做安全校验
     * 无法直接获取 unsafe
     */
    @Test
    public void testUnsafe(){
        int i = 0;
        //  通过这样的方式获得Unsafe的实力会抛出异常信息，因为在unsafe的源码中会有对安全性的检查
        Unsafe unsafe = Unsafe.getUnsafe();
        boolean b = unsafe.compareAndSwapInt(i, 1, 0, 2);
        System.out.println(i);
    }


    private volatile Integer i = 0;
    /**
     * 因已该类已包含一个unsafe 的实例
     * 可以通过 反射获取 unsafe
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void testGetUnsafe() throws NoSuchFieldException, IllegalAccessException {

        Field theUnsafeInstance = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafeInstance.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafeInstance.get(Unsafe.class);
        long valueOffset = unsafe.objectFieldOffset(AtomicLong.class.getDeclaredField("value"));
        boolean b = unsafe.compareAndSwapInt(i, valueOffset, 0, 2);
        System.out.println(b + " " + i);
    }

    @Test
    public void test(){
        TestReflection testReflection = new TestReflection();
        testReflection.reflection();
    }

    @Test
    public void testGetCaller(){
        TestReflection testReflection = new TestReflection();
        testReflection.getCaller();
    }
}

class TestReflection{

    public void reflection(){
        System.out.println(Reflection.getCallerClass());
    }

    public void getCaller(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i = 0;
        for (StackTraceElement stack: stackTrace) {
            System.out.println(i++ + " " + stack.getFileName() + " " + stack.getClassName() + " " + stack.getMethodName() + " " + stack.getLineNumber());
        }
        String className = stackTrace[2].getClassName();
        String methodName = stackTrace[2].getMethodName();
        int lineNumber = stackTrace[2].getLineNumber();
        System.out.println(className + " " + methodName + " " + lineNumber);
    }
}
