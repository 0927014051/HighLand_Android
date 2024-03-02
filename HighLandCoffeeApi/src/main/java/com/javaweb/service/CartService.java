package com.javaweb.service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.Customer;
import com.javaweb.entity.User;


public interface CartService {
	
	public Cart createCart(Cart cart);
	
//	public String addCartItem(Long userId,AddItemRequest req) throws ProductException;
//	
	public Cart findCartBCustomerId(Long customerId);
//
//	public void clearCart(Long userId);
}
