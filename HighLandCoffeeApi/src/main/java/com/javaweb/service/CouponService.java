package com.javaweb.service;

import com.javaweb.entity.Coupon;
import com.javaweb.exception.ProductException;

public interface CouponService {

    public Coupon createCoupon(Coupon coupon,Long staff_id);

    public Coupon updateStatus(Long id, Coupon coupon) throws ProductException;

    public Coupon findById(Long id) throws ProductException;

}
