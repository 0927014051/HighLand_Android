package com.javaweb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.Product;
import com.javaweb.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping("/search/products")
	public ResponseEntity<List<Product>> searchProductHandler(@RequestParam String query){
		List<Product> products = productService.searchProduct(query);
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@GetMapping("/products/category/{category}")
	public ResponseEntity<List<Product>> findProductByCategory(@PathVariable String category){
		List<Product> products = productService.findProductByCategory(category);
		return new ResponseEntity<>(products,HttpStatus.OK);
	}

}
