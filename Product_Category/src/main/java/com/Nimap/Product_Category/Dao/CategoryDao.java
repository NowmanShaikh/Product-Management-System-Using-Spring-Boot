package com.Nimap.Product_Category.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Nimap.Product_Category.Repository.CategoryRepository;
import com.Nimap.Product_Category.entity.Category;




@Repository
public class CategoryDao {

    @Autowired
    private CategoryRepository repo;

    public Category saveCategory(Category category) {
        return repo.save(category);
    }

    public Category fetchCategoryById(Long id) {
        Optional<Category> optional = repo.findById(id);
        return optional.orElse(null);
    }

    public List<Category> fetchAllCategories() {
        return repo.findAll();
    }

    public void deleteCategoryById(Long id) {
        repo.deleteById(id);
    }
}
