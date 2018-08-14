package com.capgemini.entity;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "customer")
public class CustomerEntity {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(length = 30, nullable = false)
    private String firstName;

    @Column(length = 35, nullable = false)
    private String lastName;

    @Column(length = 40, nullable = false)
    @NotNull
    private String home;

    @NotNull
    private LocalDate birthDate;

}
