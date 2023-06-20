package com.example.demo.department;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {

    Departments findByDepartmentId(Integer departmentId);
}
