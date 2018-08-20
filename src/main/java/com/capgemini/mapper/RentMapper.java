package com.capgemini.mapper;

import com.capgemini.dto.RentDTO;
import com.capgemini.dto.RentDTO.RentDTOBuilder;
import com.capgemini.entity.RentEntity;

public class RentMapper {



    public static RentEntity toRentEntity(RentDTO rentDTO) {
        if (rentDTO == null) {
            return null;
        }

        RentEntity rentEntity = new RentEntity();
        rentEntity.setId(rentDTO.getId());
        rentEntity.setCost(rentDTO.getCost());
        rentEntity.setRentDate(rentDTO.getRentDate());
        rentEntity.setReturnDate(rentDTO.getReturnDate());

        return rentEntity;
    }



    public static RentDTO toRentDTO(RentEntity rentEntity) {
        if (rentEntity == null) {
            return null;
        }
        RentDTOBuilder rentDTOBuilder= new RentDTO().builder()
                .id(rentEntity.getId())
                .cost(rentEntity.getCost())
                .rentDate(rentEntity.getRentDate())
                .returnDate(rentEntity.getReturnDate());



        if (rentEntity.getCustomerId() != null) {
            rentDTOBuilder = rentDTOBuilder.customerId(rentEntity.getCustomerId().getId());
        }

        if (rentEntity.getCarId() != null) {
            rentDTOBuilder = rentDTOBuilder.carId(rentEntity.getCarId().getId());
        }

        if (rentEntity.getStartDepartmentId() != null) {
            rentDTOBuilder = rentDTOBuilder.startDepartmentId(rentEntity.getStartDepartmentId().getId());
        }

        if (rentEntity.getEndDepartmentId() != null) {
            rentDTOBuilder = rentDTOBuilder.endDepartmentId(rentEntity.getEndDepartmentId().getId());
        }

        return rentDTOBuilder.build();
    }






}
