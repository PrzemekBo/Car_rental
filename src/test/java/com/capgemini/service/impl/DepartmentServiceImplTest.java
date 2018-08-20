package com.capgemini.service.impl;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.DepartmentDTO.DepartmentDTOBuilder;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.dto.EmployeeDTO.EmployeeDTOBuilder;
import com.capgemini.aWyw.ProfessionDTO;
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
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.now;
import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
public class DepartmentServiceImplTest {


    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CarService carService;


    @Transactional
    @Test
    public void shouldFindDepartment() {
        //given
        DepartmentDTO department = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        departmentService.addDepartment(department);


        //when
        List<DepartmentDTO> departments = departmentService.findAll();

        //then
        assertThat(departments.size()).isEqualTo(1);

    }


    @Transactional
    @Test
    public void shouldAddDepartment() {

        //given
        DepartmentDTO department = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO addedDepartment = departmentService.addDepartment(department);


        //when
        DepartmentDTO selectedDepartment = departmentService.findDepartmentById(addedDepartment.getId());

        //then
        assertThat(selectedDepartment.getId()).isEqualTo(addedDepartment.getId());


    }

    @Transactional
    @Test
    public void shouldDeleteDepartamentById() {
        //given
        DepartmentDTO department = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO department2 = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        departmentService.addDepartment(department);
        DepartmentDTO departmentTODelete = departmentService.addDepartment(department2);

        //when
        departmentService.deleteDepartment(departmentTODelete.getId());
        List<DepartmentDTO> departmentDTOS = departmentService.findAll();

        //then
        assertThat(departmentDTOS.size()).isEqualTo(1);


    }

    @Test
    @Transactional
    public void shouldUpdateDepartment() {


        String address = "Wwa";
        //given

        DepartmentDTO department = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO savedDepartment = departmentService.addDepartment(department);

        //when
        DepartmentDTO selectedDepartment = departmentService.findDepartmentById(savedDepartment.getId());
        selectedDepartment.setAddress(address);
        departmentService.updateOutpost(selectedDepartment);

        //then
        assertThat(departmentService.findDepartmentById(selectedDepartment.getId()).getAddress()).isEqualTo(address);


    }

/*
    @Test
    @Transactional
    public void shouldAddEmployeeToDepartment() {

/*
      //given
      DepartmentDTO departmentDTO = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
     // DepartmentDTO savedDepartment= departmentService.addDepartment(departmentDTO);

        DepartmentDTO testDepartment=departmentService.addDepartment(departmentDTO);




        ProfessionDTO professionDTO = new ProfessionDTO.ProfessionDTOBuilder()
                .withProfessionName("manager")
                .build();

        EmployeeDTO employeeDTO=  new EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(now())
                .withProfessionDTO(professionDTO)
                .withDepartmentDTO(departmentDTO)
                .withCarDTOS(new ArrayList<>())
                .build();

        EmployeeDTO testEmployee = employeeService.addEmployee(employeeDTO);

        //When
        departmentService.addEmployeeToDepartment(testDepartment, testEmployee);


        //Then
        EmployeeDTO employeeById = employeeService.findEmployeeById(testEmployee.getId());
        assertEquals(testDepartment.getAddress(), employeeById.getDepartmentDTO().getAddress());
    }

*/



/*        EmployeeDTO employee = new EmployeeDTO().builder()
                .firstName("Tomek")
                .lastName("Bocer")
                .birthDate(new Date(19910408)
                .
    }


    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private ProfessionDTO professionDTO;
    private DepartmentDTO departmentDTO;
    private Set<CarDTO> carDTOS = new HashSet<>();*/

    @Test
    @Transactional
    public void shouldAddEmployeeToDepartment() {

        //given
        DepartmentDTO departmentDTO = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO saveDepartmentDTO = departmentService.addDepartment(departmentDTO);

        EmployeeDTO employeeDTO=  new EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession("manager")
                .build();
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);
        EmployeeDTO savedEmployee2 = employeeService.addEmployee(employeeDTO);

        //when
        departmentService.addEmployeeToDepartment(saveDepartmentDTO, savedEmployee);
        departmentService.addEmployeeToDepartment(saveDepartmentDTO, savedEmployee2);

        //then
        assertThat(departmentService.findDepartmentById(saveDepartmentDTO.getId()).getEmployees().size()).isEqualTo(2);
        assertThat(employeeService.findEmployeeById(savedEmployee.getId()).getDepartmentId()).isEqualTo(saveDepartmentDTO.getId());
        assertThat(employeeService.findEmployeeById(savedEmployee2.getId()).getDepartmentId()).isEqualTo(saveDepartmentDTO.getId());
      //  assertThat(workerService.findWorkerById(savedWorker2.getId()).getWorkplaceId()).isEqualTo(savedOutpost.getId());
    }


    @Test
    @Transactional
    public void shouldRemoveEmployeeFromDepartment() {
        //given
        DepartmentDTO departmentDTO = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO saveDepartmentDTO = departmentService.addDepartment(departmentDTO);

        EmployeeDTO employeeDTO=  new EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession("manager")
                .build();

        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);
        EmployeeDTO savedEmployee2 = employeeService.addEmployee(employeeDTO);
        departmentService.addEmployeeToDepartment(saveDepartmentDTO, savedEmployee);
        departmentService.addEmployeeToDepartment(saveDepartmentDTO, savedEmployee2);

        //when
        departmentService.removeEmployeeFromDepartment(saveDepartmentDTO, savedEmployee);



        //then
        assertThat(departmentService.findDepartmentById(saveDepartmentDTO.getId()).getEmployees().size()).isEqualTo(1);
        assertThat(employeeService.findEmployeeById(savedEmployee.getId()).getDepartmentId()).isNull();
        assertThat(employeeService.findEmployeeById(savedEmployee2.getId()).getDepartmentId()).isNotNull();

    }

    @Test
    @Transactional
    public void shouldFindEmployee() {

        //given
        DepartmentDTO departmentDTO = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO saveDepartmentDTO = departmentService.addDepartment(departmentDTO);


        EmployeeDTO employeeDTO=  new EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession("manager")
                .build();
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);

        departmentService.addEmployeeToDepartment(saveDepartmentDTO, savedEmployee);
        departmentService.addEmployeeToDepartment(saveDepartmentDTO, savedEmployee);



        //when
        List<EmployeeDTO> employees = departmentService.findEmployeesByDepartment(saveDepartmentDTO);

        //then
        assertThat(employees.size()).isEqualTo(2);
        assertThat(employeeService.findEmployeeById(savedEmployee.getId()).getDepartmentId()).isEqualTo(saveDepartmentDTO.getId());
    }



    @Test
    @Transactional
    public void shouldFindEmployeeByDepartmentAndCar() {

        //given
        DepartmentDTO departmentDTO = new DepartmentDTOBuilder()
                .withAddress("poznan")
                .withPhoneNumber("32432434")
                .build();
        DepartmentDTO saveDepartmentDTO = departmentService.addDepartment(departmentDTO);
        DepartmentDTO saveDepartmentDTO2 = departmentService.addDepartment(departmentDTO);

        CarDTO car = new CarDTO.CarDTOBuilder().withType("family").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();
        CarDTO savedCar = carService.addCar(car);
        CarDTO savedCar2 = carService.addCar(car);


        EmployeeDTO employeeDTO=  new EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession("manager")
                .build();
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);
        EmployeeDTO savedEmployee2 = employeeService.addEmployee(employeeDTO);
        EmployeeDTO savedEmployee3 = employeeService.addEmployee(employeeDTO);

        carService.addGuardianToCar(savedCar,savedEmployee);
        carService.addGuardianToCar(savedCar2,savedEmployee);
        carService.addGuardianToCar(savedCar2,savedEmployee3);

        departmentService.addEmployeeToDepartment(saveDepartmentDTO,savedEmployee);
        departmentService.addEmployeeToDepartment(saveDepartmentDTO,savedEmployee2);
        departmentService.addEmployeeToDepartment(saveDepartmentDTO2,savedEmployee3);

        List<EmployeeDTO> employees = departmentService.findEmployeesByDepartmentAndCar(departmentService.findDepartmentById(saveDepartmentDTO.getId()), carService.findCarById(savedCar.getId()));
        List<EmployeeDTO> employees2 = departmentService.findEmployeesByDepartmentAndCar(departmentService.findDepartmentById(saveDepartmentDTO.getId()), carService.findCarById(savedCar2.getId()));
        List<EmployeeDTO> employees3 = departmentService.findEmployeesByDepartmentAndCar(departmentService.findDepartmentById(saveDepartmentDTO2.getId()), carService.findCarById(savedCar2.getId()));


        //TODo sprawdyic
        assertThat(employees.size()).isEqualTo(1);
        assertThat(employees2.size()).isEqualTo(1);
        assertThat(employees3.size()).isEqualTo(1);


    }





}