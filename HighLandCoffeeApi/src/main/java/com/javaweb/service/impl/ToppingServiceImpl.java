package com.javaweb.service.impl;

import org.springframework.stereotype.Service;

import com.javaweb.entity.Topping;
import com.javaweb.reponsitory.ToppingRepo;
import com.javaweb.service.ToppingService;

@Service
public class ToppingServiceImpl implements ToppingService{
	private ToppingRepo toppingRepo;

	public ToppingServiceImpl(ToppingRepo toppingRepo) {
		super();
		this.toppingRepo = toppingRepo;
	}
	
	@Override
	public Topping findToppingByName(String name) {
		Topping findTopping = toppingRepo.findToppingByName(name);
		return findTopping;
	}
	
	@Override
	public Topping createTopping(Topping topping) {
		return toppingRepo.save(topping);
	}

}
