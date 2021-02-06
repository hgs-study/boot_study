package com.hgstudy.boot_study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

@SpringBootTest
class BootStudyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @DisplayName("Stream 테스트")
    public void streamTest(){
        ArrayList<Integer> list =new ArrayList<>(Arrays.asList(1,2,3,4));
        Stream<Integer> stream = list.stream();
        stream.forEach(num-> System.out.println("num :"+num));

        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList("현","건","수","하","아"));
        Stream<String> strStream = arrayList.stream();
        strStream.forEach(str -> System.out.println("str : "+str));
    }

}
