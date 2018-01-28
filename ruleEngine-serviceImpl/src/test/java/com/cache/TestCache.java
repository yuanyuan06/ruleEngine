package com.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * @author yuan.yuan1
 * @date 2017/12/13 12:33
 */
public class TestCache {

    @Test
    public void testCache() throws ExecutionException {
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .build(
                        new CacheLoader<String, Object>() {
                            @Override
                            public Object load(String key) throws Exception {
                                return null;
                            }


                        }
                );

        cache.put("test", "testValue");
        Object test = cache.get("test");
        System.out.println(test);

    }

    @Test
    public void testca(){
        Cache<Object, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .build();
    }
}
