package com.javaweb.service.impl;

import java.time.LocalDateTime;

import javax.management.loading.PrivateClassLoader;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Customer;
import com.javaweb.entity.PriceUpdateDetail;
import com.javaweb.entity.Product;
import com.javaweb.entity.Topping;
import com.javaweb.entity.Topping_Category;
import com.javaweb.entity.User;
import com.javaweb.exception.ProductException;
import com.javaweb.reponsitory.CartDetailRepo;
import com.javaweb.reponsitory.CartRepo;
import com.javaweb.request.AddItemRequest;
import com.javaweb.service.CartDetailService;
import com.javaweb.service.CartService;
import com.javaweb.service.PriceUpdateService;
import com.javaweb.service.ProductService;
import com.javaweb.service.ToppingCategoryService;
import com.javaweb.service.ToppingService;

import ch.qos.logback.core.joran.conditional.IfAction;

@Service
public class CartServiceImpl implements CartService {

	private CartRepo cartRepo;
	private CartDetailService cartDetailService;
	private ProductService productService;
	private PriceUpdateService priceUpdateService;
	private CartDetailRepo cartDetailRepo;
	private ToppingService toppingService;
	private ToppingCategoryService toppingCategoryService;

	public CartServiceImpl(CartRepo cartRepo, CartDetailService cartDetailService, ProductService productService,
			PriceUpdateService priceUpdateService, CartDetailRepo cartDetailRepo, ToppingService toppingService,
			ToppingCategoryService toppingCategoryService) {
		this.cartRepo = cartRepo;
		this.cartDetailService = cartDetailService;
		this.productService = productService;
		this.priceUpdateService = priceUpdateService;
		this.cartDetailRepo = cartDetailRepo;
		this.toppingService = toppingService;
		this.toppingCategoryService = toppingCategoryService;
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
		Product product = productService.findProductById(req.getProduct_id());
		// CartDetail isPresent = cartDetailService.isCartDetailExist(cart,
		// product,customer_id );
		PriceUpdateDetail priceUpdateDetail = priceUpdateService.findPriceUpdateByProductId(req.getProduct_id());
		CartDetail isCheckCartDetail = cartDetailRepo.findCartDetailByCartIdAndProductId(cart.getCart_id(),
				req.getProduct_id(), req.getSize(), req.getTopping());
		Topping topping = toppingService.findToppingByName(req.getTopping());
		Topping_Category topping_Category = toppingCategoryService.findToppingCategoryById(product.getCategory_id(),
				topping.getTopping_id());
		System.err.println(topping_Category.getTopping_price());
		System.err.println(isCheckCartDetail.getPrice());

		int priceTopping = 0;
		if (isCheckCartDetail != null) {
			isCheckCartDetail.setQuantity(isCheckCartDetail.getQuantity() + 1);
			if (topping != null) {
				priceTopping = priceUpdateDetail.getPrice_new() + topping_Category.getTopping_price();
			} else {
				priceTopping = priceUpdateDetail.getPrice_new();
			}
			isCheckCartDetail.setPrice(priceTopping);
			System.err.println(isCheckCartDetail.getPrice());
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
			cartDetail.setProduct_id(req.getProduct_id());
			int priceCartDetail = req.getQuantity() * priceUpdateDetail.getPrice_new();
			if (topping != null) {
				priceCartDetail = priceUpdateDetail.getPrice_new() + topping_Category.getTopping_price();
			} else {
				priceCartDetail = priceUpdateDetail.getPrice_new();
			}
			cartDetail.setPrice(priceCartDetail);
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
		if (cart != null) {
			cart.getCart_detail().clear();
			cartRepo.save(cart);
		}
	}

}
