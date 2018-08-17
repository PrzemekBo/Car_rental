package com.capgemini.service.impl;

import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.mapper.EmployeeMapper;
import com.capgemini.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    @Override
    public EmployeeDTO findEmployeeById(Long id) {

            return EmployeeMapper.toEmployeeDTO(employeeDao.findOne(id));

    }
}