package com.capgemini.dto;


import com.capgemini.entity.EmployeeEntity;
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
    private Integer productionYear;
    private String color;
    private int engineCapacity;
    private int power;
    private int mileage;
  //  private List<EmployeeEntity> guardianEmployees;


    public static CarDTOBuilder builder() {
        return new CarDTOBuilder();
    }


    public static class CarDTOBuilder {
        private Long id;
        private String type;
        private String mark;
        private Integer productionYear;
        private String color;
        private int engineCapacity;
        private int power;
        private int mileage;
        //private List<EmployeeEntity> guardianEmployees;

        public CarDTOBuilder() {

        }



        public CarDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CarDTOBuilder withType(String type){
            this.type=type;
            return this;
        }

        public CarDTOBuilder withMark(String mark){
            this.mark=mark;
            return this;

        }
        public CarDTOBuilder withProductionYear(Integer productionYear){
            this.productionYear=productionYear;
            return this;
         }

        public CarDTOBuilder withColor(String color) {
            this.color = color;
            return this;
        }

        public CarDTOBuilder withEngineCapacity(int engineCapacity) {
            this.engineCapacity = engineCapacity;
            return this;
        }

        public CarDTOBuilder withPower(int power) {
            this.power = power;
            return this;
        }

        public CarDTOBuilder withMileage(int mileage) {
            this.mileage = mileage;
            return this;
        }

   /*     //TODO nie jestem pewnz cz to dobrze
        public CarDTOBuilder withGuardianEmployees(List<EmployeeEntity>guardianEmployees){
        this.guardianEmployees=guardianEmployees;
        return this;
        }*/


        public CarDTO build(){
            //check
            return new CarDTO(id, type, mark, productionYear, color, engineCapacity, power, mileage);
        }
    }

}