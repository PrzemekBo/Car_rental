package com.capgemini.dao.impl;

import com.capgemini.dao.CustomerDao;
import com.capgemini.entity.CustomerEntity;
import org.springframework.stereotype.Repository;


@Repository
public class CustomerDaoImpl extends AbstractDao<CustomerEntity, Long> implements CustomerDao {
}
