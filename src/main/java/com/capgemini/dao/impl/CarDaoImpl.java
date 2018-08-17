package com.capgemini.dao.impl;

import com.capgemini.dao.CarDao;
import com.capgemini.entity.CarEntity;
import com.capgemini.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
    public List<CarEntity> findCarByEmployeeSupervisor(long employeeSupervisorId) {
        EmployeeEntity employee = entityManager.getReference(EmployeeEntity.class, employeeSupervisorId);
        TypedQuery<CarEntity> query = entityManager.createQuery(
                "select car from CarEntity car where :supervisor member of car.employees", CarEntity.class);
        query.setParameter("supervisor", employee);
        return query.getResultList();
    }



}
