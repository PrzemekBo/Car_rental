package com.capgemini.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profession", nullable = false)
    private ProfessionEntity profession;


    @ManyToMany
    @JoinColumn(name = "id_department")
    private List<DepartmentEntity> departmentEntity;


    @ManyToMany
    @JoinTable(name = "supported_car",
            joinColumns = { @JoinColumn(name = "id_employee") },
            inverseJoinColumns = {@JoinColumn(name = "id_car") })
    private List<CarEntity> supportedCar;







}