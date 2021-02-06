package com.hgstudy.boot_study.domain.repository;

import com.hgstudy.boot_study.domain.entity.Memo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo,Long> {
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);

    Page<Memo> findByMnoBetween(Long from, Long to, Pageable page);

    List<Memo> findByOrderByMnoDesc();
    
    void deleteMemoByMnoLessThan(Long num); //파라미터 보다 작은 mno의 데이터 삭제

    @Query("select m from Memo m order by m.mno desc")
    List<Memo> getQueryList();

}

