package com.javaweb.controller;

import com.javaweb.request.AvgReviewRequest;
import com.javaweb.response.EntityStatusResponse;
import com.javaweb.response.ListEntityStatusResponse;
import com.javaweb.request.ReviewProductRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.javaweb.entity.Customer;
import com.javaweb.entity.Review;
import com.javaweb.entity.User;
import com.javaweb.exception.UserException;
import com.javaweb.request.ReviewRequest;
import com.javaweb.service.CustomerService;
import com.javaweb.service.ReviewService;
import com.javaweb.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    private ReviewService reviewService;
    private UserService userService;
    private CustomerService customerService;



    public ReviewController(ReviewService reviewService, UserService userService, CustomerService customerService) {
        this.reviewService = reviewService;
        this.userService = userService;
        this.customerService = customerService;
    }



    @RequestMapping("/add")
    public ResponseEntity<EntityStatusResponse> createReviewCustomer(@RequestHeader("Authorization") String jwt, @RequestBody ReviewRequest rq) throws UserException{
        User user = userService.findUserByJwt(jwt);
        Customer customer = customerService.findCustomerByUserId(user.getUser_id());
        EntityStatusResponse res = new EntityStatusResponse();
        HttpStatus http = null;
        try {
            Review createReview = reviewService.createReview(rq, customer.getCustomer_id());
             res.setData(createReview);
             res.setMessage("success");
             res.setStatus(HttpStatus.CREATED.value());
            http = HttpStatus.CREATED;
        } catch (Exception e) {
            res.setData(null);
            res.setMessage(e.getMessage());
            res.setStatus(HttpStatus.CONFLICT.value());
            http = HttpStatus.CONFLICT;
        }
        return new ResponseEntity<>(res,http);

    }

    @GetMapping("/{product_id}/get")
    public ResponseEntity<ListEntityStatusResponse> getReviewProduct(@PathVariable("product_id") String product_id){
        ListEntityStatusResponse res = new ListEntityStatusResponse();
        List<ReviewProductRequest> rv = reviewService.findReviewByProductIdAndCustomer(product_id);
        res.setData(rv);
        res.setMessage("success");
        res.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ListEntityStatusResponse> getReviewProductAvg(@PathVariable("product_id") String product_id){
        ListEntityStatusResponse res = new ListEntityStatusResponse();
        List<AvgReviewRequest> rv = reviewService.findAverageStarAndCountByProductId(product_id);
        res.setData(rv);
        res.setMessage("success");
        res.setStatus(HttpStatus.OK.value());
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

}
