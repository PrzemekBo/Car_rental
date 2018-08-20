package com.capgemini.service.impl;

import com.capgemini.dao.DepartmentDao;
import com.capgemini.dao.EmployeeDao;
import com.capgemini.dto.CarDTO;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;
import com.capgemini.mapper.DepartmentMapper;
import com.capgemini.mapper.EmployeeMapper;
import com.capgemini.service.DepartmentService;
import com.capgemini.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class DepartmentServiceImpl implements DepartmentService {


    private DepartmentDao departmentDao;
    private EmployeeService employeeService;
    private EmployeeDao employeeDao;



    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao, EmployeeService employeeService, EmployeeDao employeeDao) {
        this.departmentDao = departmentDao;
        this.employeeService = employeeService;
        this.employeeDao = employeeDao;
    }


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
    public void deleteAll() {departmentDao.deleteAll();

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
    public List<EmployeeDTO> findEmployeesByDepartmentAndCar(DepartmentDTO departmentDTO, CarDTO car) {
        List<EmployeeDTO> employeeInDepartment = findEmployeesByDepartment(departmentDTO);

        employeeInDepartment = employeeInDepartment.stream().filter(e -> e.getCars() != null && e.getCars().contains(car.getId())).collect(Collectors.toList());

        return employeeInDepartment;
    }

    @Override
    @Transactional(readOnly = false)
    public void addEmployeeToDepartment(DepartmentDTO department, EmployeeDTO employee) {
        List<EmployeeDTO> employees = findEmployeesByDepartment(department);
        List<EmployeeEntity> employeesEntities = new ArrayList<>();

        for(EmployeeDTO e: employees){
            employeesEntities.add(employeeDao.findOne(e.getId()));
        }

        DepartmentEntity departmentEntity = departmentDao.findOne(department.getId());
        EmployeeEntity addedEmployee = employeeDao.findOne(employee.getId());

        addedEmployee.setDepartmentId(departmentEntity);
        employeeDao.update(addedEmployee);

        employeesEntities.add(addedEmployee);
        departmentEntity.setEmployees(employeesEntities);
        departmentDao.update(departmentEntity);
    }


    @Override
    @Transactional(readOnly = false)
    public void removeEmployeeFromDepartment(DepartmentDTO department, EmployeeDTO employee) {
        EmployeeEntity employeeEntity = employeeDao.findOne(employee.getId());
        DepartmentEntity departmentEntity = departmentDao.findOne(department.getId());

        List<EmployeeEntity> employeeEntities = departmentEntity.getEmployees();
        employeeEntities.remove(employeeEntity);

        employeeEntity.setDepartmentId(null);
        employeeDao.update(employeeEntity);
        departmentEntity.setEmployees(employeeEntities);
        departmentDao.update(departmentEntity);
    }



}
