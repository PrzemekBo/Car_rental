package com.capgemini.service.impl;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.entity.EmployeeSearchCriteria;
import com.capgemini.service.CarService;
import com.capgemini.service.DepartmentService;
import com.capgemini.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class EmployeeServiceTest {


/*
    @Test
    @Transactional
    public void shouldReturnEmployeeByFindingThemByMultiParams() {

        String salesmane = "salesmane";
        String deirector = "director";



        EmployeeDTO employeeDTO=  new EmployeeDTO.EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession(salesmane)
                .build();


        EmployeeDTO employeeDTO2=  new EmployeeDTO.EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession(deirector)
                .build();
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);
        EmployeeDTO savedEmployee2 = employeeService.addEmployee(employeeDTO2);


        DepartmentDTO departmentDTO = new DepartmentDTO.DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO saveDepartmentDTO = departmentService.addDepartment(departmentDTO);
        departmentService.addEmployeeToDepartment(saveDepartmentDTO, savedEmployee);


        CarDTO car = new CarDTO.CarDTOBuilder().withType("family").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();
        CarDTO savedCar = carService.addCar(car);

        carService.addGuardianToCar(savedCar, savedEmployee);

        EmployeeSearchCriteria employeeSearchCriteria = new EmployeeSearchCriteria();
        employeeSearchCriteria.setProfession(salesmane);
        employeeSearchCriteria.setDepartmentEntity(saveDepartmentDTO.getId());
        employeeSearchCriteria.setCarEntity(savedCar.getId());

        List<EmployeeDTO> employees = employeeService.findWorkersByMultiParams(employeeSearchCriteria);

        assertThat(employees.size()).isEqualTo(1);
    }

    @Test
    @Transactional
    public void shouldFindEmployeeById() {
        //given
        EmployeeDTO employeeDTO=  new EmployeeDTO.EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession("testter")
                .build();
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);

        //when
        EmployeeDTO selectedEmplo = employeeService.findEmployeeById(savedEmployee.getId());

        //then
        assertThat(selectedEmplo.getId()).isEqualTo(savedEmployee.getId());
    }
*/




}