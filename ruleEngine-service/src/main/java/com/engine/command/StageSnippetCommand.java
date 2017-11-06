package com.engine.command;

import com.engine.entity.ruleEngine.StageSnippetRel;

import java.io.Serializable;
import java.util.List;

public class StageSnippetCommand implements Serializable {

    private static final long serialVersionUID = -7776176268788192349L;


    /**
     * stage编码
     */
    private String stageNum;
    /**
     * 规则片段编码
     */
    private List<String> snippetNums;

    public String getStageNum() {
        return stageNum;
    }

    public void setStageNum(String stageNum) {
        this.stageNum = stageNum;
    }

    public List<String> getSnippetNums() {
        return snippetNums;
    }

    public void setSnippetNums(List<String> snippetNums) {
        this.snippetNums = snippetNums;
    }
}
