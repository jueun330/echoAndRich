package com.example.demo.department;

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
public class Departments {
    @Id
    private Integer departmentId;
    @Column
    private String departmentName;
    @Column
    private int managerId;
    @Column
    private int locationId;
}
