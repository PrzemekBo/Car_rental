package com.capgemini.service;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.entity.CarEntity;

import java.util.List;

public interface CarService {

    CarDTO addCar(CarDTO car);

    List<CarDTO> findByCarType(String type);

    List<CarDTO> findCarByMark(String mark);

    List<CarDTO> findCarByTypeAndMark(String type, String mark);

    CarDTO findCarById(Long id);

    CarDTO updateCar(CarDTO car);

    void deleteCar(Long id);

    List<CarDTO> findCarBySupervisor(long supervisorId);



    void deleteAll();


    //TODO
 /*   withBirthDay(new Date(19910408))*/


}
