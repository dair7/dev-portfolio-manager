package com.dair.portfolio.service.interfac;

import com.dair.portfolio.dto.categoryDTO.CategoryRequestDTO;
import com.dair.portfolio.dto.categoryDTO.CategoryResponseDTO;

import java.util.List;

public interface ICategoryService {

    CategoryResponseDTO create(CategoryRequestDTO dto);

    List<CategoryResponseDTO> findAll();

    CategoryResponseDTO findById(Long id);

    CategoryResponseDTO update(Long id, CategoryRequestDTO dto);

    void delete(Long id);
}
