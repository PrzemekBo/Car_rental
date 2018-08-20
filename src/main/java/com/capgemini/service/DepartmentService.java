package com.capgemini.service;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {

    DepartmentDTO findDepartmentById(Long id);

    DepartmentDTO addDepartment(DepartmentDTO outpost);

    void deleteAll();

    void deleteDepartment(Long id);

    List<DepartmentDTO> findAll();

    DepartmentDTO updateOutpost(DepartmentDTO departmentDTO);

    List<EmployeeDTO> findEmployeesByDepartment(DepartmentDTO departmentDTO);

    List<EmployeeDTO> findEmployeesByDepartmentAndCar(DepartmentDTO departmentDTO, CarDTO car);


    void addEmployeeToDepartment(DepartmentDTO department, EmployeeDTO employee);

    void removeEmployeeFromDepartment(DepartmentDTO department, EmployeeDTO employee);
}
