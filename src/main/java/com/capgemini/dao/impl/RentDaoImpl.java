package com.capgemini.dao.impl;


import com.capgemini.dao.RentDao;
import com.capgemini.entity.RentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class RentDaoImpl extends AbstractDao<RentEntity, Long> implements RentDao {
}
