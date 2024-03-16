package com.javaweb.service;

import com.javaweb.entity.Topping;

public interface ToppingService {

	public Topping findToppingByName(String id);
	
	public Topping createTopping(Topping topping);
}
