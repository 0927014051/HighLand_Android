package com.javaweb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.entity.CouponDetail;
import com.javaweb.entity.Customer;
import com.javaweb.entity.User;
import com.javaweb.exception.UserException;
import com.javaweb.response.ApiResponse;
import com.javaweb.service.CouponDetailService;
import com.javaweb.service.CustomerService;
import com.javaweb.service.StaffService;
import com.javaweb.service.UserService;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    private CouponDetailService couponDetailService;
    private UserService userService;
    private CustomerService customerService;


    @RequestMapping("/get")
    public ResponseEntity<ApiResponse> getCouponByCustomer(@RequestHeader("Authorization") String jwt,@RequestParam("coupon_id") Long coupon_id) throws UserException{
        ApiResponse res = new ApiResponse();
        HttpStatus http = null;
        User user = userService.findUserByJwt(jwt);
        Customer customer = customerService.findCustomerByUserId(user.getUser_id());
        CouponDetail couponDetail = couponDetailService.customerGetCoupon(customer.getCustomer_id(),coupon_id);
        if(couponDetail != null){
            res.setCode(HttpStatus.OK.value());
            res.setMessage("get success");
            res.setStatus(true);
            http = HttpStatus.OK;
        }else{
            res.setCode(HttpStatus.CONFLICT.value());
            res.setMessage("get fail");
            res.setStatus(false);
            http = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(res,http);
    }
}
