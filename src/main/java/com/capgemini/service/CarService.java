package com.capgemini.service;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.CustomerDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.dto.RentDTO;
import com.capgemini.entity.CarEntity;

import java.util.List;
import java.util.Set;

public interface CarService {

    CarDTO addCar(CarDTO car);

    List<CarDTO> findByCarType(String type);

    List<CarDTO> findCarByMark(String mark);

    List<CarDTO> findCarByTypeAndMark(String type, String mark);

    CarDTO findCarById(Long id);

    CarDTO updateCar(CarDTO car);

    void deleteCar(Long id);

    List<CarDTO> findAllCars();


    void addGuardianToCar(CarDTO car, EmployeeDTO employee);

    List<EmployeeDTO> findEmployeesByCar(CarDTO car);

    List<CarDTO> findCarsByGuardian(EmployeeDTO employee);

    void addRentToCar(CarDTO car, RentDTO rent);

    void deleteAll();

    void createNewRent(CarDTO carDTO, RentDTO rentDTO, CustomerDTO customerDTO);

    List<CarDTO> findCarsRentedByMoreThanTenCustomer();


    //TODO
 /*   withBirthDay(new Date(19910408))*/


}
