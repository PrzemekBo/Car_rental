package com.capgemini.service.impl;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.CarDTO.CarDTOBuilder;
import com.capgemini.dto.CustomerDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.dto.RentDTO;
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
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


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
        List<CarDTO> cars = carService.findCarByTypeAndMark(type, mark);

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
        CarDTO carToDelate = carService.addCar(car2);

        //when
        carService.deleteCar(carToDelate.getId());
        List<CarDTO> cars = carService.findByCarType(type);

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
        CarDTO addedCar = carService.addCar(car);

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
        CarDTO addedCar = carService.addCar(car);


        EmployeeDTO employeeDTO = new EmployeeDTO.EmployeeDTOBuilder()
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
        CarDTO addedCar = carService.addCar(car);
        CarDTO addedCar2 = carService.addCar(car);


        EmployeeDTO employeeDTO = new EmployeeDTO.EmployeeDTOBuilder()
                .withFirstName("TOMEK")
                .withLastName("Pods")
                .withBirthDatee(new Date())
                .withProfession("manager")
                .build();
        EmployeeDTO savedEmployee = employeeService.addEmployee(employeeDTO);

        //when
        carService.addGuardianToCar(addedCar, savedEmployee);
        carService.addGuardianToCar(addedCar2, savedEmployee);
        List<CarDTO> cars = carService.findCarsByGuardian(employeeService.findEmployeeById(savedEmployee.getId()));


        //then
        assertThat(cars.size()).isEqualTo(2);

    }



    @Test
    @Transactional
    public void shouldFindCarsRentedInTimePeriod() {

        Date rentDate = new Date(5000L);
        Date returnDate = new Date(10000L);

        RentDTO rentDTO = new RentDTO().builder().cost(2000).rentDate(rentDate).returnDate(returnDate)
                .build();
        RentDTO newRent = rentService.addRent(rentDTO);


        CarDTO car = new CarDTOBuilder().withType("family").withMark("BMW")
                .withProductionYear(Year.parse("2006")).withColor("Blue").withEngineCapacity(200).withPower(60)
                .withMileage(433824).build();
        CarDTO newCar = carService.addCar(car);


        CustomerDTO customerDTO = new CustomerDTO.CustomerDTOBuilder()
                .withFirstName("Adam")
                .withFirstName("Bok")
                .withHome("Poznan")
                .withCreditCardNumber("1234567890123456")
                .build();

        CustomerDTO newCustomer = customerService.addCustomer(customerDTO);

        //when
        carService.createNewRent(newCar, newRent, newCustomer);
        List<CarDTO> cars = carService.findCarsRentedInTimePeriod(new Date(2000L), new Date(8000L));

        //then
        assertThat(cars.size()).isEqualTo(1);


    }




}
