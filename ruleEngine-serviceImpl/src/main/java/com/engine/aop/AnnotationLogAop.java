package com.engine.aop;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


@Aspect
@Order(0)
public class AnnotationLogAop implements Ordered {


    private Logger logger = LoggerFactory.getLogger(this.getClass());


    static ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();
    static StopWatch stopWatch = new StopWatch();
    static {
        stopWatchThreadLocal.set(stopWatch);
    }


    @Around("@annotation(com.engine.annotations.LogAnnotation)")
    void record(ProceedingJoinPoint pjp){

        StopWatch watch = stopWatchThreadLocal.get();
        logger.info("method start with time {}, class {}, method {}", System.currentTimeMillis(), pjp.getSignature().getDeclaringTypeName() , pjp.getSignature().getName());
        try {



            watch.start("record enter the reference");

            Object[] args = pjp.getArgs();

            logger.info(JSON.toJSONString(args));

            watch.stop();

            watch.start("invoke target method");


            Object proceed = pjp.proceed();


            watch.stop();


            watch.start("record result");

            watch.stop();


            String s = watch.prettyPrint();

            if(logger.isInfoEnabled()){
                logger.info(s);
            }
        }catch (Throwable t){
            logger.error("log info record happened error, stack see -->", t);
        }


    }


    @Override
    public int getOrder() {
        return 0;
    }
}
