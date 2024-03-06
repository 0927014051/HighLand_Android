package com.javaweb.service;

import com.javaweb.entity.PriceUpdateDetail;

public interface PriceUpdateService {
	
	PriceUpdateDetail createPriceUpdate(String product_id,Long staff_id,int price_new);

}
