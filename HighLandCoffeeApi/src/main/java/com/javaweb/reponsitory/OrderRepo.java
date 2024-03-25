package com.javaweb.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Orders;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long>{
	@Query("SELECT MONTH(o.create_at) AS month, SUM(o.total_price) AS totalAmount " +
	           "FROM Orders o " +
	           "WHERE YEAR(o.create_at) = :year AND o.status = 3 " +
	           "GROUP BY MONTH(o.create_at)")
	    List<Object[]> getTotalAmountByMonth(int year);
}
