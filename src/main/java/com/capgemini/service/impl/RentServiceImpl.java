package com.capgemini.service.impl;

import com.capgemini.dao.RentDao;
import com.capgemini.dto.RentDTO;
import com.capgemini.entity.RentEntity;
import com.capgemini.mapper.RentMapper;
import com.capgemini.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RentServiceImpl implements RentService {

    private RentDao rentDao;

    @Autowired
    public RentServiceImpl(RentDao rentDao) {
        this.rentDao = rentDao;
    }


    @Override
    public RentDTO findRenttById(Long id)  {
        return RentMapper.toRentDTO(rentDao.findOne(id));
    }


    @Override
    public RentDTO addRent(RentDTO rentDTO) {
        RentEntity rentEntity = rentDao.save(RentMapper.toRentEntity(rentDTO));
        return RentMapper.toRentDTO(rentEntity);
    }

}
