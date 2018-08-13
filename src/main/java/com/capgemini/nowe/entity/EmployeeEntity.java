package com.capgemini.nowe.entity;


import com.capgemini.nowe.enums.Profession;
import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employee")
public class EmployeeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 30, nullable = false)
    private String firstName;
    @Column(length = 35, nullable = false)
    private String lastName;

    @NotNull
    private LocalDate birthDate;


    @Enumerated(EnumType.STRING)
    @NotNull
    private Profession profession;


    @ManyToOne
    @JoinColumn(name = "id_department")
    private DepartmentEntity departmentEntity;




}
