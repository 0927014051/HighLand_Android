package com.javaweb.service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Product;
import com.javaweb.exception.CartDetailException;
import com.javaweb.exception.UserException;

public interface CartDetailService {
public CartDetail createCartDetail(CartDetail cartItem);
	
	public CartDetail updateCartDetail(Long userId, Long id,CartDetail cartItem) throws CartDetailException, UserException;
	
	public CartDetail isCartDetailExist(Cart cart,Product product, Long userId);
	
	public void removeCartDetail(Long userId,Long cartItemId) throws CartDetailException, UserException;
	
	public CartDetail findCartDetailById(Long cartItemId) throws CartDetailException;
}
