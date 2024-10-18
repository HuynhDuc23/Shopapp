package com.project.demo.services.impls;

import com.project.demo.models.Category;
import com.project.demo.repositories.CategoryRepository;
import com.project.demo.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public Category createCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existsCategory = getCategoryById(id);
        existsCategory.setName(category.getName());
        return this.categoryRepository.save(existsCategory);
    }

    @Override
    public void deleteCategory(Long id) {
       this.categoryRepository.deleteById(id);
    }

    @Override
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }
}
