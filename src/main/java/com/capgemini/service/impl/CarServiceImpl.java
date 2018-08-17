package com.capgemini.service.impl;


import com.capgemini.dao.CarDao;
import com.capgemini.dto.CarDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.entity.CarEntity;
import com.capgemini.mapper.CarMapper;
import com.capgemini.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class CarServiceImpl implements CarService {



    @Autowired
    private CarDao carDao;

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
    public List<CarDTO> findCarBySupervisor(long supervisorId) {
        List<CarEntity> cars = carDao.findCarByEmployeeSupervisor(supervisorId);
        return CarMapper.toCarTOList(cars);
    }


    @Override
    public void deleteAll()  {
        carDao.deleteAll();
    }


}
