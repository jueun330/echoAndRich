package com.example.demo.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private Date hireDate;

    private String job;

    private double salary;

    private double commissionPct;

    private int managerId;

    private String department;

    private String jobHistory;

    private Date startDate;

    private Date endDate;
}
