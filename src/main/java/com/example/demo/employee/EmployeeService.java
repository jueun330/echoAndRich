package com.example.demo.employee;

import com.example.demo.department.Departments;
import com.example.demo.department.DepartmentRepository;
import com.example.demo.employee.dto.EmployeeResponseDto;
import com.example.demo.job.Jobs;
import com.example.demo.job.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final JobRepository jobRepository;

    // 직원의 현재 정보 구하기
    public ResponseEntity<EmployeeResponseDto> getEmployeeInfo (Integer employeeId){
        Employees employees = employeeRepository.findByEmployeeId(employeeId).get();
        if(employees == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {

            // 부서 정보와 직업 이름 구하기
            Integer departmentId = employees.getDepartmentId();
            String jobId = employees.getJobId();

            Departments departments = departmentRepository.findByDepartmentId(departmentId).get();
            Jobs jobs = jobRepository.findByJobId(jobId).get();

            // DTO로 리턴
            EmployeeResponseDto responseDto = EmployeeResponseDto.builder()
                    .firstName(employees.getFirstName())
                    .lastName(employees.getLastName())
                    .email(employees.getEmail())
                    .phoneNumber(employees.getPhoneNumber())
                    .hireDate(employees.getHireDate())
                    .department(departments.getDepartmentName())
                    .job(jobs.getJobTitle())
                    .salary(employees.getSalary())
                    .managerId(employees.getManagerId())
                    .build();

            return ResponseEntity.ok(responseDto);
        }

    }

    // 직원의 이력 구하기
    public ResponseEntity<EmployeeResponseDto> getEmployeeHistory (Integer employeeId){
        Employees employees = employeeRepository.findByEmployeeId(employeeId).get();
        if(employees == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }else {
            EmployeeResponseDto responseDto = EmployeeResponseDto.builder()
                    .firstName(employees.getFirstName())
                    .lastName(employees.getLastName())
                    .jobHistory()
                    .build();
            return ResponseEntity.ok(responseDto);
        }
    }

}
