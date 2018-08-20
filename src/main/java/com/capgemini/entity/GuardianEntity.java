package com.capgemini.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Data
@Table(name = "guardians")
public class GuardianEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    private EmployeeEntity employeeId;

    @ManyToOne
    private CarEntity carId;
}
