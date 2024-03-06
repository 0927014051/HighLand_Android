package com.javaweb.service;

import com.javaweb.entity.Customer;
import com.javaweb.exception.UserException;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	
	public Customer findCustomerByUserId(Long user_id);
	
	public Customer findCustomerByEmail(String email);
	
	public Customer findCustomerById(Long customer_id) throws UserException;
}
