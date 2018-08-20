package com.capgemini.service.impl;

import com.capgemini.dao.CustomerDao;
import com.capgemini.dto.CustomerDTO;
import com.capgemini.entity.CustomerEntity;
import com.capgemini.mapper.CustomerMapper;
import com.capgemini.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {


    private CustomerDao customerDao;


    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public CustomerDTO findCustomerById(Long id) {
        return CustomerMapper.toCustomerTO(customerDao.findOne(id));
    }


    @Override
    public CustomerDTO addCustomer(CustomerDTO customer) {
        CustomerEntity customerEntity = customerDao.save(CustomerMapper.toCustomerEntity(customer));
        return CustomerMapper.toCustomerTO(customerEntity);
    }
}
