package com.capgemini.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
public class DepartmentDTO {


    private Long id;
    private String address;
    private String phoneNumber;

    private List<Long> employees;


    public static DepartmentDTO.DepartmentDTOBuilder builder() {
        return new DepartmentDTO.DepartmentDTOBuilder();
    }

    public static class DepartmentDTOBuilder {
        private Long id;
        private String address;
        private String phoneNumber;

        private List<Long> employees=new ArrayList<>();


        public DepartmentDTOBuilder() {

        }

        public DepartmentDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public DepartmentDTOBuilder withAddress(String address) {
            this.address = address;
            return this;
        }

        public DepartmentDTOBuilder withPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public DepartmentDTOBuilder withEmployees(List<Long> employees){
            this.employees = employees;
            return this;
        }


        public DepartmentDTO build() {
            return new DepartmentDTO(id, address, phoneNumber,employees);
        }
    }


}
