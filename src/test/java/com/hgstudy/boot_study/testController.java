package com.hgstudy.boot_study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class testController {

    @Test
    @DisplayName("테스트_실행된다")
    public void start(){
        System.out.printf("hello");
    }
}
