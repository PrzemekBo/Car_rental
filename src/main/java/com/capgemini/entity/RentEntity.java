package com.capgemini.entity;


import com.sun.istack.internal.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "rent")
public class RentEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private LocalDate rentDate;
    private LocalDate returnDate;
    private float cost;

    @ManyToOne
    @JoinColumn(name = "id_department_rental")
    private DepartmentEntity placeOfRental;

    @ManyToOne
    @JoinColumn(name = "id_department_delivery")
    private DepartmentEntity placeOfDelivery;

    @ManyToOne
    @JoinColumn(name = "id_car")
    private CarEntity carEntity;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private CustomerEntity customerEntity;
}
