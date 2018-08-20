package com.capgemini.dao;

import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;
import com.capgemini.entity.EmployeeSearchCriteria;

import java.util.List;

public interface EmployeeDao extends Dao<EmployeeEntity, Long>  {

    List<EmployeeEntity> findEmployeeByDepartment(DepartmentEntity departmentId);

    List<EmployeeEntity> findWorkersByMultiParams(EmployeeSearchCriteria employeeSearchCriteria);
}
