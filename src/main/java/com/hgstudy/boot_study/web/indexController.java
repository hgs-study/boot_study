package com.hgstudy.boot_study.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {

    @GetMapping(value = "/index")
    public String index(){
        return "/index";
    }

    @GetMapping(value = "/index02")
    public String index02(){
        return "/index02";
    }

    @GetMapping(value = "/index03")
    public String index03(){
        return "/index03";
    }

    @GetMapping(value = "/exceptionTestPage")
    public String exceptionTestPage(){
        return "exception/exceptionTest";
    }

}
