package com.javaweb.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaweb.entity.Cart;
import com.javaweb.entity.CartDetail;
import com.javaweb.entity.Product;

@Repository
public interface CartDetailRepo extends JpaRepository<CartDetail, Long>{
	@Query("SELECT ci From CartDetail ci Where ci.cart=:cart And ci.product=:product And ci.cart.customer_id=:customerId")
	public CartDetail isCartItemExist(@Param("cart")Cart cart,@Param("product")Product product, @Param("customerId")Long customerId);

}
