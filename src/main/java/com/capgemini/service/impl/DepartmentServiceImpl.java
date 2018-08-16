package com.capgemini.service.impl;

import com.capgemini.dao.DepartmentDao;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.mapper.DepartmentMapper;
import com.capgemini.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public DepartmentDTO findDepartmentById(Long id) {
        return DepartmentMapper.toDepartmentDTO(departmentDao.findOne(id));
    }

    @Override
    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity=departmentDao.save(DepartmentMapper.toDepartmentEntity(departmentDTO));
        return DepartmentMapper.toDepartmentDTO(departmentEntity);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentDao.delete(id);

    }

    @Override
    public List<DepartmentDTO> findAll() {
        return DepartmentMapper.toDepartmentDTOList(departmentDao.findAll());
    }

    @Override
    public DepartmentDTO updateOutpost(DepartmentDTO departmentDTO) {
        DepartmentEntity departmentEntity=departmentDao.update(DepartmentMapper.toDepartmentEntity(departmentDTO));
        return DepartmentMapper.toDepartmentDTO(departmentEntity);
    }
}
