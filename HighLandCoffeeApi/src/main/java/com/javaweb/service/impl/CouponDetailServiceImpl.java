package com.javaweb.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.javaweb.entity.CouponDetail;
import com.javaweb.reponsitory.CouponDetailRepo;
import com.javaweb.service.CouponDetailService;

@Service
public class CouponDetailServiceImpl implements CouponDetailService{

    private CouponDetailRepo couponDetailRepo;

    

    public CouponDetailServiceImpl(CouponDetailRepo couponDetailRepo) {
        this.couponDetailRepo = couponDetailRepo;
    }

    @Override
    public CouponDetail customerGetCoupon(Long customer_id,Long coupon_id) {
       CouponDetail detail = findCouponDetailByCouponId(coupon_id);
       detail.setCoupon_id(customer_id);
       return couponDetailRepo.save(detail);
    }

    @Override
    public CouponDetail findCouponDetailByCouponId(Long id) {
        return couponDetailRepo.findCouponDetailByCouponId(id);
    }

}
