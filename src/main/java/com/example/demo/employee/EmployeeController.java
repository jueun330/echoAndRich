package com.example.demo.employee;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hr")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
}
