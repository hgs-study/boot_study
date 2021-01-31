package com.hgstudy.boot_study.repository;

import com.hgstudy.boot_study.domain.entity.Memo;
import com.hgstudy.boot_study.domain.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {

    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){
        System.out.printf(memoRepository.getClass().getName());
    }

    @Test
    @DisplayName("더미 데이터 생성 테스트")
    public void testInsertDummies(){
        IntStream.rangeClosed(1,100).forEach(i ->{
            Memo memo = Memo.builder().memoText("Sample.."+i).build();
            memoRepository.save(memo);
        });

        IntStream.rangeClosed(1,5).forEach(System.out::println);

    }
}
