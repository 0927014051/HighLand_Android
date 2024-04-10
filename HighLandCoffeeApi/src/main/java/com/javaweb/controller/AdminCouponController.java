package com.javaweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.Coupon;
import com.javaweb.entity.Staff;
import com.javaweb.entity.User;
import com.javaweb.exception.ProductException;
import com.javaweb.exception.UserException;
import com.javaweb.response.ApiResponse;
import com.javaweb.service.CouponService;
import com.javaweb.service.StaffService;
import com.javaweb.service.UserService;

@RestController
@RequestMapping("/admin/coupon")
public class AdminCouponController {

    private CouponService couponService;
    private UserService userService;
    private StaffService staffService;

    public AdminCouponController(CouponService couponService,UserService userService, StaffService staffService) {
        this.couponService = couponService;
        this.userService = userService;
        this.staffService = staffService;
    }


    @RequestMapping("/add")
    public ResponseEntity<ApiResponse> createReponHanlder( @RequestHeader("Authorization") String jwt, @RequestBody Coupon coupon) throws UserException{
        User user = userService.findUserByJwt(jwt);
        Staff staff = staffService.findStaffByUserId(user.getUser_id());
        ApiResponse res = new ApiResponse();
        HttpStatus http= null;
        Coupon addCoupon = couponService.createCoupon(coupon, staff.getStaff_id());
        if( addCoupon != null){
            res.setCode(HttpStatus.CREATED.value());
            res.setMessage("success");
            res.setStatus(true);
            http = HttpStatus.CREATED;
        }else{
            res.setCode(HttpStatus.CONFLICT.value());
            res.setMessage("fail");
            res.setStatus(false);
            http = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(res,http);      
    }

    @RequestMapping("/{coupon_id}/status")
    public ResponseEntity<ApiResponse> updateStatusCoupon(@RequestHeader("Authorization") String jwt, @RequestBody Coupon coupon, @PathVariable Long id) throws UserException, ProductException{
        User user = userService.findUserByJwt(jwt);
        Staff staff = staffService.findStaffByUserId(user.getUser_id());
        Coupon updateCoupon = couponService.updateStatus(id, coupon);
        ApiResponse res = new ApiResponse();
        HttpStatus http = null;
        if(updateCoupon != null){
            res.setCode(HttpStatus.OK.value());
            res.setMessage("success");
            res.setStatus(true);
            http = HttpStatus.OK;
        }else{
            res.setCode(HttpStatus.CONFLICT.value());
            res.setMessage("fail");
            res.setStatus(false);
            http = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(res,http);
    }
    
}
