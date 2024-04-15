package com.javaweb.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.javaweb.entity.Customer;
import com.javaweb.entity.Orders;
import com.javaweb.entity.User;
import com.javaweb.exception.OrdersException;
import com.javaweb.exception.ProductException;
import com.javaweb.request.BuyNowRequest;
import com.javaweb.request.ProductSaleRequest;
import com.javaweb.request.StatisticRequest;


public interface OrderService {

	public Orders createOrder(Customer customer);
	
	public Orders updateStatusOrder(Long orderId,int status,Long staff_id) throws ProductException;
	
	public Orders findOrderByOrderId(Long orderId) throws ProductException;
	
	public Orders orderBuyNow(BuyNowRequest rq,Long customer_id);
	
    public List<StatisticRequest> getTotalAmountByMonth(int year);
    
    public List<ProductSaleRequest> getTotalAmountByDate(Date start, Date end);
    
    public List<Orders> getAllOrders();
    
	public List<Orders> findOrderByCustomerId(Long customer_id);


	List<Orders> findOrderByStatus(String status);
	List<Orders> findOrderByDate(LocalDate dateStart, LocalDate dateEnd);
//	public Orders findOrdersById(Long orderId) throws OrdersException;
//	
//	public List<Orders> usersOrdersHistory(Long userId);
//	
//	public Orders placedOrders(Long orderId) throws OrdersException;
//	
//	public Orders confirmedOrders(Long orderId)throws OrdersException;
//	
//	public Orders shippedOrders(Long orderId) throws OrdersException;
	
//	public Orders deliveredOrders(Long orderId) throws OrdersException;
//	
//	public Orders cancledOrders(Long orderId) throws OrdersException;
//	
//	public List<Orders>getAllOrderss();
//	
//	public Orders deleteOrders(Long orderId) throws OrdersException;
//
//	public Orders updateOrders (Long orderId) throws OrdersException;
//	public Orders successOrders (Long orderId) throws OrdersException;
}
