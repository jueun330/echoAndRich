package com.example.demo.employee.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Integer> {

    JobHistory findByEmployeeId(Integer integer);
}
