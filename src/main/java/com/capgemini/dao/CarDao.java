package com.capgemini.dao;

import com.capgemini.entity.CarEntity;

import java.util.Date;
import java.util.List;

public interface CarDao extends Dao<CarEntity, Long> {


    List<CarEntity> findByCarType(String type);

    List<CarEntity> findCarByMark(String mark);

    List<CarEntity> findCarByTypeAndMark(String type, String mark);


    List<CarEntity> findCarsRentedByMoreThanTenCustomer();

    List<CarEntity> findCarsRentedInTimePeriod(Date rentDate, Date returnDate);


}
