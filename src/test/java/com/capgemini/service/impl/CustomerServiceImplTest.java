package com.capgemini.service.impl;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.CustomerDTO;
import com.capgemini.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(properties = "spring.profiles.active=hsql")
public class CustomerServiceImplTest {


    @Autowired
    private CustomerService customerService;

    @Test
    @Transactional
    public void shoudAddCustomer() {

        CustomerDTO customerDTO= new CustomerDTO.CustomerDTOBuilder()
                .withFirstName("Adam")
                .withFirstName("Bok")
                .withHome("Poznan")
                .withCreditCardNumber("1234567890123456")
                .build();

        CustomerDTO customer =customerService.addCustomer(customerDTO);


        //when
        CustomerDTO selectedClient = customerService.findCustomerById(customer.getId());

        //then
        assertThat(selectedClient.getId()).isEqualTo(customer.getId());




    }
}