package com.project.demo.mapper;

import com.project.demo.dtos.requests.ProductDTO;
import com.project.demo.models.Product;

public class ProductMapper {
    public static Product ProductDtoToProduct(ProductDTO productDTO) {
        return Product.builder().build();
    }
}
