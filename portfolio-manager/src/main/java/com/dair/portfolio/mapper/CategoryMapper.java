package com.dair.portfolio.mapper;

import com.dair.portfolio.dto.categoryDTO.CategoryRequestDTO;
import com.dair.portfolio.dto.categoryDTO.CategoryResponseDTO;
import com.dair.portfolio.entity.Category;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static Category toEntity(CategoryRequestDTO dto) {
        Category category = new Category();
        category.setName(dto.getName());
        return category;
    }

    public static CategoryResponseDTO toDTO(Category category) {
        CategoryResponseDTO dto = new CategoryResponseDTO();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    public static List<CategoryResponseDTO> toDTOList(List<Category> categories) {
        return categories.stream().map(CategoryMapper::toDTO).collect(Collectors.toList());
    }
}
