package com.javaweb.service;

import com.javaweb.entity.Customer;

public interface CustomerService {

	public Customer createCustomer(Customer customer);
	
	public Customer findCustomerByUserId(Long user_id);
	
	public Customer findCustomerByEmail(String email);
}
