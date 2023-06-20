package com.example.demo.department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaryRequestDto {

    //부서 아이디
    private Integer department;

    //급여 인상률
    private Integer percent;
}
