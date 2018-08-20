package com.capgemini.service;

import com.capgemini.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO findCustomerById(Long id);

    CustomerDTO addCustomer(CustomerDTO customer);
}
