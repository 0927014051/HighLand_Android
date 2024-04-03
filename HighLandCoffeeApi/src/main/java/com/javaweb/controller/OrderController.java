package com.javaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.Category_Size;
import com.javaweb.entity.Customer;
import com.javaweb.entity.Orders;
import com.javaweb.entity.User;
import com.javaweb.exception.UserException;
import com.javaweb.reponsitory.OrderRepo;
import com.javaweb.request.BuyNowRequest;
import com.javaweb.response.ApiResponse;
import com.javaweb.response.ListEntityStatusResponse;
import com.javaweb.service.CustomerService;
import com.javaweb.service.OrderService;
import com.javaweb.service.SizeCategoryService;
import com.javaweb.service.UserService;

@RestController
@RequestMapping("/api/order")
@SuppressWarnings({ "rawtypes", "unchecked" })

public class OrderController {
	
	private OrderService orderService;
	private CustomerService customerService;
	private UserService userService;
	private SizeCategoryService sizeCategoryService;
	
	@Autowired
	private OrderRepo orderRepo;

	public OrderController(OrderService orderService, CustomerService customerService, OrderRepo orderRepo,UserService userService, SizeCategoryService sizeCategoryService) {
		super();
		this.orderService = orderService;
		this.customerService = customerService;
		this.orderRepo = orderRepo;
		this.userService = userService;
		this.sizeCategoryService = sizeCategoryService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<ApiResponse> createOrderHandler( @RequestHeader("Authorization") String jwt) throws UserException{		 
		User user = userService.findUserByJwt(jwt);
		ApiResponse res = new ApiResponse();
		HttpStatus http = null;
		if(user != null) {
			Customer customer = customerService.findCustomerByUserId(user.getUser_id());
			if(customer != null) {
				Orders orders = orderService.createOrder(customer);
				if(orders != null) {
					res.setCode(HttpStatus.CREATED.value());
					res.setMessage("create order success");
					res.setStatus(true);
					http = HttpStatus.CREATED;
				}else {
					res.setCode(HttpStatus.BAD_REQUEST.value());
					res.setMessage("create order fail");
					res.setStatus(false);
					http = HttpStatus.BAD_REQUEST;
				}
			}
		}
		return new ResponseEntity<ApiResponse>(res,http);
	}
	
	@PostMapping("/buynow")
	public ResponseEntity<ApiResponse> buynowOrderHandler(@RequestHeader("Authorization") String jwt, @RequestBody BuyNowRequest rq) throws UserException{
		User user = userService.findUserByJwt(jwt);
		Customer customer = customerService.findCustomerByUserId(user.getUser_id());
		Orders orders = orderService.orderBuyNow(rq,customer.getCustomer_id());
		ApiResponse response = new ApiResponse();
		HttpStatus http = null;
		if(orders != null) {
			response.setCode(HttpStatus.CREATED.value());
			response.setMessage("created order success");
			response.setStatus(true);	
			http = HttpStatus.OK;
		}else {
			response.setCode(HttpStatus.BAD_REQUEST.value());
			response.setMessage("created order fail");
			response.setStatus(false);
			http = HttpStatus.CONFLICT;
		}
		return new ResponseEntity<ApiResponse>(response,http);
	}
	
	@GetMapping("/size/all")
	public ResponseEntity<ListEntityStatusResponse> getAllCategorySize(){
		List<Category_Size> category_Sizes = sizeCategoryService.getAllCategorySize();
		ListEntityStatusResponse res = new ListEntityStatusResponse();
		HttpStatus http = null;
		if(category_Sizes !=null) {
			res.setData(category_Sizes);
			res.setMessage("find all size");
			res.setStatus(HttpStatus.OK.value());
			http = HttpStatus.OK;
		}else {
			res.setData(null);
			res.setMessage("not found size or is empty");
			res.setStatus(HttpStatus.CONFLICT.value());
			http = HttpStatus.CONFLICT;
		}
		return new ResponseEntity<ListEntityStatusResponse>(res,http);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ListEntityStatusResponse> getAllOrderByJwt(@RequestHeader("Authorization") String jwt) throws UserException{
		User user = userService.findUserByJwt(jwt);
		Customer customer = customerService.findCustomerByUserId(user.getUser_id());
		List<Orders> allOrder = orderRepo.findOrderByCustomerId(customer.getCustomer_id());
		ListEntityStatusResponse res = new ListEntityStatusResponse();
		HttpStatus http = null;
		if(allOrder != null) {
			res.setData(allOrder);
			res.setMessage("find all order success");
			res.setStatus(HttpStatus.OK.value());
			http = HttpStatus.OK;
		}else {
			res.setData(null);
			res.setMessage("not found ");
			res.setStatus(HttpStatus.CONFLICT.value());
			http = HttpStatus.CONFLICT;
		}
		return new ResponseEntity<ListEntityStatusResponse>(res,http);
	}
	

}

