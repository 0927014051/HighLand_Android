package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.CouponDetail;

@Repository
public interface CouponDetailRepo extends JpaRepository<CouponDetail,Long> {

    @Query(value = "SELECT * FROM CouponDetail WHERE coupon_id = ?1  ", nativeQuery = true)
    CouponDetail findCouponDetailByCouponId(Long id);


}
