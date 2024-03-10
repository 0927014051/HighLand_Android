package com.javaweb.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Customer;
import com.javaweb.entity.OrderDetail;
import com.javaweb.entity.Orders;
import com.javaweb.entity.Product;
import com.javaweb.reponsitory.CartRepo;
import com.javaweb.reponsitory.OrderDetailRepo;
import com.javaweb.reponsitory.OrderRepo;
import com.javaweb.service.CartDetailService;
import com.javaweb.service.CartService;
import com.javaweb.service.OrderDetailService;
import com.javaweb.service.OrderService;

@Service
public class OrderServiceimpl implements OrderService {

	private OrderRepo orderRepo;
	private CartService cartService;
	private CartDetailService cartDetailService;
	private OrderDetailService orderDetailService;
	private OrderDetailRepo orderDetailRepo;
	private CartRepo cartRepo;

	@Autowired
	public OrderServiceimpl(OrderRepo orderRepo, CartService cartService, CartDetailService cartDetailService,
			OrderDetailService orderDetailService, OrderDetailRepo orderDetailRepo, CartRepo cartRepo) {
		this.orderRepo = orderRepo;
		this.cartService = cartService;
		this.cartDetailService = cartDetailService;
		this.orderDetailService = orderDetailService;
		this.orderDetailRepo = orderDetailRepo;
		this.cartRepo = cartRepo;
	}

	@Override
	@Transactional
	public Orders createOrder(Customer customer) {
		Cart cart = cartService.findCartBCustomerId(customer.getCustomer_id());
		List<OrderDetail> list = new ArrayList<>();

//			Orders orders = new Orders();
//			orders.setCreate_at(LocalDateTime.now());
//			orders.setUpdate_at(LocalDateTime.now());
//			orders.setCustomer_id(customer.getCustomer_id());
//			orders.setStatus(0);
//			orders.setTotal_price(0);
//			orders.setTotal_quantity(0);
//			Orders createdOrders = orderRepo.save(orders);
		int totalPrice = 0;
		int totalQuantity = 0;
		for (CartDetail detail : cart.getCart_detail()) {
			OrderDetail orderDetail = new OrderDetail();
			// orderDetail.setOder_id(createdOrders.getOrder_id());
			orderDetail.setPrice(detail.getPrice());
			orderDetail.setProduct_id(detail.getProduct_id());
			orderDetail.setQuantity(detail.getQuantity());
			orderDetail.setSize(detail.getSize());
			orderDetail.setTopping(detail.getTopping());
			OrderDetail createDetail = orderDetailRepo.save(orderDetail);
			totalQuantity += createDetail.getQuantity();
			totalPrice += (createDetail.getQuantity() * createDetail.getPrice());
			list.add(createDetail);
		}
		Orders orders = new Orders();
		orders.setCreate_at(LocalDateTime.now());
		orders.setUpdate_at(LocalDateTime.now());
		orders.setCustomer_id(customer.getCustomer_id());
		orders.setCustomer(customer);
		orders.setStatus(0);
		orders.setTotal_price(totalPrice);
		orders.setTotal_quantity(totalQuantity);
		Orders createdOrders = orderRepo.save(orders);
		for (OrderDetail item : list) {
			item.setOrder_id(createdOrders.getOrder_id());
			orderDetailRepo.save(item);
		}
		cartDetailService.deleteCartDetail(cart.getCart_id());
		cart.setTotal_price(0);
		cart.setTotal_quantity(0);
		cartRepo.save(cart);
		return createdOrders;

	}

}
