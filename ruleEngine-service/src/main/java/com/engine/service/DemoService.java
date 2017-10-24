package com.engine.service;

import javax.script.ScriptException;

public interface DemoService {

    void demoMethod();

    void invokeDemoDao();

    void invokeDemoMybatis();

    void testScriptSaveData() throws ScriptException, NoSuchMethodException;

}
