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

    //부서 명
    private int department;
    //급여 인상률
    private int percent;
}
