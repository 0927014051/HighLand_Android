package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.OrderDetail;
import com.javaweb.entity.Review;

import java.util.List;

@Repository
public interface ReviewRepo extends JpaRepository<Review,Long>{
    @Query(value = "SELECT r.product_id AS product_id, " +
            "AVG(r.star) AS star, " +
            "r.content AS content, " +
            "CONCAT(c.firstname, ' ', c.lastname) AS customer_name, " +
            "r.created_at AS date " +
            "FROM review r " +
            "JOIN customer c ON r.created_by = c.customer_id " +
            "WHERE r.product_id = :productId " +
            "GROUP BY r.product_id, customer_name, content, product_id, date " +
            "ORDER BY r.product_id DESC",
            nativeQuery = true)
    List<Object[]> findReviewByProductIdAndCustomer(@Param("productId") String productId);

    @Query(value = "SELECT AVG(r.star), COUNT(r.product_id) " +
            "FROM review r " +
            "WHERE r.product_id = :productId " +
            "GROUP BY r.product_id " +
            "ORDER BY r.product_id DESC",
            nativeQuery = true)
    List<Object[]> findAverageStarAndCountByProductId(@Param("productId") String productId);

    @Query(value = "SELECT r.product_id ,Avg(star) FROM review r group by r.product_id",nativeQuery = true)
    List<Object[]> findAverageStar();

}
