package com.capgemini.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.Year;
import java.util.List;


@Entity
@Table(name = "car")
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
    private Integer productionYear;

    @Column(length = 20)
    @NotNull
    private String color;

    @NotNull
    private int engineCapacity;

    @NotNull
    private int power;

    @NotNull
    private int mileage;


/*
    @ManyToMany(mappedBy = "supportedCar", cascade = CascadeType.MERGE)
    private List<EmployeeEntity> guardianEmployees;
*/

}
