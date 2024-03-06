package com.javaweb.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Customer;
import com.javaweb.exception.UserException;
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
	
	@Override
	public Customer findCustomerById(Long customer_id) throws UserException{
		
		Optional<Customer> customer = customerRepo.findById(customer_id);
		
		if(customer.isPresent()) {
			return customer.get();
		}
		throw new UserException("Customer not found with id " + customer_id);
		
	}
}
