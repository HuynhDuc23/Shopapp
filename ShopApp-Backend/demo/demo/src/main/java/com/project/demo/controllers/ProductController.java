package com.project.demo.controllers;

import com.project.demo.dtos.requests.ProductDTO;
import com.project.demo.models.Product;
import com.project.demo.services.IProductService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.prefix}/product")
@RequiredArgsConstructor
public class ProductController {
    private final IProductService productService;

    @GetMapping("/")
    // http://localhost:8080/api/v1/product/
    public ResponseEntity<?> getAllProduct(){
        List<Product> products = this.productService.products();
        return ResponseEntity.status(HttpStatus.CREATED).body(products);
    }
    @GetMapping("/{id}")
    // http://localhost:8080/api/v1/product/1
    public ResponseEntity<?> getProductById(@PathVariable("id")  int productId , BindingResult bindingResult){
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("product with %d",productId));
    }
    @PostMapping(value = "/", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createProduct(
            @Valid @ModelAttribute ProductDTO productDTO ,
            BindingResult bindingResult) throws Exception {
        List<String> listErr = new ArrayList<>();
        try {
            if (bindingResult.hasErrors()) {
                listErr = bindingResult.getFieldErrors().stream().map(FieldError::getDefaultMessage).toList();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listErr);
            }
            List<MultipartFile> files = productDTO.getFiles();
            files = files == null ? new ArrayList<MultipartFile>() : files ;
            for(MultipartFile file : files){
//                if(file.getSize()==0){
//                    continue;
//                }
                // truong hop neu trong request ho khong dua file vao
                if (file != null && !file.isEmpty()) {
                    // kiem tra kich thuoc va dinh dang cua file
                    if (file.getSize() > 10 * 1024 * 1024) {
                        return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("File is too large! Maximum size is 10MB");
                    }
                    // kiem tra dinh dang file
                    String contentType = file.getContentType();
                    if (contentType == null || !contentType.startsWith("image/")) {
                        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("File must be an image");
                    }
                    String fileName = storeFile(file);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Created");
    }
    private String storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename()); // lay ra file name
        // file + uuid : truong hop 2 file co ten cung luc len server
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
        // Duong dan den thu muc ban muon luu file
        Path uploadDir = Paths.get("uploads");
        // kiem tra thu muc upload da ton tai hay chua
        if (!Files.exists(uploadDir)) {
            Files.createDirectory(uploadDir);
        }
        // duong dan day du den file
        Path destination = Paths.get(uploadDir.toString(), uniqueFileName);
        // sao chep file vao thu muc dich
        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
    }
    @DeleteMapping("/{id}")
    // http://localhost:8080/api/v1/product/1
    public ResponseEntity<?> deleteProductById(@PathVariable("id") int productId){
        return ResponseEntity.status(HttpStatus.CREATED).body(String.format("delete product with id %d",productId));
    }
}
