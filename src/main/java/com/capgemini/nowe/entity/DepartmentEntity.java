package com.capgemini.nowe.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "department")
public class DepartmentEntity {


    @Column(length = 65)
    private String address;

    @Column(length = 12)

    private String phoneNumber;



}
