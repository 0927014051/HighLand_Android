package com.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name =  "cart_detail")
public class CartDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long cart_detail_id;
	
	@Column
	private int quantity;
	
	@Column
	private int price;
	
	@Column
	private String product_id;
	
	@Column
	private Long cart_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name =  "product_id",updatable =  false, insertable =  false)
	private Product product;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "cart_id", insertable = false, updatable = false)
	private Cart cart;

	public Long getCart_detail_id() {
		return cart_detail_id;
	}

	public void setCart_detail_id(Long cart_detail_id) {
		this.cart_detail_id = cart_detail_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Long getCart_id() {
		return cart_id;
	}

	public void setCart_id(Long cart_id) {
		this.cart_id = cart_id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public CartDetail(Long cart_detail_id, int quantity, int price, String product_id, Long cart_id,
			com.javaweb.entity.Product product, com.javaweb.entity.Cart cart) {
		super();
		this.cart_detail_id = cart_detail_id;
		this.quantity = quantity;
		this.price = price;
		this.product_id = product_id;
		this.cart_id = cart_id;
		this.product = product;
		this.cart = cart;
	}
	
	

}
