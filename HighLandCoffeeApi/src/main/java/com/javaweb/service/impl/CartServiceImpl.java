package com.javaweb.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Customer;
import com.javaweb.entity.User;
import com.javaweb.reponsitory.CartRepo;
import com.javaweb.service.CartDetailService;
import com.javaweb.service.CartService;
import com.javaweb.service.ProductService;

@Service
public class CartServiceImpl implements CartService{

	private CartRepo cartRepo;
	private CartDetailService cartDetailService;
	private ProductService productService;
	public CartServiceImpl(CartRepo cartRepo, CartDetailService cartDetailService, ProductService productService) {
		this.cartRepo = cartRepo;
		this.cartDetailService = cartDetailService;
		this.productService = productService;
	}
	
	@Override
	public Cart createCart(Cart cart) {
		return cartRepo.save(cart);
	}
	
	@Override
	public Cart findCartBCustomerId(Long customerId) {
		Cart cart = cartRepo.findCartBCustomerId(customerId);
		int totalPrice = 0;
		int totalQuantity = 0;
		for(CartDetail cartDetail : cart.getCart_detail()) {
			totalPrice += cartDetail.getPrice();
			totalQuantity += cartDetail.getQuantity();
		}
		cart.setTotal_price(totalPrice);
		cart.setTotal_quantity(totalQuantity);
		return cartRepo.save(cart);
		
	}
	
}
