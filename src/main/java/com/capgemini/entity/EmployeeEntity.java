package com.capgemini.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "employee")
public class EmployeeEntity extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 35, nullable = false)
    private String lastName;

    @NotNull
    private LocalDate birthDate;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profession", nullable = false)
    private ProfessionEntity profession;




    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "supervisor",
            joinColumns = { @JoinColumn(name = "employee", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "car", nullable = false, updatable = false)})
    private Set<CarEntity> cars=new HashSet<>();







}
