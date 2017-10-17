package com.engine;

import com.engine.entity.Rule;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.*;

public class TestExecGroovyShell {

    private ScriptEngine groovy;
    private ResourcePatternResolver resolver;


    @Before
    public void initEngine(){
        ScriptEngineManager engineManager = new ScriptEngineManager();
        groovy = engineManager.getEngineByName("groovy");

        resolver = new PathMatchingResourcePatternResolver();
    }

    private String getScriptFromSource(Resource resource) throws IOException {
        InputStream inputStream = resource.getInputStream();
        Reader reader = new InputStreamReader(inputStream);
        BufferedReader bf = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String scriptString = null;
        while( (scriptString = bf.readLine()) != null){
            System.out.println(scriptString);
            sb.append(scriptString);
        }
        return sb.toString();
    }

    @Test
    public void execShell() throws  Exception{

        Resource resource = resolver.getResource("classpath:groovy/demoHello.groovy");
//        groovy.eval("def sayHelo(def order) {println \"hello world\" + order.docNum} ");
        groovy.eval(getScriptFromSource(resource));
        Rule rule = new Rule();
        rule.setDocNum("code");
        ((Invocable)groovy).invokeFunction("sayHelo", rule);



        Resource resource1 = resolver.getResource("classpath:groovy//demoHaHa.groovy");
//        groovy.eval("def sayHelo(def order) {println \"hello world\" + order.docNum} ");
        groovy.eval(getScriptFromSource(resource1));
        Rule entity1 = new Rule();
        entity1.setDocNum("code");
        ((Invocable) ((Invocable)groovy)).invokeFunction("sayHaHa", entity1);

        System.out.println("end");
    }

}
