package com.Nimap.Product_Category.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nimap.Product_Category.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Long> {
}
