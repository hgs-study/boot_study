package com.hgstudy.boot_study.api;

import com.hgstudy.boot_study.exception.messageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiController {

    @GetMapping(value = "/test")
    public String hello(){
        return "hello";
    }

    @GetMapping(value="/jsonTest")
    public String[] helloArr(){
        return new String[]{"Hello","hi"};
    }


    @GetMapping(value = "/exceptionTest")
    public ResponseEntity<?> exceptionTest(){
        String test = "test";
        if("test".equals(test))
            throw new IllegalArgumentException("에러발생!!!!!!!");
        return ResponseEntity.status(HttpStatus.OK).body(messageDTO.builder().message("message ok").build());
    };
}

