package com.Nimap.Product_Category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Nimap.Product_Category.Dto.ResponseStructure;
import com.Nimap.Product_Category.Service.*;
import com.Nimap.Product_Category.entity.Category;

@RestController
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<ResponseStructure<Category>> saveCategory(@RequestBody Category category) {
        return categoryService.saveCategory(category);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<ResponseStructure<Category>> updateCategory(@RequestBody Category category, @PathVariable Long id) {
        return categoryService.updateCategory(category, id);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseStructure<Category>> fetchCategoryById(@PathVariable Long id) {
        return categoryService.fetchCategoryById(id);
    }

    @GetMapping("/category")
    public ResponseEntity<ResponseStructure<List<Category>>> fetchAllCategories() {
        return categoryService.fetchAllCategories();
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategoryById(id);
    }
}

