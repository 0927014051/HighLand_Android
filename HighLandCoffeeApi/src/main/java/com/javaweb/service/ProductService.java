package com.javaweb.service;

import java.util.List;

import com.javaweb.entity.Product;
import com.javaweb.exception.ProductException;
import com.javaweb.request.CreateProductRequest;



public interface ProductService {

	// only for admin
		public Product createProduct(CreateProductRequest req) throws ProductException;
		
		public List<Product> getAllProducts();
		
		public String deleteProduct(String productId) throws ProductException;
//		
		public Product updateProduct(String productId,Product product)throws ProductException;
//		
		
//		
//		// for user and admin both
		public Product findProductById(String id) throws ProductException;
		
		public List<Product> findProductByCategory(String category);
	
}
