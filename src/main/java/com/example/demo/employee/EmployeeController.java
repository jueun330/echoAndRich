package com.example.demo.employee;

import com.example.demo.employee.dto.EmployeeResponseDto;
import com.example.demo.employee.history.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    private final JobHistoryRepository jobHistoryRepository;

    // 직원의 현재 정보 구하기
    @GetMapping(value = "/info")
    public ResponseEntity<EmployeeResponseDto> getInfo(@RequestParam Integer employeeId) {
        return employeeService.getEmployeeInfo(employeeId);
    }

    // 직원의 이력 구하기
    @GetMapping(value = "/history")
    public ResponseEntity<?> getHistory(@RequestParam Integer employeeId) {
        return employeeService.getEmployeeHistory(employeeId);
    }



}
