package com.dair.portfolio.service.interfac;

import com.dair.portfolio.dto.technologyDTO.TechnologyRequestDTO;
import com.dair.portfolio.dto.technologyDTO.TechnologyResponseDTO;

import java.util.List;

public interface ITechnologyService {

    TechnologyResponseDTO create(TechnologyRequestDTO dto);

    List<TechnologyResponseDTO> findAll();

    TechnologyResponseDTO findById(Long id);

    TechnologyResponseDTO update(Long id, TechnologyRequestDTO dto);

    void delete(Long id);
}
