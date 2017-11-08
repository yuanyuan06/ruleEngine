package com.engine.service.execAction;

import com.esotericsoftware.reflectasm.MethodAccess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Cache;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ActionCache {

    protected static Logger logger = LoggerFactory.getLogger(ActionCache.class);

    private static Map<String, MethodAccess> cache;

    public static List<ActionEntity> entities = new ArrayList<>();


    public static MethodAccess getCache(String clazz){
        MethodAccess methodAccess = cache.get(clazz);
        try {
            if(methodAccess == null){
                Class<?> aClass = Class.forName(clazz);
                MethodAccess nonMethod = MethodAccess.get(aClass);
                cache.put(clazz, nonMethod);

            }
        } catch (ClassNotFoundException e) {
            logger.error("action arg illegal", e);
        }
        return methodAccess;
    }


    public static void addAction(ActionEntity entity){
        entities.add(entity);
    }


    public static ActionEntity newAction(){
        return new ActionEntity();
    }

    public static class ActionEntity {

        private String clazz;

        private String method;

        private Object[] args;


        public String getClazz() {
            return clazz;
        }

        public void setClazz(String clazz) {
            this.clazz = clazz;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public Object[] getArgs() {
            return args;
        }

        public void setArgs(Object[] args) {
            this.args = args;
        }
    }
}