package com.example.demo.department;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"급여 인상 api"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/salary")
public class DepartmentController {

    private final DepartmentService departmentService;

    @ApiOperation(value = "특정 부서의 급여 인상")
    @ApiImplicitParam(name = "requestDto", value = "부서 아이디와 급여 인상률", required = true, dataTypeClass = SalaryRequestDto.class)
    @PutMapping(value = "/update")
    public ResponseEntity<?>  updateSalary(@RequestBody SalaryRequestDto requestDto){
        return departmentService.updateSalary(requestDto);
    }
}
