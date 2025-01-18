package com.Nimap.Product_Category.Dao;

import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;

import com.Nimap.Product_Category.Repository.ProductRepository;
import com.Nimap.Product_Category.entity.Product;


	

	@Repository
	public class ProductDao {

	    @Autowired
	    private ProductRepository repo;

	    public Product saveProduct(Product product) {
	        return repo.save(product);
	    }

	    public Product fetchProductById(Long id) {
	        Optional<Product> optional = repo.findById(id);
	        return optional.orElse(null);
	    }

	    public List<Product> fetchAllProducts() {
	        return repo.findAll();
	    }

	    public void deleteProductById(Long id) {
	        repo.deleteById(id);
	    }
	}
