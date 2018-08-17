package com.capgemini.mapper;

import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.DepartmentDTO.DepartmentDTOBuilder;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentMapper {

    public static DepartmentEntity toDepartmentEntity(DepartmentDTO departmentDTO) {
        if (departmentDTO == null) {
            return null;
        }

        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setId(departmentDTO.getId());
        departmentEntity.setAddress(departmentDTO.getAddress());
        departmentEntity.setPhoneNumber(departmentDTO.getPhoneNumber());

        return departmentEntity;

    }


    public static DepartmentDTO toDepartmentDTO(DepartmentEntity departmentEntity) {
        if(departmentEntity == null){
            return null;
        }

        return new DepartmentDTOBuilder()
                .withId(departmentEntity.getId())
                .withAddress(departmentEntity.getAddress())
                .withPhoneNumber(departmentEntity.getPhoneNumber())
                .build();

    }

    public static List<DepartmentDTO> toDepartmentDTOList(List<DepartmentEntity> departments) {
        return departments.stream()
                .map(DepartmentMapper::toDepartmentDTO)
                .collect(Collectors
                        .toList());
    }




}