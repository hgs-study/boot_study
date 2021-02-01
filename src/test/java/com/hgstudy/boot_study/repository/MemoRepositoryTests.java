package com.hgstudy.boot_study.repository;

import com.hgstudy.boot_study.domain.entity.Memo;
import com.hgstudy.boot_study.domain.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;
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

    @Test
    public void testSelect(){
        //데이터 베이스에 존재하는 mno
        Long mno = 100L;

        Optional<Memo> result  = memoRepository.findById(mno);
        System.out.printf("===============");

        if(result.isPresent()){
            Memo memo = result.get();
            System.out.printf("memo="+memo);
        }

        String str = null;
        String optStr = Optional.ofNullable(str).orElseThrow(() -> new IllegalArgumentException("에러입니다."));

//        String result2 = Optional.ofNullable(str).orElseThrow(() -> new IllegalArgumentException("dd"));

    }

    @Transactional
    @Test
    public void testSelect2(){
        Long mno = 100L;

        Memo memo = memoRepository.getOne(mno);

        System.out.println("===================");
        System.out.println(memo);
    }

    //save는 미리 객체가 있는지 select 해보고 있으면 update / 없으면 insert 함
    @Test
    public void testUpdate(){
        Memo memo = Memo.builder().mno(100L).memoText("Update Text").build();

        System.out.println(memoRepository.save(memo));
    }

    //org.springframework.dao.EmptyResultDataAccessException 실패시
    @Test
    public void testDelete(){
        Long mno = 100L;

        memoRepository.deleteById(mno);
        
    }
}
