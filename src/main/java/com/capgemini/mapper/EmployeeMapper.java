package com.capgemini.mapper;

import com.capgemini.dto.CarDTO;
import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.dto.EmployeeDTO.EmployeeDTOBuilder;
import com.capgemini.entity.CarEntity;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;
import com.capgemini.entity.ProfessionEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeMapper {

    public static EmployeeEntity toEmployeeEntity(EmployeeDTO employeeDTO) {
        if (employeeDTO == null) {
            return null;
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(employeeDTO.getId());
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setBirthDate(employeeDTO.getBirthDate());
        employeeEntity.setProfession(ProfessionMapper.toProfessionEntity(employeeDTO.getProfessionDTO()));
        employeeEntity.setDepartmentEntity(DepartmentMapper.toDepartmentEntity(employeeDTO.getDepartmentDTO()));
        employeeEntity.setCars(CarMapper.mapToEntities(employeeDTO.getCarDTOS()));

        return employeeEntity;


    }



    public static EmployeeDTO toEmployeeDTO(EmployeeEntity employeeEntity) {
        if(employeeEntity == null){
            return null;
        }

        return new EmployeeDTO.EmployeeDTOBuilder()
                .withId(employeeEntity.getId())
                .withFirstName(employeeEntity.getFirstName())
                .withLastName(employeeEntity.getLastName())
                .withBirthDatee(employeeEntity.getBirthDate())
                .withProfessionDTO(ProfessionMapper.toProfessionDTO(employeeEntity.getProfession()))
                .withDepartmentDTO(DepartmentMapper.toDepartmentDTO(employeeEntity.getDepartmentEntity()))
                .withCarDTOS(CarMapper.mapToDTO(employeeEntity.getCars()))
                .build();

    }




    public static List<EmployeeDTO> toEmployeDTOList(List<EmployeeEntity> employees) {
        return employees.stream().map(EmployeeMapper::toEmployeeDTO).collect(Collectors.toList());
    }

    public static List<EmployeeEntity> toEmployeeEntityList(List<EmployeeDTO> employees) {
        return employees.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toList());
    }


}
