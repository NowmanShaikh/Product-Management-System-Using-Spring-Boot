package com.Nimap.Product_Category.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Nimap.Product_Category.Dao.CategoryDao;
import com.Nimap.Product_Category.Dto.ResponseStructure;
import com.Nimap.Product_Category.entity.Category;



@Service
public class CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    public ResponseEntity<ResponseStructure<Category>> saveCategory(Category category) {
        Category savedCategory = categoryDao.saveCategory(category);
        ResponseStructure<Category> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Category Created Successfully");
        response.setData(savedCategory);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Category>> updateCategory(Category category, Long id) {
        Category existingCategory = categoryDao.fetchCategoryById(id);
        if (existingCategory != null) {
            category.setId(id);
            Category updatedCategory = categoryDao.saveCategory(category);
            ResponseStructure<Category> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Category Updated Successfully");
            response.setData(updatedCategory);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseStructure<Category> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Category Not Found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseStructure<Category>> fetchCategoryById(Long id) {
        Category category = categoryDao.fetchCategoryById(id);
        ResponseStructure<Category> response = new ResponseStructure<>();
        if (category != null) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Category Retrieved Successfully");
            response.setData(category);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Category Not Found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseStructure<List<Category>>> fetchAllCategories() {
        List<Category> categories = categoryDao.fetchAllCategories();
        ResponseStructure<List<Category>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Categories Retrieved Successfully");
        response.setData(categories);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteCategoryById(Long id) {
        Category category = categoryDao.fetchCategoryById(id);
        if (category != null) {
            categoryDao.deleteCategoryById(id);
            ResponseStructure<String> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Category Deleted Successfully");
            response.setData("Deleted Category with ID: " + id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseStructure<String> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Category Not Found");
            response.setData("No Category Found with ID: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}

