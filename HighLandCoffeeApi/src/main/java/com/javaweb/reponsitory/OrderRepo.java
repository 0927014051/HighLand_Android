package com.javaweb.reponsitory;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Orders;
import com.javaweb.request.ProductSaleRequest;

@Repository
public interface OrderRepo extends JpaRepository<Orders, Long>{
	@Query("SELECT MONTH(o.create_at) AS month, SUM(o.total_price) AS totalAmount " +
	           "FROM Orders o " +
	           "WHERE YEAR(o.create_at) = :year AND o.status = 3 " +
	           "GROUP BY MONTH(o.create_at)")
	    List<Object[]> getTotalAmountByMonth(int year);
	    @Query("SELECT " +
	            "    p.product_id AS product_id, " +
	            "    p.product_name AS product_name, " +
	            "    SUM(od.quantity * od.price) AS total_sold,  " +
	            "	 SUM(od.quantity) AS total_quantity	 " +
	            "FROM " +
	            "    Product p " +
	            "JOIN " +
	            "    OrderDetail od ON p.product_id = od.product.product_id " +
	            "JOIN " +
	            "    Orders o ON od.order.order_id = o.order_id AND o.status = 3 " +
	            "WHERE " +
	            "    DATE(o.create_at) >= DATE(:startDate) " +
	            "    AND DATE(o.update_at) <= DATE(:endDate) " +
	            "GROUP BY " +
	            "    p.product_id, p.product_name " +
	            "ORDER BY " +
	            "    total_sold DESC")
	    List<Object[]> getTotalAmountByDate(Date startDate, Date endDate);
}
