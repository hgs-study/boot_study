package com.hgstudy.boot_study.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder(toBuilder = true)
public class SampleDTO {
    private Long sno;

    private String first;

    private String last;

    private LocalDateTime regTime;
}
