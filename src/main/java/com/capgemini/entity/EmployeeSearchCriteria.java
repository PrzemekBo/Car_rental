package com.capgemini.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeSearchCriteria {
    private Long departmentEntity;
    private Long carEntity;
    private String profession;
}