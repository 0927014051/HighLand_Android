package com.javaweb.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long review_id;
	
	@Column
	private Date date;
	
	@Column
	private int star;
	
	@Column
	private String content;
	
	@Column
	private LocalDateTime created_at;
	
	@Column
	private LocalDateTime updated_at;
	
	@Column
	private Long order_detail_id;
	
	@Column
	private String product_id;
	
	@Column
	private Long customer_id;
	
	@OneToOne
	@JoinColumn(name = "order_detail_id",insertable = false,updatable = false)
	private OrderDetail order_detail;
	
	@ManyToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", insertable = false, updatable = false)
	private Customer customer;

	public Long getReview_id() {
		return review_id;
	}

	public void setReview_id(Long review_id) {
		this.review_id = review_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public Long getOrder_detail_id() {
		return order_detail_id;
	}

	public void setOrder_detail_id(Long order_detail_id) {
		this.order_detail_id = order_detail_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public OrderDetail getOrder_detail() {
		return order_detail;
	}

	public void setOrder_detail(OrderDetail order_detail) {
		this.order_detail = order_detail;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Review(Long review_id, Date date, int star, String content, LocalDateTime created_at, LocalDateTime updated_at,
			Long order_detail_id, String product_id, Long customer_id, com.javaweb.entity.OrderDetail order_detail,
			com.javaweb.entity.Product product, com.javaweb.entity.Customer customer) {
		super();
		this.review_id = review_id;
		this.date = date;
		this.star = star;
		this.content = content;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.order_detail_id = order_detail_id;
		this.product_id = product_id;
		this.customer_id = customer_id;
		this.order_detail = order_detail;
		this.product = product;
		this.customer = customer;
	}
	
	

}
