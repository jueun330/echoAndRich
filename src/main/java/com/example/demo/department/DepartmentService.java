package com.example.demo.department;

import com.example.demo.employee.EmployeeRepository;
import com.example.demo.employee.Employees;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    // 특정 부서의 급여 인상
    public ResponseEntity<?> updateSalary (SalaryRequestDto requestDto){

        Integer department = requestDto.getDepartment();
        List<Employees> employees = employeeRepository.findByDepartmentId(department);
        String departmentName = departmentRepository.findByDepartmentId(department).getDepartmentName();

        // 인상률 구하기
        double percent = requestDto.getPercent() * 0.01 + 1;

        // 해당 부서의 모든 직원들 급여 인상
        for(Employees employee : employees) {
            employee.updateSalary(percent);
            employeeRepository.save(employee);
        }

        return ResponseEntity.ok(departmentName + " 부서 직원들 급여 인상 완료");
    }

}
