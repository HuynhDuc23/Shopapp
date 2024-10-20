package com.project.demo.controllers;

import com.project.demo.dtos.requests.CategoryDTO;
import com.project.demo.mapper.CategoryMapper;
import com.project.demo.models.Category;
import com.project.demo.services.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final ICategoryService  iCategoryService ;

    @PostMapping("post")  // http://localhost:8080/api/v1/categories
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryDTO categoryDTO , BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<String> mess = (List<String>) bindingResult.getFieldErrors().stream().map(errMessager ->errMessager.getDefaultMessage()).toList();
            return ResponseEntity.badRequest().body(mess);
        }
        Category category = CategoryMapper.categoryDtoToCategory(categoryDTO);
        Category categoryResult = this.iCategoryService.createCategory(category);
        return ResponseEntity.ok(categoryResult);
    }
    @GetMapping("")  // http://localhost:8080/api/v1/categories
    public ResponseEntity<?> getAllCategory() {
       List<Category> categories = this.iCategoryService.getAllCategories();
       return ResponseEntity.ok(categories);
    }

    @PutMapping("/{id}")  // http://localhost:8080/api/v1/categories/id
    public ResponseEntity<?> updateCategory(@PathVariable("id") int id) {
        return ResponseEntity.ok("Update category with id" +  id);
    }
    @DeleteMapping("/{id}")// http://localhost:8080/api/v1/categories/id
    public ResponseEntity<?> deleteCategory(@PathVariable("id") Long id){
        this.iCategoryService.deleteCategory(id);
        return ResponseEntity.ok("Delete category with id" + id);
    }
}
