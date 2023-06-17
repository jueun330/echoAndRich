package com.example.demo.employee;

import com.example.demo.department.DepartmentRepository;
import com.example.demo.department.Departments;
import com.example.demo.employee.dto.EmployeeResponseDto;
import com.example.demo.employee.history.EmployeeHistory;
import com.example.demo.employee.history.EmployeeHistoryRepository;
import com.example.demo.job.JobRepository;
import com.example.demo.job.Jobs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final JobRepository jobRepository;
    private final EmployeeHistoryRepository historyRepository;

    // 직원의 현재 정보 구하기
    public ResponseEntity<EmployeeResponseDto> getEmployeeInfo(Integer employeeId) {
        Employees employees = employeeRepository.findByEmployeeId(employeeId).get();

        Map<String, String> info = getDepartmentAndLocation(employeeId);

        // DTO로 리턴
        EmployeeResponseDto responseDto = EmployeeResponseDto.builder()
                .firstName(employees.getFirstName())
                .lastName(employees.getLastName())
                .email(employees.getEmail())
                .phoneNumber(employees.getPhoneNumber())
                .hireDate(employees.getHireDate())
                .department(info.get("부서"))
                .job(info.get("직업"))
                .salary(employees.getSalary())
                .managerId(employees.getManagerId())
                .build();

        return ResponseEntity.ok(responseDto);
    }

    // 직원의 이력 구하기
    public ResponseEntity<?> getEmployeeHistory(Integer employeeId) {
        EmployeeHistory employeeHistory = historyRepository.findByEmployeeId(employeeId).get();

        if (employeeHistory == null) {
            return ResponseEntity.ok("해당 직원의 변경 내역이 없습니다.");
        } else {
            String jobId = employeeHistory.getJobId();
            String job = jobRepository.findByJobId(jobId).get().getJobTitle();

            Integer departmentId = employeeHistory.getDepartmentId();
            String department = departmentRepository.findByDepartmentId(departmentId).get().getDepartmentName();

            EmployeeResponseDto responseDto = EmployeeResponseDto.builder()
                    .jobHistory(job)
                    .department(department)
                    .startDate(employeeHistory.getStartDate())
                    .endDate(employeeHistory.getEndDate())
                    .build();

            return ResponseEntity.ok(responseDto);
        }
    }
    // 부서 정보와 직업 이름 구하기
    public Map<String, String> getDepartmentAndLocation(Integer employeeId) {
        Map<String, String> infoList = new HashMap<>();

        Employees employees = employeeRepository.findByEmployeeId(employeeId).get();
        if (employees == null) {
            return null;
        } else {

            Integer departmentId = employees.getDepartmentId();
            String jobId = employees.getJobId();

            Departments department = departmentRepository.findByDepartmentId(departmentId).get();
            Jobs job = jobRepository.findByJobId(jobId).get();
            infoList.put("부서", department.getDepartmentName());
            infoList.put("직업", job.getJobTitle());

            return infoList;
        }
    }
}
