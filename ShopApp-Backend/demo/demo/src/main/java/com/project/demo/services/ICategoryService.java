package com.project.demo.services;

import com.project.demo.models.Category;

import java.util.List;

public interface ICategoryService {
    public Category createCategory(Category category) ;
    public Category getCategoryById(Long id) ;
    public Category updateCategory(Long id ,Category category) ;
    public void deleteCategory(Long id) ;
    public List<Category> getAllCategories() ;
}
