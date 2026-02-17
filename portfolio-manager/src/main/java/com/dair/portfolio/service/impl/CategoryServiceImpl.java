package com.dair.portfolio.service.impl;

import com.dair.portfolio.dto.categoryDTO.CategoryRequestDTO;
import com.dair.portfolio.dto.categoryDTO.CategoryResponseDTO;
import com.dair.portfolio.entity.Category;
import com.dair.portfolio.mapper.CategoryMapper;
import com.dair.portfolio.repository.CategoryRepository;
import com.dair.portfolio.service.interfac.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponseDTO create(CategoryRequestDTO dto) {
        Category category = CategoryMapper.toEntity(dto);
        Category saved = categoryRepository.save(category);
        return CategoryMapper.toDTO(saved);
    }

    @Override
    public List<CategoryResponseDTO> findAll() {
        return CategoryMapper.toDTOList(categoryRepository.findAll());
    }

    @Override
    public CategoryResponseDTO findById(Long id) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        return CategoryMapper.toDTO(category);
    }

    @Override
    public CategoryResponseDTO update(Long id, CategoryRequestDTO dto) {
        Category category = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
        category.setName(dto.getName());
        Category updated = categoryRepository.save(category);
        return CategoryMapper.toDTO(updated);
    }

    @Override
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }
}
