package com.example.demo.job;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Jobs {
    @Id
    private String jobId;
    @Column
    private String jobTitle;
    @Column
    private double minSalary;
    @Column
    private double maxSalary;
}
