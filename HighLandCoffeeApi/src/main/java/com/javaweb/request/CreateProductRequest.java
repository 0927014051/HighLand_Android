package com.javaweb.request;

import java.time.LocalDateTime;

public class CreateProductRequest {

	private String product_id;
	private String product_name;
	private String image;
	private int price;
	private int quantity;
	private String description;
	private int status;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private Long category_id;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
	public CreateProductRequest(String product_id, String product_name, String image, int price, int quantity,
			String description, int status, LocalDateTime created_at, LocalDateTime updated_at, Long category_id) {
		super();
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
	}
	public CreateProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
