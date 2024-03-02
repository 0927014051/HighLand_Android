package com.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "order_detail")
public class OrderDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long order_detail_id;
	
	@Column
	private int quantity;
	
	@Column
	private int price;
	
	@Column
	private Long oder_id;

	@Column
	private String product_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "order_id",insertable = false, updatable = false)
	private Orders order;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id",insertable = false, updatable = false)
	private Product product;
	
	@OneToOne(mappedBy = "order_detail")
	@JsonBackReference
	private Review review;

	public Long getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(Long order_detail_id) {
		this.order_detail_id = order_detail_id;
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

	public Long getOder_id() {
		return oder_id;
	}

	public void setOder_id(Long oder_id) {
		this.oder_id = oder_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

	public OrderDetail(Long order_detail_id, int quantity, int price, Long oder_id, String product_id,
			com.javaweb.entity.Orders order, com.javaweb.entity.Product product, com.javaweb.entity.Review review) {
		super();
		this.order_detail_id = order_detail_id;
		this.quantity = quantity;
		this.price = price;
		this.oder_id = oder_id;
		this.product_id = product_id;
		this.order = order;
		this.product = product;
		this.review = review;
	}

	public OrderDetail() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	
	}
