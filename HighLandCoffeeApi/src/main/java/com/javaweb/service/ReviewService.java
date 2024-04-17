package com.javaweb.service;

import com.javaweb.entity.Review;
import com.javaweb.request.ReviewRequest;

public interface ReviewService {

    Review createReview(ReviewRequest rq,Long staff_id);

}
