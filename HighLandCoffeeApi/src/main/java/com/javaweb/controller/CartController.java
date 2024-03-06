package com.javaweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.Cart;
import com.javaweb.entity.Customer;
import com.javaweb.entity.User;
import com.javaweb.exception.ProductException;
import com.javaweb.exception.UserException;
import com.javaweb.request.AddItemRequest;
import com.javaweb.response.ApiResponse;
import com.javaweb.service.CartService;
import com.javaweb.service.CustomerService;
import com.javaweb.service.UserService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	private CartService cartService;
	private UserService userService;
	private CustomerService customerService;
	public CartController(CartService cartService, UserService userService,CustomerService customerService) {
		this.cartService = cartService;
		this.userService = userService;
		this.customerService = customerService;
	}
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCartHandler(@RequestHeader("Authorization") String jwt) throws UserException{
		
		User user = userService.findUserByJwt(jwt);
		Customer customer = customerService.findCustomerByUserId(user.getUser_id());
		Cart cart = cartService.findCartBCustomerId(customer.getCustomer_id());
		System.err.println("cart - " + cart.getCustomer().getEmail());
		
		return new ResponseEntity<Cart>(cart,HttpStatus.OK);
	}
	
	@PutMapping("/add")
	public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddItemRequest req, @RequestHeader("Authorization") String jwt) throws UserException, ProductException{
		User user = userService.findUserByJwt(jwt);
		Customer customer = customerService.findCustomerByUserId(user.getUser_id());
		System.err.println("Customer_id: " + customer.getCustomer_id() + "req - " + req.getProduct_id() + " - " + req.getPrice() + " - " + req.getQuantity()  );

		cartService.addCartItem(customer.getCustomer_id(), req);
		ApiResponse response = new ApiResponse("Item add to cart",true);
		
		return new ResponseEntity<ApiResponse>(response,HttpStatus.ACCEPTED);
	}
	
	

}
