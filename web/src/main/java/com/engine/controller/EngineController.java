package com.engine.controller;


import com.engine.vo.EngineResultVo;
import com.engine.vo.SnippetVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.*;

@Controller
@RequestMapping("/engine/")
public class EngineController {



    @ResponseBody
    @RequestMapping("index")
    public ModelAndView index(){

        Menu menu = new Menu();
        menu.setUrl("/engine/readme.htm");
        menu.setValue("hello world");

        Menu menu1 = new Menu();
        menu1.setUrl("/engine/snippet.htm");
        menu1.setValue("编写规则片段");

        Menu menu2 = new Menu();
        menu2.setUrl("/engine/stage.htm");
        menu2.setValue("设置stage");

        Menu menu3 = new Menu();
        menu3.setUrl("/engine/action.htm");
        menu3.setValue("配置action");

        Menu menu4 = new Menu();
        menu4.setUrl("/engine/apply.htm");
        menu4.setValue("应用规则");

        List<Menu> list = new ArrayList<>();
            list.add(menu);
            list.add(menu1);
            list.add(menu2);
            list.add(menu3);
            list.add(menu4);
            Map<String, Object> map = new HashMap<>();
        map.put("menus", list);

        return new ModelAndView("index", map);
    }

    class Menu implements Serializable{
        private static final long serialVersionUID = 2208112916395973913L;

        private String value;
        private String url;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
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

    @RequestMapping("saveScript")
    @ResponseBody
    public Map<String, Object> saveScript(SnippetVo snippetVo){

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("resultCode", "001");
        result.put("msg", "");
        return result;

    }




}
