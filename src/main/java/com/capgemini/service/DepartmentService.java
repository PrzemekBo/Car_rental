package com.capgemini.service;

import com.capgemini.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO findDepartmentById(Long id);

    DepartmentDTO addDepartment(DepartmentDTO outpost);

    void deleteDepartment(Long id);

    List<DepartmentDTO> findAll();

    DepartmentDTO updateOutpost(DepartmentDTO departmentDTO);
}