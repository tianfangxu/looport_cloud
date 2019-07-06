package com.looport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("index")
    @ResponseBody
    public String index(){
        System.out.println("index");
        return "index";
    }
}
