package com.capgemini.dao.impl;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;
import com.capgemini.entity.EmployeeSearchCriteria;
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

    @Override
    public List<EmployeeEntity> findWorkersByMultiParams(EmployeeSearchCriteria employeeSearchCriteria) {
        Long carEntity = 0L;
        Long departmentEntity = 0L;
        String profession = "";

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select employees from EmployeeEntity employees");

        if (employeeSearchCriteria.getCarEntity() != null) {
            carEntity = employeeSearchCriteria.getCarEntity();
            stringBuilder.append(" join employees.cars c where c.id =:carId");
        }
        if (employeeSearchCriteria.getDepartmentEntity() != null) {
            departmentEntity = employeeSearchCriteria.getDepartmentEntity();

            if (employeeSearchCriteria.getCarEntity() != null) {
                stringBuilder.append(" and");
            } else {
                stringBuilder.append(" where");
            }
            stringBuilder.append(" employees.departmentId.id=:departmentId");
        }
        if (employeeSearchCriteria.getDepartmentEntity() != null) {
            profession = employeeSearchCriteria.getProfession();
            if (employeeSearchCriteria.getCarEntity() != null || employeeSearchCriteria.getDepartmentEntity() != null) {
                stringBuilder.append(" and");
            } else {
                stringBuilder.append(" where");
            }

            stringBuilder.append(" employees.profession=:profession");
        }

        TypedQuery<EmployeeEntity> query = entityManager.createQuery(stringBuilder.toString(), EmployeeEntity.class);

        if (employeeSearchCriteria.getCarEntity() != null) {
            query.setParameter("carId", carEntity);
        }
        if (employeeSearchCriteria.getDepartmentEntity() != null) {
            query.setParameter("profession", profession);
        }
        if (employeeSearchCriteria.getDepartmentEntity() != null) {
            query.setParameter("departmentId", departmentEntity);
        }

        return query.getResultList();
    }


}
