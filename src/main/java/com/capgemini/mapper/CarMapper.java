package com.capgemini.mapper;

import com.capgemini.dto.CarDTO;
import com.capgemini.entity.CarEntity;


public class CarMapper {

    public static CarEntity toCarEntity(CarDTO carDTO) {
        if (carDTO == null) {
            return null;
        }

        CarEntity carEntity = new CarEntity();
        carEntity.setId(carDTO.getId());
        carEntity.setType(carDTO.getType());
        carDTO.setMark(carDTO.getMark());
        carDTO.setProductionYear(carDTO.getProductionYear());
        carDTO.setColor(carDTO.getMark());
        carDTO.setEngineCapacity(carDTO.getMileage());
        carDTO.setPower(carDTO.getPower());
        carDTO.setMileage(carDTO.getMileage());
        carDTO.setGuardianEmployees(carDTO.getGuardianEmployees());
        return carEntity;


    }

}
