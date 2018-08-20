package com.capgemini.dto;

import com.capgemini.entity.CarEntity;
import com.capgemini.entity.CustomerEntity;
import com.capgemini.entity.DepartmentEntity;
import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RentDTO {

    private Long id;
    private Long customerId;
    private Long carId;
    private Date rentDate;
    private Date returnDate;
    private float cost;
    private Long startDepartmentId;
    private Long endDepartmentId;

}

