package com.capgemini.mapper;

import com.capgemini.dto.CustomerDTO;
import com.capgemini.dto.CustomerDTO.CustomerDTOBuilder;
import com.capgemini.entity.CustomerEntity;
import com.capgemini.entity.RentEntity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerMapper {

    public static CustomerEntity toCustomerEntity(CustomerDTO customerDTO) {
        if (customerDTO == null) {
            return null;
        }

        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setId(customerDTO.getId());
        customerEntity.setFirstName(customerDTO.getFirstName());
        customerEntity.setLastName(customerDTO.getLastName());
        customerDTO.setHome(customerDTO.getHome());
        customerDTO.setCreditCardNumber(customerDTO.getCreditCardNumber());
        return customerEntity;
    }

        public static CustomerDTO toCustomerTO(CustomerEntity customerEntity) {
            if(customerEntity == null){
                return null;
            }

            CustomerDTOBuilder customerDTOBuilder = new CustomerDTOBuilder()
                    .withId(customerEntity.getId())
                    .withFirstName(customerEntity.getFirstName())
                    .withLastName(customerEntity.getLastName())
                    .withHome(customerEntity.getHome())
                    .withCreditCardNumber(customerEntity.getCreditCardNumber());


            if (customerEntity.getRent() != null){
                customerDTOBuilder = customerDTOBuilder.withRent(customerEntity.getRent().stream().map(w -> w.getId()).collect(Collectors.toList()));
            }

            return customerDTOBuilder.build();
        }

}
