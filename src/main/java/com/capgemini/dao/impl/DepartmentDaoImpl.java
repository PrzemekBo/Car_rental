package com.capgemini.dao.impl;

import com.capgemini.dao.DepartmentDao;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.entity.AbstractEntity;
import com.capgemini.entity.CarEntity;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public class DepartmentDaoImpl extends AbstractDao<DepartmentEntity,Long>implements DepartmentDao {
/*    @Override
    public List<EmployeeEntity> findEmployeesByDepartment(DepartmentEntity departmentEntity) {
        TypedQuery query = entityManager.createQuery(
                "select e from EmployeeEntity e where departmentEntity.id = :id", EmployeeEntity.class);
        query.setParameter("id", departmentEntity.getId());
        return query.getResultList();
    }


    @Override
    public void addEmployeeToDepartment(EmployeeEntity employeeEntity, DepartmentEntity departmentEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee where employee.id = :employeeId", EmployeeEntity.class);
        query.setParameter("employeeId", employeeEntity.getId());
        EmployeeEntity employee = query.getSingleResult();

        employee.setDepartmentEntity(departmentEntity);
        entityManager.merge(employee);
    }
    @Override
    public void removeEmployeeFromDepartment(EmployeeEntity employeeEntity, DepartmentEntity departmentEntity) {
        TypedQuery<EmployeeEntity> query = entityManager.createQuery(
                "select employee from EmployeeEntity employee where employee.id = :employeeId", EmployeeEntity.class);
        query.setParameter("employeeId", employeeEntity.getId());
        EmployeeEntity employee = query.getSingleResult();

        employee.setDepartmentEntity(null);
        entityManager.merge(employee);
    }*/
}
