package com.engine;

import org.junit.Test;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.util.List;

public class JavaScriptEngine {

    @Test
    public void testEngineManager(){
        ScriptEngineManager manager = new ScriptEngineManager();
        List<ScriptEngineFactory> engineFactories = manager.getEngineFactories();
        for(ScriptEngineFactory engineFactory: engineFactories){
            System.out.println(engineFactory.getEngineName());
        }
    }



}
