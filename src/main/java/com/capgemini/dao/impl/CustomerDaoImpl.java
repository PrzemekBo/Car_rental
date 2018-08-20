package com.capgemini.dao.impl;

import com.capgemini.dao.CustomerDao;
import com.capgemini.dao.RentDao;
import com.capgemini.entity.CustomerEntity;
import com.capgemini.entity.RentEntity;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerEntity,Long>implements CustomerDao {
}
