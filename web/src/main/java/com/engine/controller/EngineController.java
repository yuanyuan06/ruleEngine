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
    public ModelAndView assignEngine(){
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

        return new ModelAndView("engine", map);
    }
}
