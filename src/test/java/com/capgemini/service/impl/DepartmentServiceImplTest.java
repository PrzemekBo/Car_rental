package com.capgemini.service.impl;

import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.DepartmentDTO.DepartmentDTOBuilder;
import com.capgemini.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceImplTest {



    @Autowired
    private DepartmentService departmentService;




    @Transactional
    @Test
    public void shouldFindDepartment() {
        //given
        DepartmentDTO department= new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
       departmentService.addDepartment(department);


        //when
        List<DepartmentDTO>departments=departmentService.findAll();

        //then
        assertThat(departments.size()).isEqualTo(1);

    }


    @Transactional
    @Test
    public void shouldAddDepartment() {

        //given
        DepartmentDTO department= new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO addedDepartment=departmentService.addDepartment(department);


        //when
        DepartmentDTO selectedDepartment=departmentService.findDepartmentById(addedDepartment.getId());

        //then
        assertThat(selectedDepartment.getId()).isEqualTo(addedDepartment.getId());



    }
    @Transactional
    @Test
    public void shouldDeleteDepartamentById() {
        //given
        DepartmentDTO department= new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO department2= new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        departmentService.addDepartment(department);
        DepartmentDTO departmentTODelete=departmentService.addDepartment(department2);

        //when
        departmentService.deleteDepartment(departmentTODelete.getId());
        List<DepartmentDTO>departmentDTOS=departmentService.findAll();

        //then
        assertThat(departmentDTOS.size()).isEqualTo(1);


    }

    @Test
    @Transactional
    public void shouldUpdateDepartment() {


        String address = "Wwa";
        //given

        DepartmentDTO department= new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO savedDepartment=departmentService.addDepartment(department);

        //when
        DepartmentDTO selectedDepartment=departmentService.findDepartmentById(savedDepartment.getId());
        selectedDepartment.setAddress(address);
        departmentService.updateOutpost(selectedDepartment);

        //then
        assertThat(departmentService.findDepartmentById(selectedDepartment.getId()).getAddress()).isEqualTo(address);


    }

    }