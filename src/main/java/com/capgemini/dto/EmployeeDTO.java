package com.capgemini.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String profession;

    private Long departmentId;
    private List<Long> cars;



    public static EmployeeDTO.EmployeeDTOBuilder builder() {
        return new EmployeeDTO.EmployeeDTOBuilder();
    }

    public static class EmployeeDTOBuilder {


        private Long id;
        private String firstName;
        private String lastName;
        private Date birthDate;
        private String profession;
        // private DepartmentDTO departmentDTO;
        private Long departmentId;
        private List<Long> cars;


        public EmployeeDTOBuilder() {

        }

        public EmployeeDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public EmployeeDTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeDTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeDTOBuilder withBirthDatee(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public EmployeeDTOBuilder withProfession(String profession) {
            this.profession = profession;
            return this;
        }

        public EmployeeDTOBuilder withDepartmentId(Long departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public EmployeeDTOBuilder withCars(List<Long> cars) {
            this.cars = cars;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(id, firstName, lastName, birthDate, profession, departmentId, cars);
        }
    }
}



