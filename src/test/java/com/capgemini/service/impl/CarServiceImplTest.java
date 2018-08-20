package com.capgemini.service.impl;

import com.capgemini.dto.*;
import com.capgemini.dto.CarDTO.CarDTOBuilder;
import com.capgemini.aWyw.ProfessionDTO;
import com.capgemini.service.CarService;
import com.capgemini.service.CustomerService;
import com.capgemini.service.EmployeeService;
import com.capgemini.service.RentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.Year;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.DateUtil.now;
import static org.junit.Assert.assertEquals;


@SpringBootTest(properties = "spring.profiles.active=hsql")
@RunWith(SpringRunner.class)

public class CarServiceImplTest {


    @Autowired
    private CarService carService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RentService rentService;
    @Autowired
    private CustomerService customerService;





 /*  @Before
    public void setUp(){
        carService.deleteAll();
    }*/

    @Transactional
    @Test
    public void shouldFindByCarType() {

        final String type = "family";

        CarDTO car = new CarDTOBuilder().withType(type).withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();
        CarDTO car2 = new CarDTOBuilder().withType("carrying").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();

        carService.addCar(car);
        carService.addCar(car2);

        //when
        List<CarDTO> cars = carService.findByCarType(type);
        //then
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.stream().anyMatch(c -> c.getType().equals(type))).isTrue();


    }

    @Transactional
    @Test
    public void shouldFindCarByMark() {


        final String mark = "Toyota";

        //given
        CarDTO car = new CarDTOBuilder().withType("family").withMark(mark)
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();
        CarDTO car2 = new CarDTOBuilder().withType("carrying").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Pink").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();

        carService.addCar(car);
        carService.addCar(car2);

        //when
        List<CarDTO> cars = carService.findCarByMark(mark);
        //then
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.stream().anyMatch(c -> c.getMark().equals(mark))).isTrue();

    }


    @Transactional
    @Test
    public void shouldFindByCarTypeAndMark() {


        final String mark = "Toyota";
        final String type = "family";

        //given
        CarDTO car = new CarDTOBuilder().withType(type).withMark(mark)
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();

        CarDTO car2 = new CarDTOBuilder().withType("carrying").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Pink").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();
        carService.addCar(car);
        carService.addCar(car2);

        //when
        List<CarDTO>cars=carService.findCarByTypeAndMark(type,mark);

        //then
        assertThat(cars.size()).isEqualTo(1);

    }




    @Transactional
    @Test
    public void shouldFindCarById() {

        //given
        CarDTO car = new CarDTOBuilder().withType("Family").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();
        CarDTO savedCar = carService.addCar(car);

        //when
        CarDTO selectedCar = carService.findCarById(savedCar.getId());

        //then
        assertThat(savedCar.getMark()).isEqualTo(selectedCar.getMark());
        assertThat(savedCar.getId()).isEqualTo(selectedCar.getId());

    }


    @Transactional
    @Test
    public void shouldDeleteCarById() {

        final String type = "family";

        //given
        CarDTO car = new CarDTOBuilder().withType(type).withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();

        CarDTO car2 = new CarDTOBuilder().withType(type).withMark("Toyota")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(400).withPower(60)
                .withMileage(43324).build();

        carService.addCar(car);
        CarDTO carToDelate=carService.addCar(car2);

        //when
        carService.deleteCar(carToDelate.getId());
        List<CarDTO>cars=carService.findByCarType(type);

        //then
        assertThat(cars.size()).isEqualTo(1);


    }

    @Transactional
    @Test
    public void shouldUpdateCar() {

        final String color = "Pink";

        //given
        CarDTO car = new CarDTOBuilder().withType("family").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Blue").withEngineCapacity(200).withPower(60)
                .withMileage(433824).build();
        CarDTO addedCar=carService.addCar(car);

        //when
        CarDTO carToChangeColor = carService.findCarById(addedCar.getId());
        carToChangeColor.setColor(color);
        carService.updateCar(carToChangeColor);

        //then
        assertThat(carService.findCarById(carToChangeColor.getId()).getColor()).isEqualTo(color);


        //TODO delete all



    }

    @Test
    @Transactional
    public void shouldAddGuardToCar() {

        //given
        CarDTO car = new CarDTOBuilder().withType("family").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Blue").withEngineCapacity(200).withPower(60)
                .withMileage(433824).build();
        CarDTO addedCar=carService.addCar(car);


        EmployeeDTO employeeDTO=  new EmployeeDTO.EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession("manager")
                .build();
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);


        //when
        carService.addGuardianToCar(addedCar, savedEmployee);
        List<EmployeeDTO> employees = carService.findEmployeesByCar(carService.findCarById(addedCar.getId()));

        assertThat(employees.size()).isEqualTo(1);
        assertThat(employeeService.findEmployeeById(savedEmployee.getId()).getCars().get(0)).isEqualTo(addedCar.getId());
    }



    @Test
    @Transactional
    public void shouldFindCarsByGuardian() {
        //given
        CarDTO car = new CarDTOBuilder().withType("family").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Blue").withEngineCapacity(200).withPower(60)
                .withMileage(433824).build();
        CarDTO addedCar=carService.addCar(car);
        CarDTO addedCar2=carService.addCar(car);


        EmployeeDTO employeeDTO=  new EmployeeDTO.EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession("manager")
                .build();
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);

        //when
        carService.addGuardianToCar(addedCar,savedEmployee);
        carService.addGuardianToCar(addedCar2,savedEmployee);
        List<CarDTO> cars = carService.findCarsByGuardian(employeeService.findEmployeeById(savedEmployee.getId()));


        //then
        assertThat(cars.size()).isEqualTo(2);

    }

    @Test
    @Transactional
    public void shouldFindCarsRentedMoreThanByTenCustomers() {

        RentDTO rentDTO = new RentDTO().builder().cost(2000).rentDate(new Date()).build();
        RentDTO newRent1 = rentService.addRent(rentDTO);
        RentDTO newRent2 = rentService.addRent(rentDTO);
        RentDTO newRent3= rentService.addRent(rentDTO);
        RentDTO newRent4 = rentService.addRent(rentDTO);
        RentDTO newRent5 = rentService.addRent(rentDTO);
        RentDTO newRent6 = rentService.addRent(rentDTO);
        RentDTO newRent7 = rentService.addRent(rentDTO);
        RentDTO newRent8 = rentService.addRent(rentDTO);
        RentDTO newRent9 = rentService.addRent(rentDTO);
        RentDTO newRent10 = rentService.addRent(rentDTO);
        RentDTO newRent11= rentService.addRent(rentDTO);
        RentDTO newRent12= rentService.addRent(rentDTO);


        CarDTO car = new CarDTOBuilder().withType("family").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Blue").withEngineCapacity(200).withPower(60)
                .withMileage(433824).build();
        CarDTO newCar=carService.addCar(car);


        CustomerDTO customerDTO= new CustomerDTO.CustomerDTOBuilder()
                .withFirstName("Adam")
                .withFirstName("Bok")
                .withHome("Poznan")
                .withCreditCardNumber("1234567890123456")
                .build();

        CustomerDTO newCustomer1 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer2 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer3 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer4 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer5 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer6 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer7=customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer8 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer9 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer10 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer11 =customerService.addCustomer(customerDTO);
        CustomerDTO newCustomer12 =customerService.addCustomer(customerDTO);


        //when
        carService.createNewRent(newCar, newRent1, newCustomer1);
        carService.createNewRent(newCar, newRent2, newCustomer2);
        carService.createNewRent(newCar, newRent3, newCustomer3);
        carService.createNewRent(newCar, newRent4, newCustomer4);
        carService.createNewRent(newCar, newRent5, newCustomer6);
        carService.createNewRent(newCar, newRent6, newCustomer6);
        carService.createNewRent(newCar, newRent7, newCustomer7);
        carService.createNewRent(newCar, newRent8, newCustomer8);
        carService.createNewRent(newCar, newRent9, newCustomer9);
        carService.createNewRent(newCar, newRent10, newCustomer10);
        carService.createNewRent(newCar, newRent11, newCustomer11);
        carService.createNewRent(newCar, newRent12, newCustomer12);

        List<CarDTO> cars = carService.findCarsRentedByMoreThanTenCustomer();

        //then
        assertThat(cars.size()).isEqualTo(1);


    }



/*
  @Test
    @Transactional
    public void shouldFindCarsByEmployee() {

        final String type = "family";

        //given
        CarDTO car = new CarDTOBuilder().withType(type).withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();


        CarDTO testCar1 = carService.addCar(car);

        CarDTO car2 = new CarDTOBuilder().withType(type).withMark("Toyota")
                .withProductionYear(Year.parse("2006")).withColor("Black").withEngineCapacity(400).withPower(60)
                .withMileage(43324).build();

        CarDTO testCar2 = carService.addCar(car2);


        ProfessionDTO professionDTO = new ProfessionDTO.ProfessionDTOBuilder()
                .withProfessionName("TestPosition")
                .build();


        DepartmentDTO departmentDTO = new DepartmentDTO.DepartmentDTOBuilder()
                .withAddress("TestName")
                .withPhoneNumber("4324324")
                .build();


        EmployeeDTO employeeDTO = new EmployeeDTO.EmployeeDTOBuilder()
                .withFirstName("Test")
                .withLastName("Test")
                .withBirthDatee(now())
                .withDepartmentDTO(departmentDTO)
                .withProfessionDTO(professionDTO)
                .withCarDTOS(new ArrayList<>())
                .build();

        employeeService.addEmployee(employeeDTO);

       // EmployeeDTO testemployeeDTO1 = employeeService.addEmployee(employeeDTO);

        //When
        carService.addCarToEmployeeSupervisor(testCar1, employeeDTO);
        carService.addCarToEmployeeSupervisor(testCar2, employeeDTO);

        //Then
        List<CarDTO> carsByEmployee = carService.findCarBySupervisor(employeeDTO);
        assertEquals(2, carsByEmployee.size());


    }*/
}
