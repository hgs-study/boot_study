package com.hgstudy.boot_study.repository;

import com.hgstudy.boot_study.domain.entity.Memo;
import com.hgstudy.boot_study.domain.repository.MemoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
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


    @Test
    public void testPageDefault(){
        Pageable pageable = PageRequest.of(0,10);
        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println("pageable : "+pageable);
        System.out.println("result : "+result);

        System.out.println("---------------------------");
        System.out.println("Total pages : "+result.getTotalPages()); // 총 페이지
        System.out.println("Total count : "+result.getTotalElements()); // 전체 개수
        System.out.println("Page Number :"+ result.getNumber()); //현재 페이지 번호 0부터 시작
        System.out.println("Page size : "+result.getSize()); //페이지당 데이터 개수
        System.out.println("has next page? :"+result.hasNext()); //다음 페이지 존재 여부
        System.out.println("first page ? : "+result.isFirst()); //시작 페이지(0) 여부

        System.out.println("---------------------------");
        for(Memo memo : result.getContent()) //현재 페이지의 데이터
            System.out.println(memo);
    }

    @Test
    @DisplayName("sort 테스트")
    public void testSort(){
        Sort sort = Sort.by("mno").descending();
        Pageable page = PageRequest.of(0,10,sort);

        Page<Memo> result = memoRepository.findAll(page);

        for(Memo memo : result){
            System.out.println("memo :"+memo);
        }
    }

    @Test
    @DisplayName("SortAnd 테스트")
    public void SortAnd(){
        Sort sortTest01 = Sort.by("mno").descending();
        Sort sortTest02 = Sort.by("memoText").ascending();
        Sort sortAll = sortTest01.and(sortTest02);

        Pageable page = PageRequest.of(0,10,sortAll);

        Page<Memo> memo = memoRepository.findAll(page);
        List<Memo> memos = memoRepository.findAll(sortAll); //리스트

        for(Memo memoList : memo)
            System.out.println("memoList :"+memoList);
    }

    @Test
    @DisplayName("쿼리 메소드 테스트")
    public void testQueryMethod(){
        List<Memo> memo = memoRepository.findByMnoBetweenOrderByMnoDesc(70L,80L);

        for(Memo memo1 : memo){
            System.out.println("findByMnoBetweenOrderByMnoDesc 테스트 :"+ memo1);
        }
    }

    @Test
    @DisplayName("정렬 간소화")
    public void sortPageTest(){
        Pageable pageable = PageRequest.of(0,10,Sort.by("mno").descending());

        Page<Memo> memo = memoRepository.findByMnoBetween(10L,60L, pageable);
        for (Memo memoTest : memo)
            System.out.println("memoTest : "+memoTest);
    }

    @Test
    @DisplayName("Mno desc 정렬 테스트")
    public void testDesc(){
        List<Memo> memo = memoRepository.findByOrderByMnoDesc();
        for(Memo memo1 : memo)
            System.out.println("memo : "+memo1);
    }

    @Test
    @Transactional
    //@Commit
    @DisplayName("10번 보다 작은 데이터 삭제")
    public void deleteTest(){
        memoRepository.deleteMemoByMnoLessThan(10L); //deleteBy 실무에서 잘 사용 x, delete문을 하나씩 수행
        List<Memo> memo = memoRepository.findAll();

        for(Memo memoList : memo)
            System.out.println("memoList :"+memoList); //=>10 11 12 ...99번
    }

    @Test
    @DisplayName("@Query 텟트")
    public void queryTest(){
        List<Memo> memo = memoRepository.getQueryList();
        for (Memo memoUnit : memo)
            System.out.println("memos :"+memoUnit);
    }

}
