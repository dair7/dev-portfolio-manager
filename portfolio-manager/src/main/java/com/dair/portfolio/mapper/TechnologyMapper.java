package com.dair.portfolio.mapper;

import com.dair.portfolio.dto.technologyDTO.TechnologyRequestDTO;
import com.dair.portfolio.dto.technologyDTO.TechnologyResponseDTO;
import com.dair.portfolio.entity.Technology;

import java.util.List;
import java.util.stream.Collectors;

public class TechnologyMapper {

    public static Technology toEntity(TechnologyRequestDTO dto) {
        Technology technology = new Technology();
        technology.setName(dto.getName());
        return technology;
    }

    public static TechnologyResponseDTO toDTO(Technology technology) {
        TechnologyResponseDTO dto = new TechnologyResponseDTO();
        dto.setId(technology.getId());
        dto.setName(technology.getName());
        return dto;
    }

    public static List<TechnologyResponseDTO> toDTOList(List<Technology> technologies) {
        return technologies.stream().map(TechnologyMapper::toDTO).collect(Collectors.toList());
    }
}
