package com.capgemini.mapper;

import com.capgemini.dto.DepartmentDTO;
import com.capgemini.dto.EmployeeDTO;
import com.capgemini.dto.ProfessionDTO;
import com.capgemini.dto.ProfessionDTO.ProfessionDTOBuilder;
import com.capgemini.entity.DepartmentEntity;
import com.capgemini.entity.EmployeeEntity;
import com.capgemini.entity.ProfessionEntity;

import java.util.List;
import java.util.stream.Collectors;

public class ProfessionMapper {

    public static ProfessionEntity toProfessionEntity(ProfessionDTO professionDTO) {
        if (professionDTO == null) {
            return null;
        }

        ProfessionEntity professionEntity = new ProfessionEntity();
        professionEntity.setId(professionDTO.getId());
        professionEntity.setProfessionName(professionDTO.getProfessionName());
        return professionEntity;

    }


    public static ProfessionDTO toProfessionDTO(ProfessionEntity professionEntity) {
        if(professionEntity == null){
            return null;
        }

        return new ProfessionDTO.ProfessionDTOBuilder()
                .withId(professionEntity.getId())
                .withProfessionName(professionEntity.getProfessionName())
                .build();
    }


    public static List<ProfessionDTO> toProfessionDTOList(List<ProfessionEntity> positionEntities) {
        return positionEntities.stream().map(ProfessionMapper::toProfessionDTO).collect(Collectors.toList());
    }

    public static List<ProfessionEntity> toProfesionEntityList(List<ProfessionDTO> positionTos) {
        return positionTos.stream().map(ProfessionMapper::toProfessionEntity).collect(Collectors.toList());
    }








}
