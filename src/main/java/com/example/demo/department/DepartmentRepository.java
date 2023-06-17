package com.example.demo.department;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Departments, Integer> {

    Optional<Departments> findByDepartmentId(Integer departmentId);
}