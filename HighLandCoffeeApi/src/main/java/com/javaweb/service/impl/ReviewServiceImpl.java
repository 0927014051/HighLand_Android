package com.javaweb.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import com.javaweb.entity.OrderDetail;
import com.javaweb.entity.Review;
import com.javaweb.reponsitory.ReviewRepo;
import com.javaweb.request.ReviewRequest;
import com.javaweb.service.OrderDetailService;
import com.javaweb.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

    private OrderDetailService orderDetailService;
    private ReviewRepo reviewRepo;

    

    public ReviewServiceImpl(OrderDetailService orderDetailService, ReviewRepo reviewRepo) {
        this.orderDetailService = orderDetailService;
        this.reviewRepo = reviewRepo;
    }



    @Override
    @Transactional
    public Review createReview(ReviewRequest rq, Long staff_id) {
        List<OrderDetail> od = new ArrayList<>();
        Review rv = new Review();
        Review savedReview = new Review();
        if (rq.getOrder_id() != null && !rq.getProduct_id().equals("")) {
            od = orderDetailService.findOrderDetailByOrderIdAndProductId(rq.getOrder_id(), rq.getProduct_id());
        }
        if (od != null) {
            for(OrderDetail detail : od){
            if (!rq.getContent().equals("")) {
                rv.setContent(rq.getContent());
            }
            if (rq.getStar() != 0) {
                rv.setStar(rq.getStar());
            }
            rv.setOrder_detail_id(detail.getOrder_detail_id());
            rv.setCreated_at(LocalDateTime.now());
            rv.setCreated_by(staff_id);
            rv.setProduct_id(rq.getProduct_id());
            rv.setStatus("Active");
            rv.setUpdated_at(LocalDateTime.now());
        }
        savedReview = reviewRepo.save(rv);
    }
        return savedReview;
    }

}
