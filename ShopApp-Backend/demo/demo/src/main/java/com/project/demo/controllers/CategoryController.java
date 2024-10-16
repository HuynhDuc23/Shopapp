package com.project.demo.controllers;

import com.project.demo.dtos.requests.CategoryDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @GetMapping("")  // http://localhost:8080/api/v1/categories
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok("Get All Category");
    }
    @PostMapping("")  // http://localhost:8080/api/v1/categories
    public ResponseEntity<?> createCategory(@RequestBody @Valid CategoryDTO categoryDTO , BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            List<String> mess = (List<String>) bindingResult.getFieldErrors().stream().map(errMessager ->errMessager.getDefaultMessage()).toList();
            return ResponseEntity.badRequest().body(mess);
        }
        return ResponseEntity.ok("Create Category");
    }
    @PutMapping("/{id}")  // http://localhost:8080/api/v1/categories/id
    public ResponseEntity<?> updateCategory(@PathVariable("id") int id) {
        return ResponseEntity.ok("Update category with id" +  id);
    }
    @DeleteMapping("/{id}")// http://localhost:8080/api/v1/categories/id
    public ResponseEntity<?> deleteCategory(@PathVariable("id") int id){
        return ResponseEntity.ok("DeleteCategory with id"+id);
    }
}
