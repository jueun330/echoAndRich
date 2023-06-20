package com.example.demo.employee;

import com.example.demo.employee.dto.EmployeeResponseDto;
import com.example.demo.employee.history.JobHistoryRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Api(tags = {"직원 정보 확인 api"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final EmployeeService employeeService;
    private final JobHistoryRepository jobHistoryRepository;
    @ApiOperation(value = "직원의 현재 정보 구하기")
    @ApiImplicitParam(name = "employeeId", value = "직원의 아이디", dataType = "Integer")
    @GetMapping(value = "/info")
    public ResponseEntity<EmployeeResponseDto> getInfo(@RequestParam Integer employeeId) {
        return employeeService.getEmployeeInfo(employeeId);
    }

    @ApiOperation(value = "직원의 이력 구하기")
    @ApiImplicitParam(name = "employeeId", value = "직원의 아이디", dataType = "Integer")
    @GetMapping(value = "/history")
    public ResponseEntity<?> getHistory(@RequestParam Integer employeeId) {
        return employeeService.getEmployeeHistory(employeeId);
    }
}
