package com.example.demo.job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRepository extends JpaRepository<Jobs, String> {

    Optional<Jobs> findByJobId(String jobId);
}
