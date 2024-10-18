package com.project.demo.repositories;

import com.project.demo.models.Product;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    // tim kiem product theo ten
    public boolean existsByName(String name);
    // phan trang + product
    public Page<Product>findAll(Pageable pageable); // phan trang
}
