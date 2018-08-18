package com.capgemini.service.impl;

import com.capgemini.dao.DepartmentDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;
import com.capgemini.mapper.DepartmentMapper;
import com.capgemini.mapper.EmployeeMapper;
import com.capgemini.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    @Autowired
    private DepartmentDao departmentDao;
    private EmployeeDao employeeDao;


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

    @Override
    public List<EmployeeDTO> findEmployeesByDepartment(DepartmentDTO departmentDTO) {
        List<EmployeeEntity> employees;
        DepartmentEntity departmentEntity = departmentDao.findOne(departmentDTO.getId());
        if(departmentEntity.getEmployees() != null){
            employees = departmentEntity.getEmployees();
        }

        else {
            employees = new LinkedList<>();
        }

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();

        for(EmployeeEntity employeeEntity: employees){
            employeeDTOS.add(EmployeeMapper.toEmployeeDTO(employeeEntity));
        }

        return employeeDTOS;
    }

    @Override
    public void addEmployeeToDepartment(DepartmentDTO department, EmployeeDTO employee) {
        List<EmployeeDTO> employees = findEmployeesByDepartment(department);
        List<EmployeeEntity> employeeEntities = new ArrayList<>();

        for(EmployeeDTO e: employees){
            employeeEntities.add(employeeDao.findOne(e.getId()));
        }

        DepartmentEntity departmentEntity = departmentDao.findOne(department.getId());
        EmployeeEntity addedEmployer = employeeDao.findOne(employee.getId());

        addedEmployer.setDepartmentEntity(departmentEntity);
        employeeDao.update(addedEmployer);

        employeeEntities.add(addedEmployer);
        departmentEntity.setEmployees(employeeEntities);
        departmentDao.update(departmentEntity);
    }


}
