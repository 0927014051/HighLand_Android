package com.javaweb.service.impl;

import java.time.LocalDateTime;

import javax.management.loading.PrivateClassLoader;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Customer;
import com.javaweb.entity.PriceUpdateDetail;
import com.javaweb.entity.Product;
import com.javaweb.entity.User;
import com.javaweb.exception.ProductException;
import com.javaweb.reponsitory.CartDetailRepo;
import com.javaweb.reponsitory.CartRepo;
import com.javaweb.request.AddItemRequest;
import com.javaweb.service.CartDetailService;
import com.javaweb.service.CartService;
import com.javaweb.service.PriceUpdateService;
import com.javaweb.service.ProductService;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class CartServiceImpl implements CartService{

	private CartRepo cartRepo;
	private CartDetailService cartDetailService;
	private ProductService productService;
	private PriceUpdateService priceUpdateService;
	private CartDetailRepo cartDetailRepo;
	public CartServiceImpl(CartRepo cartRepo, CartDetailService cartDetailService, ProductService productService,PriceUpdateService priceUpdateService,CartDetailRepo cartDetailRepo) {
		this.cartRepo = cartRepo;
		this.cartDetailService = cartDetailService;
		this.productService = productService;
		this.priceUpdateService = priceUpdateService;
		this.cartDetailRepo = cartDetailRepo;
	}
	
	@Override
	public Cart createCart(Cart cart) {
		return cartRepo.save(cart);
	}
	
	@Override
	public Cart findCartBCustomerId(Long customerId) {
		return cartRepo.findCartBCustomerId(customerId);	
	}
	
	@Override
	public String addCartItem(Long customer_id,AddItemRequest req) throws ProductException{
		Cart cart = cartRepo.findCartBCustomerId(customer_id);
		Product product = productService.findProductById(req.getProduct_id());
		//CartDetail isPresent = cartDetailService.isCartDetailExist(cart, product,customer_id );
		PriceUpdateDetail priceUpdateDetail = priceUpdateService.findPriceUpdateByProductId(req.getProduct_id());
		CartDetail isCheckCartDetail = cartDetailRepo.findCartDetailByCartIdAndProductId(cart.getCart_id(),req.getProduct_id(),req.getSize(),req.getTopping());
		if(isCheckCartDetail != null) {
			isCheckCartDetail.setQuantity(isCheckCartDetail.getQuantity()+1);
			int price = priceUpdateDetail.getPrice_new();
			isCheckCartDetail.setPrice(price);
			cartDetailRepo.save(isCheckCartDetail);
			int totalPrice = cartDetailRepo.totalPriceByCartId(cart.getCart_id());
			int totalQuantity = cartDetailRepo.totalQuantityByCartId(cart.getCart_id());
			cart.setTotal_price(totalPrice);
			cart.setTotal_quantity(totalQuantity);
			cartRepo.save(cart);
		}else {
			CartDetail cartDetail = new CartDetail();
			cartDetail.setCart(cart);
			cartDetail.setProduct(product);
			cartDetail.setCart_id(cart.getCart_id());
			cartDetail.setProduct_id(req.getProduct_id());
			int price = req.getQuantity()*priceUpdateDetail.getPrice_new();
			cartDetail.setPrice(price);
			cartDetail.setSize(req.getSize());
			cartDetail.setTopping(req.getTopping());
			CartDetail createdCartDetail = cartDetailService.createCartDetail(cartDetail);
			cart.getCart_detail().add(createdCartDetail);
			int totalPrice = cartDetailRepo.totalPriceByCartId(cart.getCart_id());
			int totalQuantity = cartDetailRepo.totalQuantityByCartId(cart.getCart_id());
			cart.setTotal_price(totalPrice);
			cart.setTotal_quantity(totalQuantity);
			cartRepo.save(cart);
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
