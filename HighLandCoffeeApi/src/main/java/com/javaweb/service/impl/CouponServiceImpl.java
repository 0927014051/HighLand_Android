package com.javaweb.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import com.javaweb.entity.Coupon;
import com.javaweb.entity.CouponDetail;
import com.javaweb.exception.ProductException;
import com.javaweb.reponsitory.CouponDetailRepo;
import com.javaweb.reponsitory.CouponRepo;
import com.javaweb.service.CouponService;

public class CouponServiceImpl implements CouponService{

    private CouponRepo couponRepo;
    private CouponDetailRepo couponDetailRepo;
    

    public CouponServiceImpl(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }

    @Override
    public Coupon createCoupon(Coupon coupon,Long staff_id) {
       Coupon createCoupon = new Coupon();
       createCoupon.setContent(coupon.getContent());
       createCoupon.setCreated_at(LocalDateTime.now());
       createCoupon.setCreated_by(staff_id);
       createCoupon.setEnd_date(coupon.getEnd_date());
       createCoupon.setMinimum_value(coupon.getMinimum_value());
       createCoupon.setQuantity(coupon.getQuantity());
       createCoupon.setRemaining_amount(coupon.getRemaining_amount());
       createCoupon.setStart_date(coupon.getStart_date());
       createCoupon.setStatus(coupon.getStatus());
       createCoupon.setType(coupon.getType());
       createCoupon.setUpdated_at(coupon.getUpdated_at());
       createCoupon.setUpdated_by(staff_id);
       Coupon savedCoupon = couponRepo.save(createCoupon);
       if(savedCoupon != null) {
        CouponDetail couponDetail = new CouponDetail();
        couponDetail.setStatus(coupon.getStatus());
        CouponDetail saveDetail = couponDetailRepo.save(couponDetail);
        if(saveDetail != null){
            System.err.println("Them thanh cong");
        }
       }
       return savedCoupon;
    }

    @Override
    public Coupon updateStatus(Long id, Coupon coupon) throws ProductException {
       Coupon findCoupon = findById(id);
       findCoupon.setStatus(coupon.getStatus());
       return couponRepo.save(findCoupon);
    }

    @Override
    public Coupon findById(Long id) throws ProductException{
        Optional<Coupon> coupon = couponRepo.findById(id);
        if(coupon.isPresent()){
            return coupon.get();
        }
        throw new ProductException("Coupon not found with id " + id);

    }

}
