package com.javaweb.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column
	private String product_id; 
	
	@Column(length = 50)
	private String product_name;
	
	@Column
	private String image;
	
	@Column
	private int price;
	
	@Column
	private int quantity;
	
	@Column(length = 500)
	private String description;
	
	@Column
	private int status;
	
	@Column(name = "created_at")
	private LocalDateTime created_at;
	
	@Column(name = "updated_at")
	private LocalDateTime updated_at;
	
	@Column
	private Long category_id;
	
	@OneToMany(mappedBy = "product")
	private List<CartDetail> cart_detail;
	
	@OneToMany(mappedBy = "product")
	private List<OrderDetail> order_detail;
	
	@OneToMany(mappedBy = "product")
	private List<PriceUpdateDetail> price_update_detail;
	
	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<Review> review;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public Long getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}

	public List<CartDetail> getCart_detail() {
		return cart_detail;
	}

	public void setCart_detail(List<CartDetail> cart_detail) {
		this.cart_detail = cart_detail;
	}

	public List<OrderDetail> getOrder_detail() {
		return order_detail;
	}

	public void setOrder_detail(List<OrderDetail> order_detail) {
		this.order_detail = order_detail;
	}

	public List<PriceUpdateDetail> getPrice_update_detail() {
		return price_update_detail;
	}

	public void setPrice_update_detail(List<PriceUpdateDetail> price_update_detail) {
		this.price_update_detail = price_update_detail;
	}

	@JsonBackReference(value="user-movement")
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Review> getReview() {
		return review;
	}
	

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	
	

	public Product(String product_id, String product_name, String image, int price, int quantity, String description,
			int status, LocalDateTime created_at, LocalDateTime updated_at, Long category_id,
			List<CartDetail> cart_detail, List<OrderDetail> order_detail, List<PriceUpdateDetail> price_update_detail,
			Category category, List<Review> review) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.image = image;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
		this.status = status;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.category_id = category_id;
		this.cart_detail = cart_detail;
		this.order_detail = order_detail;
		this.price_update_detail = price_update_detail;
		this.category = category;
		this.review = review;
	}

	public Product() {
		
	}
	
	

}
