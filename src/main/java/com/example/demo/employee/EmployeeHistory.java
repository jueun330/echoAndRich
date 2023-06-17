package com.example.demo.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class EmployeeHistory {

    @Id
    private Integer employeeId;
    @Column
    private Date startDate;
    @Column
    private Date endDate;

}
