package com.Nimap.Product_Category.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Nimap.Product_Category.entity.Category;



public interface CategoryRepository extends JpaRepository<Category, Long> {
}
