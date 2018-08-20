package com.capgemini.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDTO {


    private Long id;
    private String type;
    private String mark;
    private Year productionYear;
    private String color;
    private Integer engineCapacity;
    private Integer power;
    private Integer mileage;
    private List<Long> guardians;
    private List<Long> rent;



    public static CarDTOBuilder builder() {
        return new CarDTOBuilder();
    }


    public static class CarDTOBuilder {
        private Long id;
        private String type;
        private String mark;
        private Year productionYear;
        private String color;
        private Integer engineCapacity;
        private Integer power;
        private Integer mileage;
        private List<Long> guardians;
        private List<Long> rent;


        public CarDTOBuilder() {

        }


        public CarDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CarDTOBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public CarDTOBuilder withMark(String mark) {
            this.mark = mark;
            return this;

        }

        public CarDTOBuilder withProductionYear(Year productionYear) {
            this.productionYear = productionYear;
            return this;
        }

        public CarDTOBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarDTOBuilder withEngineCapacity(Integer engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public CarDTOBuilder withPower(Integer power) {
            this.power = power;
            return this;
        }

        public CarDTOBuilder withMileage(Integer mileage) {
            this.mileage = mileage;
            return this;
        }


        public CarDTOBuilder withGuardians(List<Long> guardians) {
            this.guardians = guardians;
            return this;
        }

        public CarDTOBuilder withRent(List<Long> rent) {
            this.rent = rent;
            return this;
        }


        public CarDTO build() {

            return new CarDTO(id, type, mark, productionYear, color, engineCapacity, power, mileage, guardians, rent);
        }
    }

}
