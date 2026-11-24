package com.dair.portfolio.service.impl;

import com.dair.portfolio.dto.projectDTO.ProjectRequestDTO;
import com.dair.portfolio.dto.projectDTO.ProjectResponseDTO;
import com.dair.portfolio.entity.Category;
import com.dair.portfolio.entity.Project;
import com.dair.portfolio.entity.Technology;
import com.dair.portfolio.mapper.ProjectMapper;
import com.dair.portfolio.repository.CategoryRepository;
import com.dair.portfolio.repository.ProjectRepository;
import com.dair.portfolio.repository.TechnologyRepository;
import com.dair.portfolio.service.interfac.IProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;
    private final CategoryRepository categoryRepository;
    private final TechnologyRepository technologyRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, 
                              CategoryRepository categoryRepository, 
                              TechnologyRepository technologyRepository) {
        this.projectRepository = projectRepository;
        this.categoryRepository = categoryRepository;
        this.technologyRepository = technologyRepository;
    }

    @Override
    public ProjectResponseDTO create(ProjectRequestDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        List<Technology> technologies = technologyRepository.findAllById(dto.getTechnologyIds());

        Project project = ProjectMapper.toEntity(dto, category, technologies);
        Project saved = projectRepository.save(project);
        return ProjectMapper.toDTO(saved);
    }

    @Override
    public List<ProjectResponseDTO> findAll() {
        return ProjectMapper.toDTOList(projectRepository.findAll());
    }

    @Override
    public ProjectResponseDTO findById(Long id) {
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
        return ProjectMapper.toDTO(project);
    }

    @Override
    public ProjectResponseDTO update(Long id, ProjectRequestDTO dto) {
        Project project = projectRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));

        Category category = categoryRepository.findById(dto.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Category not found with id: " + dto.getCategoryId()));

        List<Technology> technologies = technologyRepository.findAllById(dto.getTechnologyIds());

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setGithubUrl(dto.getGithubUrl());
        project.setDemoUrl(dto.getDemoUrl());
        project.setImageUrl(dto.getImageUrl());
        project.setCategory(category);
        project.setTechnologies(technologies);

        Project updated = projectRepository.save(project);
        return ProjectMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!projectRepository.existsById(id)) {
            throw new RuntimeException("Project not found with id: " + id);
        }
        projectRepository.deleteById(id);
    }
}
