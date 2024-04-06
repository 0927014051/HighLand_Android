package com.javaweb.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.management.loading.PrivateClassLoader;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Customer;
import com.javaweb.entity.PriceUpdateDetail;
import com.javaweb.entity.Product;
import com.javaweb.entity.User;
import com.javaweb.exception.ProductException;
import com.javaweb.exception.UserException;
import com.javaweb.reponsitory.CartDetailRepo;
import com.javaweb.reponsitory.CartRepo;
import com.javaweb.request.AddItemRequest;
import com.javaweb.service.CartDetailService;
import com.javaweb.service.CartService;
import com.javaweb.service.PriceUpdateService;
import com.javaweb.service.ProductService;


import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class CartServiceImpl implements CartService {

	private CartRepo cartRepo;
	private CartDetailService cartDetailService;
	private ProductService productService;
	private PriceUpdateService priceUpdateService;
	private CartDetailRepo cartDetailRepo;


	public CartServiceImpl(CartRepo cartRepo, CartDetailService cartDetailService, ProductService productService,
			PriceUpdateService priceUpdateService, CartDetailRepo cartDetailRepo) {
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

	@SuppressWarnings("unused")
	@Override
	public String addCartItem(Long customer_id, AddItemRequest req) throws ProductException {
		Cart cart = cartRepo.findCartBCustomerId(customer_id);
		Product product = productService.findProductByName(req.getProduct_name());
		PriceUpdateDetail priceUpdateDetail = priceUpdateService.findPriceUpdateByProductId(product.getProduct_id());
		// CartDetail isPresent = cartDetailService.isCartDetailExist(cart,
		// product,customer_id );
		CartDetail isCheckCartDetail = cartDetailRepo.findCartDetailByCartIdAndProductIdWithToppingNull(cart.getCart_id(),
					product.getProduct_id(), req.getSize());
			int priceTopping = 0;
			if (isCheckCartDetail != null) {
				isCheckCartDetail.setQuantity(isCheckCartDetail.getQuantity() + 1);
				priceTopping = priceUpdateDetail.getPrice_new();
				isCheckCartDetail.setPrice(priceTopping);
				cartDetailRepo.save(isCheckCartDetail);
				int totalPrice = cartDetailRepo.totalPriceByCartId(cart.getCart_id());
				int totalQuantity = cartDetailRepo.totalQuantityByCartId(cart.getCart_id());
				cart.setTotal_price(totalPrice);
				cart.setTotal_quantity(totalQuantity);
				cartRepo.save(cart);
			} else {
				CartDetail cartDetail = new CartDetail();
				cartDetail.setCart(cart);
				cartDetail.setProduct(product);
				cartDetail.setCart_id(cart.getCart_id());
				cartDetail.setProduct_id(product.getProduct_id());
				int priceCartDetail = req.getQuantity() * priceUpdateDetail.getPrice_new();
				priceCartDetail = priceUpdateDetail.getPrice_new() ;
				cartDetail.setPrice(priceCartDetail);
				cartDetail.setSize(req.getSize());
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
		if (cart != null) {
			cart.getCart_detail().clear();
			cartRepo.save(cart);
		}
	}
	
	@Override
	public Cart findById(Long cart_id) throws UserException  {

		Optional<Cart> cart = cartRepo.findById(cart_id);

		if (cart.isPresent()) {
			return cart.get();
		}
		throw new UserException("Cart not found with id " + cart);

	}

}
