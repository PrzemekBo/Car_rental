package com.capgemini.service;

import com.capgemini.dto.EmployeeDTO;
import com.capgemini.entity.CarEntity;
import com.capgemini.entity.EmployeeSearchCriteria;

import java.util.Date;
import java.util.List;


public interface EmployeeService {


    EmployeeDTO findEmployeeById(Long id);


    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);


    List<EmployeeDTO> findWorkersByMultiParams(EmployeeSearchCriteria employeeSearchCriteria);

}
