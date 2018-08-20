package com.capgemini.dto;

import com.capgemini.entity.RentEntity;
import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDTO {


    private Long id;
    private String firstName;
    private String lastName;
    private String home;
    private String creditCardNumber;
    private Date birthDate;
    private List<Long> rent;

    public static CustomerDTO.CustomerDTOBuilder builder() {
        return new CustomerDTO.CustomerDTOBuilder();
    }

    public static class CustomerDTOBuilder {
        private Long id;
        private String firstName;
        private String lastName;
        private String home;
        private String creditCardNumber;
        private Date birthDate;
        private List<Long> rent;

        public CustomerDTOBuilder() {
        }



        public CustomerDTO.CustomerDTOBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder withLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder withHome(String home) {
            this.home = home;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder withCreditCardNumber(String creditCardNumber) {
            this.creditCardNumber = creditCardNumber;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder withBirthDate(Date birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public CustomerDTO.CustomerDTOBuilder withRent(List<Long> rent) {
            this.rent = rent;
            return this;
        }

        public CustomerDTO build() {
            return new CustomerDTO(id, firstName, lastName, home, creditCardNumber, birthDate, rent);
        }


    }






}
