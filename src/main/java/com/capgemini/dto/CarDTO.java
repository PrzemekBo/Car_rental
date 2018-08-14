package com.capgemini.dto;


import com.capgemini.entity.EmployeeEntity;
import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Year;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {


    private Long id;
    private String type;
    private String mark;
    private Year productionYear;
    private String color;
    private int engineCapacity;
    private int power;
    private int mileage;
    private List<EmployeeEntity> guardianEmployees;


    public static CarDTOBuilder builder() {
        return new CarDTOBuilder();
    }


    public static class CarDTOBuilder {
        private Long id;
        private String type;
        private String mark;
        private Year productionYear;
        private String color;
        private int engineCapacity;
        private int power;
        private int mileage;
        private List<EmployeeEntity> guardianEmployees;

    }

    public CarDTOBuilder() {

    }
}
