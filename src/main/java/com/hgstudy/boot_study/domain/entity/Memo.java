package com.hgstudy.boot_study.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@Table(name="tbl_memo")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(length = 200,nullable = false)
    private String memoText;

}
