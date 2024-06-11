package com.javaweb.service;

import com.javaweb.entity.Review;
import com.javaweb.exception.ProductException;
import com.javaweb.exception.UserException;
import com.javaweb.request.AvgReviewRequest;
import com.javaweb.request.ReviewRequest;
import com.javaweb.request.ReviewProductRequest;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewService {

    Review createReview(ReviewRequest rq,Long customer_id) throws ProductException, UserException;

    List<ReviewProductRequest> findReviewByProductIdAndCustomer(@Param("product_id") String productId);

    List<AvgReviewRequest> findAverageStarAndCountByProductId(@Param("productId") String productId);

}
