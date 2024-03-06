package com.javaweb.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Customer;
import com.javaweb.entity.Product;
import com.javaweb.entity.User;
import com.javaweb.exception.ProductException;
import com.javaweb.reponsitory.CartRepo;
import com.javaweb.request.AddItemRequest;
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
	
	@Override
	public String addCartItem(Long customer_id,AddItemRequest req) throws ProductException{
		Cart cart = cartRepo.findCartBCustomerId(customer_id);
		Product product = productService.findProductById(req.getProduct_id());
		CartDetail isPresent = cartDetailService.isCartDetailExist(cart, product,customer_id );
		
		if(isPresent == null) {
			CartDetail cartDetail = new CartDetail();
			cartDetail.setCart(cart);
			cartDetail.setProduct(product);
			cartDetail.setCart_id(cart.getCart_id());
			cartDetail.setProduct_id(req.getProduct_id());
			cartDetail.setQuantity(req.getQuantity());
			//int price = req.getQuantity()*product.getPrice();
			//cartDetail.setPrice(price);
			CartDetail createdCartDetail = cartDetailService.createCartDetail(cartDetail);
			cart.getCart_detail().add(createdCartDetail);
		}
		return "Item add to cart";
	}
	
	@Override
	public void clearCart(Long customer_id) {
		Cart cart = cartRepo.findCartBCustomerId(customer_id);
		if(cart != null) {
			cart.getCart_detail().clear();
			cartRepo.save(cart);
		}
	}
	
}
