package com.javaweb.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.Product;
import com.javaweb.exception.ProductException;
import com.javaweb.request.CreateProductRequest;
import com.javaweb.response.ApiResponse;
import com.javaweb.service.ProductService;


@RestController
@RequestMapping("/api/admin/product")
public class AdminProductController {

	private ProductService productService;

	public AdminProductController(ProductService productService) {
		this.productService = productService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> createProductHandler(@RequestBody CreateProductRequest rq) throws ProductException{
		Product createProduct = productService.createProduct(rq);
		return new ResponseEntity<Product>(createProduct,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct(){
		List<Product> listProducts = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(listProducts,HttpStatus.OK);
	}
	
	@PutMapping("{productId}/update")
	public ResponseEntity<Product> updatePoroductHandler(@RequestBody Product rq, @PathVariable String productId) throws ProductException{
		Product updatedProduct = productService.updateProduct(productId, rq);
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}/delete")
	public ResponseEntity<ApiResponse> deleteProductHandler(@PathVariable String productId) throws ProductException{
		System.err.println("delete product controller ....");
		String msg = productService.deleteProduct(productId);
		System.err.println("delete product controller .... msg " + msg);
		ApiResponse res = new ApiResponse(msg,true);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/creates")
	public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] rqs) throws ProductException{
		
		for(CreateProductRequest productRequest : rqs) {
			productService.createProduct(productRequest);
		}
		
		ApiResponse res = new ApiResponse("product created successfully", true);
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
}
