package com.capgemini.entity;


import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "profession")
public class ProfessionEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;



    @Column(length = 45)
    @NotNull
    private String professionName;

/*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "profession")
    private Set<EmployeeEntity> employee = new HashSet<>();*/
}
