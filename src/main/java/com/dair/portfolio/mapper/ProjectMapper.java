package com.dair.portfolio.mapper;

import com.dair.portfolio.dto.projectDTO.ProjectRequestDTO;
import com.dair.portfolio.dto.projectDTO.ProjectResponseDTO;
import com.dair.portfolio.entity.Category;
import com.dair.portfolio.entity.Project;
import com.dair.portfolio.entity.Technology;

import java.util.List;
import java.util.stream.Collectors;

public class ProjectMapper {

    public static Project toEntity(ProjectRequestDTO dto, Category category, List<Technology> technologies) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setGithubUrl(dto.getGithubUrl());
        project.setDemoUrl(dto.getDemoUrl());
        project.setImageUrl(dto.getImageUrl());
        project.setCategory(category);
        project.setTechnologies(technologies);
        return project;
    }

    public static ProjectResponseDTO toDTO(Project project) {
        ProjectResponseDTO dto = new ProjectResponseDTO();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setGithubUrl(project.getGithubUrl());
        dto.setDemoUrl(project.getDemoUrl());
        dto.setImageUrl(project.getImageUrl());
        dto.setCategoryName(project.getCategory() != null ? project.getCategory().getName() : null);
        dto.setTechnologyNames(
            project.getTechnologies() != null 
                ? project.getTechnologies().stream().map(Technology::getName).collect(Collectors.toList())
                : null
        );
        return dto;
    }

    public static List<ProjectResponseDTO> toDTOList(List<Project> projects) {
        return projects.stream().map(ProjectMapper::toDTO).collect(Collectors.toList());
    }
}
