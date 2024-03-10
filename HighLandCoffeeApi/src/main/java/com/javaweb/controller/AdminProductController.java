package com.javaweb.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.PriceUpdateDetail;
import com.javaweb.entity.Product;
import com.javaweb.entity.Staff;
import com.javaweb.entity.User;
import com.javaweb.exception.ProductException;
import com.javaweb.exception.UserException;
import com.javaweb.request.CreateProductRequest;
import com.javaweb.response.ApiResponse;
import com.javaweb.service.PriceUpdateService;
import com.javaweb.service.ProductService;
import com.javaweb.service.StaffService;
import com.javaweb.service.UserService;


@RestController
@RequestMapping("/api/admin/product")
public class AdminProductController {

	private ProductService productService;
	private UserService userService;
	private StaffService staffService;
	private PriceUpdateService priceUpdateService;


	public AdminProductController(ProductService productService,UserService userService, StaffService staffService, PriceUpdateService priceUpdateService) {
		this.productService = productService;
		this.userService = userService;
		this.staffService = staffService;
		this.priceUpdateService = priceUpdateService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> createProductHandler(@RequestBody CreateProductRequest rq,@RequestHeader("Authorization") String jwt) throws ProductException, UserException{
		User user = userService.findUserByJwt(jwt);
		Staff staff = staffService.findStaffByUserId(user.getUser_id());
		rq.setStaff_id(staff.getStaff_id());
		Product createProduct = productService.createProduct(rq);
		return new ResponseEntity<Product>(createProduct,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Product>> findAllProduct(){
		List<Product> listProducts = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(listProducts,HttpStatus.OK);
	}
	
	@PutMapping("{productId}/update")
	public ResponseEntity<Product> updatePoroductHandler(@RequestBody CreateProductRequest rq, @PathVariable String productId,@RequestHeader("Authorization") String jwt) throws ProductException, UserException{
		User user = userService.findUserByJwt(jwt);
		Staff staff = staffService.findStaffByUserId(user.getUser_id());
		Product updatedProduct = productService.updateProduct(productId, rq,staff.getStaff_id());
		System.err.println(updatedProduct.getCategory().getCategory_name());
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.OK);
	}
	
	@PutMapping("{productId}/updatePrice")
	public ResponseEntity<PriceUpdateDetail> updatePriceHandler(@RequestBody PriceUpdateDetail rq, @PathVariable String productId, @RequestHeader("Authorization") String jwt ) throws ProductException, UserException{
		User user = userService.findUserByJwt(jwt);
		Staff staff = staffService.findStaffByUserId(user.getUser_id());
		PriceUpdateDetail updatePrice = priceUpdateService.updatePrice(productId, rq, staff.getStaff_id());
		return new ResponseEntity<PriceUpdateDetail>(updatePrice,HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}/delete")
	public ResponseEntity<ApiResponse> deleteProductHandler(@PathVariable String productId,@RequestHeader("Authorization") String jwt) throws ProductException, UserException{
		System.err.println("delete product controller ....");
		User user = userService.findUserByJwt(jwt);
		Staff staff = staffService.findStaffByUserId(user.getUser_id());
		String msg = productService.deleteProduct(productId,staff.getStaff_id());
		System.err.println("delete product controller .... msg " + msg);
		ApiResponse res = new ApiResponse(msg,true,HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/creates")
	public ResponseEntity<ApiResponse> createMultipleProduct(@RequestBody CreateProductRequest[] rqs) throws ProductException{
		
		for(CreateProductRequest productRequest : rqs) {
			productService.createProduct(productRequest);
		}
		
		ApiResponse res = new ApiResponse("product created successfully", true,HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ApiResponse>(res,HttpStatus.ACCEPTED);
	}
	
	
}
