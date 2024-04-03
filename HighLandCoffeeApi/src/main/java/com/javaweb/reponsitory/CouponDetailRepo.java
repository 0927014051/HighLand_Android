package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.CouponDetail;

@Repository
public interface CouponDetailRepo extends JpaRepository<CouponDetail,Long> {


}
