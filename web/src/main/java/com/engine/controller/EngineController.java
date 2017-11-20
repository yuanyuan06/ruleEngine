package com.engine.controller;


import com.engine.vo.EngineResultVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/applyEngine/")
public class EngineController {

    @ResponseBody
    @RequestMapping("apply")
    public ModelAndView assignEngine(){
        EngineResultVo vo = new EngineResultVo();
        Map<String, Object> map = new HashMap<>();
        map.put("feedback", vo);
        vo.setCreateTime(new Date());
        return new ModelAndView("index", map);
    }
}
