package com.javaweb.service;

import com.javaweb.entity.CouponDetail;

public interface CouponDetailService {

    CouponDetail customerGetCoupon(Long customer_id, Long coupon_id);

    CouponDetail findCouponDetailByCouponId(Long id);
    
} 
