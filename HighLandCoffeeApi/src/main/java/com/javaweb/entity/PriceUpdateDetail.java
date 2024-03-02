package com.javaweb.entity;

import java.time.LocalDateTime;
import java.util.Date;

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
@Table(name = "price_update_detail")
public class PriceUpdateDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long price_update_detail_id;
	
	@Column
	private int price_new;
	
	@Column
	private int price_old;
	
	@Column
	private LocalDateTime created_at;
	
	@Column
	private LocalDateTime updated_at;
	
	@Column
	private Long staff_id;
	
	@Column
	private String product_id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "staff_id",insertable = false, updatable = false)
	private Staff staff;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private Product product;

	public Long getPrice_update_detail_id() {
		return price_update_detail_id;
	}

	public void setPrice_update_detail_id(Long price_update_detail_id) {
		this.price_update_detail_id = price_update_detail_id;
	}

	public int getPrice_new() {
		return price_new;
	}

	public void setPrice_new(int price_new) {
		this.price_new = price_new;
	}

	public int getPrice_old() {
		return price_old;
	}

	public void setPrice_old(int price_old) {
		this.price_old = price_old;
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

	public Long getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Long staff_id) {
		this.staff_id = staff_id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PriceUpdateDetail(Long price_update_detail_id, int price_new, int price_old, LocalDateTime created_at,
			LocalDateTime updated_at, Long staff_id, String product_id, com.javaweb.entity.Staff staff,
			com.javaweb.entity.Product product) {
		super();
		this.price_update_detail_id = price_update_detail_id;
		this.price_new = price_new;
		this.price_old = price_old;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.staff_id = staff_id;
		this.product_id = product_id;
		this.staff = staff;
		this.product = product;
	}
	

}
