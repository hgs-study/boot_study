package com.hgstudy.boot_study.domain.repository;

import com.hgstudy.boot_study.domain.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository extends JpaRepository<Memo,Long> {
}
