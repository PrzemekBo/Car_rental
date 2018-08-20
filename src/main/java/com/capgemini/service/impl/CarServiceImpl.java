package com.capgemini.service.impl;


import com.capgemini.dao.CarDao;
import com.capgemini.dao.CustomerDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dao.RentDao;
import com.capgemini.dto.CarDTO;
import com.capgemini.dto.CustomerDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.dto.RentDTO;
import com.capgemini.entity.CarEntity;
import com.capgemini.entity.CustomerEntity;
import com.capgemini.entity.EmployeeEntity;
import com.capgemini.entity.RentEntity;
import com.capgemini.mapper.CarMapper;
import com.capgemini.mapper.EmployeeMapper;
import com.capgemini.service.CarService;
import com.capgemini.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class CarServiceImpl implements CarService {


    private CarDao carDao;
    private EmployeeService employeeService;
    private EmployeeDao employeeDao;
    private RentDao rentDao;
    private CustomerDao customerDao;



    @Autowired
    public CarServiceImpl(CarDao carDao, EmployeeService employeeService, EmployeeDao employeeDao, RentDao rentDao, CustomerDao customerDao) {
        this.carDao = carDao;
        this.employeeService = employeeService;
        this.employeeDao = employeeDao;
        this.rentDao = rentDao;
        this.customerDao = customerDao;
    }




    @Override
    public CarDTO addCar(CarDTO car) {
        CarEntity carEntity=carDao.save(CarMapper.toCarEntity(car));
        return CarMapper.toCarDTO(carEntity);
    }

    @Override
    public List<CarDTO> findByCarType(String type) {

        return CarMapper.toCarTOList(carDao.findByCarType(type));
    }

    @Override
    public List<CarDTO> findCarByMark(String mark) {
        return CarMapper.toCarTOList(carDao.findCarByMark(mark));
    }

    @Override
    public List<CarDTO> findCarByTypeAndMark(String type, String mark) {
        return CarMapper.toCarTOList(carDao.findCarByTypeAndMark(type,mark));
    }

    @Override
    public CarDTO findCarById(Long id) {
        return CarMapper.toCarDTO(carDao.findOne(id));
    }

    @Override
    public CarDTO updateCar(CarDTO car) {
        CarEntity carEntity = carDao.update(CarMapper.toCarEntity(car));
        return CarMapper.toCarDTO(carEntity);
    }

    @Override
    public void deleteCar(Long id) {
        carDao.delete(id);
    }

    @Override
    public List<CarDTO> findAllCars() { {
        return CarMapper.toCarTOList(carDao.findAll());
    }
    }

    @Override
    public void addGuardianToCar(CarDTO car, EmployeeDTO employee) {
        List<EmployeeDTO> employees = findEmployeesByCar(car);
        List<EmployeeEntity> employeeEntities = new ArrayList<>();

        for(EmployeeDTO e: employees){
            employeeEntities.add(employeeDao.findOne(e.getId()));
        }

        CarEntity carEntity = carDao.findOne(car.getId());
        EmployeeEntity addedEmployee = employeeDao.findOne(employee.getId());
        List<CarEntity> carEntities = addedEmployee.getCars();
        if(carEntities == null){
            carEntities = new ArrayList<>();
        }
        carEntities.add(carEntity);
        addedEmployee.setCars(carEntities);

        employeeDao.update(addedEmployee);
        employeeEntities.add(addedEmployee);
        carEntity.setGuardians(employeeEntities);

        carDao.update(carEntity);

    }


    @Override
    public List<EmployeeDTO> findEmployeesByCar(CarDTO car) {
        List<Long> employees;
        if(car.getGuardians() != null){
            employees = car.getGuardians();
        }
        else {
            employees = new LinkedList<>();
        }

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for(Long id: employees){
            employeeDTOS.add(employeeService.findEmployeeById(id));
        }

        return employeeDTOS;
    }

    @Override
    public List<CarDTO> findCarsByGuardian(EmployeeDTO employee) {
        List<Long> cars;
        List<CarDTO> carDTOS = new ArrayList<>();

        if(employee.getCars() != null){
            cars = employee.getCars();
        }
        else {
            cars = new LinkedList<>();
        }

        for(Long id: cars){
            carDTOS.add(findCarById(id));
        }

        return carDTOS;
    }


    @Override
    public void addRentToCar(CarDTO car, RentDTO rent) {

    }



/*
    @Override
    public List<CarDTO> findCarBySupervisor(long supervisorId) {
        List<CarEntity> cars = carDao.findCarByEmployeeSupervisor(supervisorId);
        return CarMapper.toCarTOList(cars);
    }
*/


    @Override
    public void deleteAll()  {
        carDao.deleteAll();
    }

    @Override
    public void createNewRent(CarDTO carDTO, RentDTO rentDTO, CustomerDTO customerDTO) {
        RentEntity rentEntity = rentDao.findOne(rentDTO.getId());
        CarEntity carEntity = carDao.findOne(carDTO.getId());
        CustomerEntity customerEntity = customerDao.findOne(customerDTO.getId());

        rentEntity.setCarId(carEntity);
        rentEntity.setCustomerId(customerEntity);

        rentDao.update(rentEntity);

        List<RentEntity> rentEntitiesFromCar;
        if (carEntity.getRents() == null) {
            rentEntitiesFromCar = new ArrayList<>();
        } else {
            rentEntitiesFromCar = carEntity.getRents();
        }

        rentEntitiesFromCar.add(rentEntity);

        carEntity.setRents(rentEntitiesFromCar);
        carDao.update(carEntity);

        List<RentEntity> rentalEntitiesFromCustomer;

        if (customerEntity.getRent() == null) {
            rentalEntitiesFromCustomer = new ArrayList<>();
        } else {
            rentalEntitiesFromCustomer = carEntity.getRents();
        }

        rentalEntitiesFromCustomer.add(rentEntity);
        customerEntity.setRent(rentalEntitiesFromCustomer);
        customerDao.update(customerEntity);
    }

    @Override
    public List<CarDTO> findCarsRentedByMoreThanTenCustomer() {
        return CarMapper.toCarTOList(carDao.findCarsRentedByMoreThanTenCustomer());
    }

    @Override
    public List<CarDTO> findCarsRentedInTimePeriod(Date rentDate, Date returnDate) {
        return CarMapper.toCarTOList(carDao.findCarsRentedInTimePeriod(rentDate, returnDate));
    }


}
