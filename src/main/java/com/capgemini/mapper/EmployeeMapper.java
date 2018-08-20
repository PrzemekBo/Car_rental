package com.capgemini.mapper;

import com.capgemini.aWyw.ProfessionMapper;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.dto.EmployeeDTO.EmployeeDTOBuilder;
import com.capgemini.entity.EmployeeEntity;

import java.util.Date;
import java.util.List;
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
        employeeEntity.setProfession(employeeDTO.getProfession());


/*        employeeEntity.setProfession(ProfessionMapper.toProfessionEntity(employeeDTO.getProfessionDTO()));
        employeeEntity.setDepartmentEntity(DepartmentMapper.toDepartmentEntity(employeeDTO.getDepartmentDTO()));
        employeeEntity.setCars(CarMapper.mapToEntities(employeeDTO.getCarDTOS()));*/

        return employeeEntity;


    }



    public static EmployeeDTO toEmployeeDTO(EmployeeEntity employeeEntity) {
        if(employeeEntity == null){
            return null;
        }

        EmployeeDTOBuilder employeeDTOBuilder= new EmployeeDTO().builder()
                .id(employeeEntity.getId())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .birthDate(employeeEntity.getBirthDate())
                .profession(employeeEntity.getProfession());

        if (employeeEntity.getDepartmentId() != null) {
            employeeDTOBuilder = employeeDTOBuilder.departmentId(employeeEntity.getDepartmentId().getId());
        }

        if(employeeEntity.getCars() != null){
            employeeDTOBuilder = employeeDTOBuilder.cars(employeeEntity.getCars().stream().map(c -> c.getId()).collect(Collectors.toList()));
        }

        return employeeDTOBuilder.build();
    }

/*
                .wit(employeeEntity.getId())
                .withFirstName(employeeEntity.getFirstName())
                .withLastName(employeeEntity.getLastName())
                .withBirthDatee(employeeEntity.getBirthDate())
                .withProfession(employeeEntity.getProfession())

    */
/*    return new EmployeeDTO.EmployeeDTOBuilder()
                .withId(employeeEntity.getId())
                .withFirstName(employeeEntity.getFirstName())
                .withLastName(employeeEntity.getLastName())
                .withBirthDatee(employeeEntity.getBirthDate())
                .withProfession(employeeEntity.getProfession())*//*


         */
/*       .withProfessionDTO(ProfessionMapper.toProfessionDTO(employeeEntity.getProfession()))
                .withDepartmentDTO(DepartmentMapper.toDepartmentDTO(employeeEntity.getDepartmentEntity()))
                .withCarDTOS(CarMapper.toCarTOList(employeeEntity.getCars()))*//*

                .build();
*/






    public static List<EmployeeDTO> toEmployeDTOList(List<EmployeeEntity> employees) {
        return employees.stream().map(EmployeeMapper::toEmployeeDTO).collect(Collectors.toList());
    }

    public static List<EmployeeEntity> toEmployeeEntityList(List<EmployeeDTO> employees) {
        return employees.stream().map(EmployeeMapper::toEmployeeEntity).collect(Collectors.toList());
    }


}
