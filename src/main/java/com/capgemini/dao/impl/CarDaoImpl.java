package com.capgemini.dao.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.entity.CarEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;


@Repository
public class CarDaoImpl extends AbstractDao<CarEntity, Long> implements CarDao {

    @Override
    public List<CarEntity> findByCarType(String type) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.type) like concat(upper(:type), '%')", CarEntity.class);
        query.setParameter("type", type);
        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarByMark(String mark) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.mark) like concat(upper(:mark),'%' ) ", CarEntity.class);
        query.setParameter("mark", mark);
        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarByTypeAndMark(String type, String mark) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where upper(car.mark) like concat(upper(:mark), '%')"
                        +
                        " and upper(car.type) like concat(upper(:type), '%')", CarEntity.class);
        query.setParameter("type", type);
        query.setParameter("mark", mark);

        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarsRentedByMoreThanTenCustomer() {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car join car.rents c group by car.id" +
                        " having count(distinct c.customerId.id)>10", CarEntity.class);

        return query.getResultList();
    }

    @Override
    public List<CarEntity> findCarsRentedInTimePeriod(Date rentDate, Date returnDate) {
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car, RentEntity rent where rent.carId = car.id " +
                        "and rent.rentDate<:returnDate and rent.returnDate>:rentDate", CarEntity.class);
        query.setParameter("rentDate", rentDate);
        query.setParameter("returnDate", returnDate);

        return query.getResultList();
    }
}

