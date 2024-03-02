package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Customer;
import com.javaweb.entity.OrderDetail;
import com.javaweb.entity.Orders;
import com.javaweb.reponsitory.OrderRepo;
import com.javaweb.service.CartService;
import com.javaweb.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService{
	
//	private OrderRepo orderRepo;
//	private CartService cartService;
//	@Autowired
//	public OrderServiceimpl(OrderRepo orderRepo, CartService cartService) {
//		this.orderRepo = orderRepo;
//		this.cartService = cartService;
//	}
//	
//	@Override
//	public Orders createOrder(Customer customer) {
//		Cart cart = cartService.findCartBCustomerId(customer.getCustomer_id());
//		List<OrderDetail> orderDetails = new ArrayList<>();
//		for(CartDetail detail : cart.getCart_detail()) {
//			OrderDetail orderDetail = new OrderDetail();
//			orderDetail.setPrice(detail.getPrice());
//			orderDetail.setQuantity(detail.getQuantity());
//			orderDetail.setProduct_id(detail.getProduct_id());
//			
//		}
//		return orderRepo.save(order);
//	}
//	

}
