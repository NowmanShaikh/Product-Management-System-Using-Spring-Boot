package com.Nimap.Product_Category.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Nimap.Product_Category.Dao.ProductDao;
import com.Nimap.Product_Category.Dto.ResponseStructure;
import com.Nimap.Product_Category.entity.Product;



@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) {
        Product savedProduct = productDao.saveProduct(product);
        ResponseStructure<Product> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.CREATED.value());
        response.setMessage("Product Created Successfully");
        response.setData(savedProduct);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseStructure<Product>> updateProduct(Product product, Long id) {
        Product existingProduct = productDao.fetchProductById(id);
        if (existingProduct != null) {
            product.setId(id);
            Product updatedProduct = productDao.saveProduct(product);
            ResponseStructure<Product> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Product Updated Successfully");
            response.setData(updatedProduct);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseStructure<Product> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Product Not Found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseStructure<Product>> fetchProductById(Long id) {
        Product product = productDao.fetchProductById(id);
        ResponseStructure<Product> response = new ResponseStructure<>();
        if (product != null) {
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Product Retrieved Successfully");
            response.setData(product);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Product Not Found");
            response.setData(null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<ResponseStructure<List<Product>>> fetchAllProducts() {
        List<Product> products = productDao.fetchAllProducts();
        ResponseStructure<List<Product>> response = new ResponseStructure<>();
        response.setStatusCode(HttpStatus.OK.value());
        response.setMessage("Products Retrieved Successfully");
        response.setData(products);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public ResponseEntity<ResponseStructure<String>> deleteProductById(Long id) {
        Product product = productDao.fetchProductById(id);
        if (product != null) {
            productDao.deleteProductById(id);
            ResponseStructure<String> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.OK.value());
            response.setMessage("Product Deleted Successfully");
            response.setData("Deleted Product with ID: " + id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            ResponseStructure<String> response = new ResponseStructure<>();
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setMessage("Product Not Found");
            response.setData("No Product Found with ID: " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}
