package com.project.demo.controllers;

import com.project.demo.dtos.requests.ProductDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @GetMapping("/")
    // http://localhost:8080/api/v1/product/
    public ResponseEntity<?> getAllProduct(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Get All Products");
    }
    @GetMapping("/{id}")
    // http://localhost:8080/api/v1/product/1
    public ResponseEntity<?> getProductById(@PathVariable("id")  int productId , BindingResult bindingResult){
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("product with %d",productId));
    }
    @PostMapping
    // http://localhost:8080/api/v1/product
    public ResponseEntity<?> createProduct(@Valid  @RequestBody ProductDTO productDTO , BindingResult bindingResult) throws Exception {
        List<String> listErr = new ArrayList<String>();
        try {
            if(bindingResult.hasErrors()){
                listErr = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listErr);
            }
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }
    @DeleteMapping("/{id}")
    // http://localhost:8080/api/v1/product/1
    public ResponseEntity<?> deleteProductById(@PathVariable("id") int productId){
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("delete product with id %d",productId));
    }
}
