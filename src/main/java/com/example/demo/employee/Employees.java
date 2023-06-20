package com.example.demo.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
public class Employees {

    @Id
    private Integer employeeId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private Date hireDate;
    @Column
    private String jobId;
    @Column
    private Double salary;
    @Column
    private Double commissionPct;
    @Column
    private Integer managerId;
    @Column
    private Integer departmentId;

    public void updateSalary(double percent){
        this.salary = salary * percent;
    }

}
