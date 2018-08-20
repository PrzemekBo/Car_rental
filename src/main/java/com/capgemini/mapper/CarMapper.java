package com.capgemini.mapper;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.CarDTO.CarDTOBuilder;
import com.capgemini.entity.CarEntity;

import java.util.List;
import java.util.stream.Collectors;


public class CarMapper {

    public static CarEntity toCarEntity(CarDTO carDTO) {
        if (carDTO == null) {
            return null;
        }

        CarEntity carEntity = new CarEntity();
        carEntity.setId(carDTO.getId());
        carEntity.setType(carDTO.getType());
        carEntity.setMark(carDTO.getMark());
        carEntity.setProductionYear(carDTO.getProductionYear());
        carEntity.setColor(carDTO.getColor());
        carEntity.setEngineCapacity(carDTO.getEngineCapacity());
        carEntity.setPower(carDTO.getPower());
        carEntity.setMileage(carDTO.getMileage());
        return carEntity;


    }


    public static CarDTO toCarDTO(CarEntity carEntity) {
        if (carEntity == null) {
            return null;
        }

        CarDTOBuilder carDTOBuilder = new CarDTOBuilder()
                .withId(carEntity.getId())
                .withType(carEntity.getType())
                .withMark(carEntity.getMark())
                .withProductionYear(carEntity.getProductionYear())
                .withColor(carEntity.getColor())
                .withEngineCapacity(carEntity.getEngineCapacity())
                .withPower(carEntity.getPower())
                .withEngineCapacity(carEntity.getEngineCapacity())
                .withMileage(carEntity.getMileage());

        if (carEntity.getGuardians() != null) {
            carDTOBuilder = carDTOBuilder.withGuardians(carEntity.getGuardians().stream().map(e -> e.getId()).collect(Collectors.toList()));
        }

        if (carEntity.getRents() != null) {
            carDTOBuilder = carDTOBuilder.withRent(carEntity.getRents().stream().map(r -> r.getId()).collect(Collectors.toList()));
        }

        return carDTOBuilder.build();
    }


    public static List<CarDTO> toCarTOList(List<CarEntity> cars) {
        return cars.stream().map(CarMapper::toCarDTO).collect(Collectors.toList());
    }


}
