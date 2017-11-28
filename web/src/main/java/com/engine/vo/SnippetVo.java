package com.engine.vo;

import java.io.Serializable;

public class SnippetVo implements Serializable {

    private static final long serialVersionUID = -2306802062973386935L;

    private String docNum;

    private String groovyScript;

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getGroovyScript() {
        return groovyScript;
    }

    public void setGroovyScript(String groovyScript) {
        this.groovyScript = groovyScript;
    }
}
