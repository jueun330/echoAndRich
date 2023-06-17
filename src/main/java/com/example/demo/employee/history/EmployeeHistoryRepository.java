package com.example.demo.employee.history;

import com.example.demo.employee.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeHistoryRepository extends JpaRepository<EmployeeHistory, Integer> {

    Optional<EmployeeHistory> findByEmployeeId(Integer integer);
}
