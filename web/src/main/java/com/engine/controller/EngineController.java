package com.engine.controller;


import com.engine.vo.EngineResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.*;

@Controller
@RequestMapping("/engine/")
public class EngineController {



    @ResponseBody
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }

    @ResponseBody
    @RequestMapping("apply")
    public ModelAndView enginePage(){
        EngineResultVo vo = new EngineResultVo();
        Map<String, Object> map = new HashMap<>();
        map.put("feedback", vo);
        vo.setCreateTime(new Date());

        List<String> snippets = new ArrayList<>();
        snippets.add("uu");
        map.put("snippets", snippets);

        List<String> stages = new ArrayList<>();
        stages.add("kk");
        map.put("stages", stages);

        return new ModelAndView("engineApply", map);
    }

    @ResponseBody
    @RequestMapping("action")
    public ModelAndView actionPage(){

        return new ModelAndView("actionSetUp");
    }

    @ResponseBody
    @RequestMapping("stage")
    public ModelAndView stagePage(){

        return new ModelAndView("stageSetUp");
    }


    @ResponseBody
    @RequestMapping("snippet")
    public ModelAndView snippetPage(){

        return new ModelAndView("snippetSetUp");
    }

    @ResponseBody
    @RequestMapping("readme")
    public ModelAndView readMePage(){

        return new ModelAndView("readme");
    }




}
