package com.capgemini.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.Year;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


@Entity
@Table(name = "cars")
@Data
public class CarEntity extends AbstractEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 40)
    @NotNull
    private String type;

    @Column(length = 40)
    @NotNull
    private String mark;

    @NotNull
    private Year productionYear;

    @Column(length = 20)
    @NotNull
    private String color;

    @NotNull
    private Integer engineCapacity;

    @NotNull
    private Integer power;

    @NotNull
    private Integer mileage;

    @OneToMany(mappedBy = "carEntity", cascade = CascadeType.REMOVE)
    private List<RentEntity> rents;



/*
    @ManyToMany(mappedBy = "supportedCar", cascade = CascadeType.MERGE)
    private List<EmployeeEntity> guardianEmployees;
*/

}
