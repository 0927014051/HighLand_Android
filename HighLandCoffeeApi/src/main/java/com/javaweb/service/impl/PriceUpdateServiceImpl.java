package com.javaweb.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.javaweb.entity.PriceUpdateDetail;
import com.javaweb.reponsitory.PriceUpdateRepo;
import com.javaweb.service.PriceUpdateService;

@Service
public class PriceUpdateServiceImpl implements PriceUpdateService{

	private PriceUpdateRepo priceUpdateRepo;

	public PriceUpdateServiceImpl(PriceUpdateRepo priceUpdateRepo) {
		super();
		this.priceUpdateRepo = priceUpdateRepo;
	}
	
	@Override
	public PriceUpdateDetail createPriceUpdate(String product_id, Long staff_id, int price_new) {
		PriceUpdateDetail priceUpdateDetail = new PriceUpdateDetail();
		priceUpdateDetail.setCreated_at(LocalDateTime.now());
		priceUpdateDetail.setCreated_by(staff_id);
		priceUpdateDetail.setPrice_new(price_new);
		priceUpdateDetail.setPrice_old(price_new);
		priceUpdateDetail.setProduct_id(priceUpdateDetail.getProduct_id());
		priceUpdateDetail.setUpdated_at(LocalDateTime.now());
		return priceUpdateRepo.save(priceUpdateDetail);
	}
}
