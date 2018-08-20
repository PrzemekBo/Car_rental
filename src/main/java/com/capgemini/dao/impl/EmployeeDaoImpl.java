package com.capgemini.dao.impl;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository

public class EmployeeDaoImpl extends  AbstractDao<EmployeeEntity,Long>implements EmployeeDao {
    @Override
    public List<EmployeeEntity> findEmployeeByDepartment(DepartmentEntity departmentId) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select worker from EmployeeEntity worker where worker.workplaceId = :workplaceId", EmployeeEntity.class);
        query.setParameter("departmentId", departmentId);
        return query.getResultList();
    }

}
