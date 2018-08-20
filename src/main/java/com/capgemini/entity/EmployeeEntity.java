package com.capgemini.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "employees")
public class EmployeeEntity extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 35, nullable = false)
    private String lastName;

    @NotNull
    private Date birthDate;


    @Column(nullable = false)
    private String profession;


    @ManyToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private DepartmentEntity departmentId;


    @ManyToMany
    private List<CarEntity> cars;


}
