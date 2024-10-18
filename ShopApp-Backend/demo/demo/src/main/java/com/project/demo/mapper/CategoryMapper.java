package com.project.demo.mapper;

import com.project.demo.dtos.requests.CategoryDTO;
import com.project.demo.models.Category;

public class CategoryMapper {
    public static Category categoryDtoToCategory(CategoryDTO categoryDTO){
        return Category.builder()
               .name(categoryDTO.getName())
               .build();
    }
}
