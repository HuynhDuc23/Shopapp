package com.project.demo.services.impls;

import com.project.demo.models.Product;
import com.project.demo.repositories.ProductRepository;
import com.project.demo.services.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository ;
    @Override
    public List<Product> products() {
       return this.productRepository.findAll();
    }
}
