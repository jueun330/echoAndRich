package com.example.demo.department;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/salary")
public class DepartmentController {

    private final DepartmentService departmentService;

    // 특정 부서의 급여 인상
    @PutMapping(value = "/update")
    public ResponseEntity<?>  updateSalary(@RequestBody SalaryRequestDto requestDto){
        return departmentService.updateSalary(requestDto);
    }
}
