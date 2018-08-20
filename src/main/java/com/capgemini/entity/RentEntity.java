package com.capgemini.entity;


import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "rent")
public class RentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;



    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customerId;


    @ManyToOne
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private CarEntity carId;

    @NotNull
    private Date rentDate;
    private Date returnDate;
    private float cost;



    @ManyToOne
    private DepartmentEntity startDepartmentId;

    @ManyToOne
    private DepartmentEntity endDepartmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /*    @ManyToOne
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
    private CustomerEntity customerEntity;*/
}
