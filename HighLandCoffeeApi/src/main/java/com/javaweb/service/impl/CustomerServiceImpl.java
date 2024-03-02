package com.javaweb.service.impl;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Customer;
import com.javaweb.reponsitory.CustomerRepo;
import com.javaweb.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	private CustomerRepo customerRepo;
	
	public CustomerServiceImpl(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	@Override
	public Customer createCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	@Override
	public Customer findCustomerByUserId(Long user_id) {
		return customerRepo.findCustomerByUserid(user_id);
	}
	
	@Override
	public Customer findCustomerByEmail(String email) {
		return customerRepo.findCustomerByEmail(email);
	}
	
}
