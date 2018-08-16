package com.capgemini.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentDTO {


    private Long id;
    private String address;
    private String phoneNumber;


    public static DepartmentDTO.DepartmentDTOBuilder builder() {
        return new DepartmentDTO.DepartmentDTOBuilder();
    }

    public static class DepartmentDTOBuilder {
        private Long id;
        private String address;
        private String phoneNumber;


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

        public DepartmentDTO build() {
            return new DepartmentDTO(id, address, phoneNumber);
        }
    }


}
