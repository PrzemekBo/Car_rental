package com.capgemini.service.impl;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.CarDTO.CarDTOBuilder;
import com.capgemini.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarServiceImplTest {


    @Autowired
    private CarService carService;


 /*  @Before
    public void setUp(){
        carService.deleteAll();
    }*/

    @Transactional
    @Test
    public void shouldFindByCarType() {

        final String type = "family";

        CarDTO car = new CarDTOBuilder().withType(type).withMark("BMW")
                .withProductionYear(2006).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();
        CarDTO car2 = new CarDTOBuilder().withType("carrying").withMark("BMW")
                .withProductionYear(2006).withColor("Black").withEngineCapacity(200).withPower(60)
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
                .withProductionYear(2006).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();
        CarDTO car2 = new CarDTOBuilder().withType("carrying").withMark("BMW")
                .withProductionYear(2006).withColor("Pink").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();

        carService.addCar(car);
        carService.addCar(car2);

        //when
        List<CarDTO>cars=carService.findCarByMark(mark);
        //then
        assertThat(cars.size()).isEqualTo(1);
        assertThat(cars.stream().anyMatch(c -> c.getMark().equals(mark))).isTrue();

    }

    @Transactional
    @Test
    public void shouldFindCarById() {

        //given
        CarDTO car = new CarDTOBuilder().withType("Family").withMark("BMW")
                .withProductionYear(2006).withColor("Black").withEngineCapacity(200).withPower(60)
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
                .withProductionYear(2006).withColor("Black").withEngineCapacity(200).withPower(60)
                .withMileage(43324).build();

        CarDTO car2 = new CarDTOBuilder().withType(type).withMark("Toyota")
                .withProductionYear(2006).withColor("Black").withEngineCapacity(400).withPower(60)
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
                .withProductionYear(2006).withColor("Blue").withEngineCapacity(200).withPower(60)
                .withMileage(433824).build();
        CarDTO addedCar=carService.addCar(car);

        //when
        CarDTO carToChangeColor = carService.findCarById(addedCar.getId());
        carToChangeColor.setColor(color);
        carService.updateCar(carToChangeColor);

        //then
        assertThat(carService.findCarById(carToChangeColor.getId()).getColor()).isEqualTo(color);






    }



}
