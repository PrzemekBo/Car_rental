package com.capgemini.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private ProfessionDTO professionDTO;
    private DepartmentDTO departmentDTO;
    private Set<CarDTO> carDTOS = new HashSet<>();


    public static EmployeeDTO.EmployeeDTOBuilder builder() {
        return new EmployeeDTO.EmployeeDTOBuilder();
    }

    public static class EmployeeDTOBuilder {


        private Long id;
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private ProfessionDTO professionDTO;
        private DepartmentDTO departmentDTO;
        private Set<CarDTO> carDTOS = new HashSet<>();


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

        public EmployeeDTOBuilder withBirthDatee(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public EmployeeDTOBuilder withProfessionDTO(ProfessionDTO professionDTO) {
            this.professionDTO = professionDTO;
            return this;
        }

        public EmployeeDTOBuilder withDepartmentDTO(DepartmentDTO departmentDTO) {
            this.departmentDTO = departmentDTO;
            return this;
        }

        public EmployeeDTOBuilder withCarDTOS(Set<CarDTO> carDTOS) {
            this.carDTOS = carDTOS;
            return this;
        }

        public EmployeeDTO build() {
            return new EmployeeDTO(id, firstName, lastName, birthDate, professionDTO, departmentDTO, carDTOS);
        }
    }
}



