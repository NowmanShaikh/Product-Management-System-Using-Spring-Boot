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
import com.Nimap.Product_Category.entity.Product;


@RestController
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ResponseStructure<Product>> updateProduct(@RequestBody Product product, @PathVariable Long id) {
        return productService.updateProduct(product, id);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ResponseStructure<Product>> fetchProductById(@PathVariable Long id) {
        return productService.fetchProductById(id);
    }

    @GetMapping("/product")
    public ResponseEntity<ResponseStructure<List<Product>>> fetchAllProducts() {
        return productService.fetchAllProducts();
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<ResponseStructure<String>> deleteProduct(@PathVariable Long id) {
        return productService.deleteProductById(id);
    }
}


