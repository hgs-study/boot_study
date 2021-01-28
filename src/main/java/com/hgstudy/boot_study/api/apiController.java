package com.hgstudy.boot_study.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiController {

    @GetMapping(value = "/test")
    public String hello(){
        return "hello";
    }
}

