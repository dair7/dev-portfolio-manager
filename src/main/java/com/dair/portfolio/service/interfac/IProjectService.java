package com.dair.portfolio.service.interfac;

import com.dair.portfolio.dto.projectDTO.ProjectRequestDTO;
import com.dair.portfolio.dto.projectDTO.ProjectResponseDTO;

import java.util.List;

public interface IProjectService {

    ProjectResponseDTO create(ProjectRequestDTO dto);

    List<ProjectResponseDTO> findAll();

    ProjectResponseDTO findById(Long id);

    ProjectResponseDTO update(Long id, ProjectRequestDTO dto);

    void delete(Long id);
}
