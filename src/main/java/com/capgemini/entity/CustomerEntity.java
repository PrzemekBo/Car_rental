package com.capgemini.entity;

import com.sun.istack.internal.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
public class CustomerEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;


    @Column(length = 30)
    private String firstName;

    @Column(length = 35)
    private String lastName;

    @Column(length = 40)
    @NotNull
    private String home;


    @Column(length = 24)
    private String creditCardNumber;

    @NotNull
    private Date birthDate;

    @OneToMany
    private List<RentEntity> rent;


    public void setId(Long id) {
        this.id = id;
    }

}
