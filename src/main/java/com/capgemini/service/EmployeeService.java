package com.capgemini.service;

import com.capgemini.dto.EmployeeDTO;



public interface EmployeeService {


    EmployeeDTO findEmployeeById(Long id);


    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
}
