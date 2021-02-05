package com.hgstudy.boot_study.domain.repository;

import com.hgstudy.boot_study.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemoRepository extends JpaRepository<Memo,Long> {
    List<Memo> findByMnoBetweenOrderByMnoDesc(Long from, Long to);
}

