package com.capgemini.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

