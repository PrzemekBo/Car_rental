package com.capgemini.entity;


import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "department")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@EntityListeners({Listener.class})
public class DepartmentEntity extends AbstractEntity  {


    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 80)
    private String address;

    @Column(length = 12)
    @NotNull
    private String phoneNumber;


/*
    @OneToMany(mappedBy = "departmentEntity")
    private List<EmployeeEntity> employes;

*/



}
