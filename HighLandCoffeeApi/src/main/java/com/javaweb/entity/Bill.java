package com.javaweb.entity;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name = "bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long bill_id;
	
	@Column
	private Date date;
	
	@Column
	private int total_quantity;
	
	@Column
	private int total_price;
	
	@Column
	private LocalDateTime updated_at;
	
	@Column
	private LocalDateTime created_at;

	@Column
	private Long order_id;
	
	@Column
	private Long staff_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "order_id",insertable = false, updatable = false)
	private Orders order;
	
	@ManyToOne
	@JoinColumn(name = "staff_id",insertable = false, updatable =  false)
	private Staff staff;

	public Long getBill_id() {
		return bill_id;
	}

	public void setBill_id(Long bill_id) {
		this.bill_id = bill_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotal_quantity() {
		return total_quantity;
	}

	public void setTotal_quantity(int total_quantity) {
		this.total_quantity = total_quantity;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Long staff_id) {
		this.staff_id = staff_id;
	}

	public Orders getOrder() {
		return order;
	}

	public void setOrder(Orders order) {
		this.order = order;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Bill(Long bill_id, Date date, int total_quantity, int total_price, LocalDateTime updated_at, LocalDateTime created_at,
			Long order_id, Long staff_id, com.javaweb.entity.Orders order, com.javaweb.entity.Staff staff) {
		super();
		this.bill_id = bill_id;
		this.date = date;
		this.total_quantity = total_quantity;
		this.total_price = total_price;
		this.updated_at = updated_at;
		this.created_at = created_at;
		this.order_id = order_id;
		this.staff_id = staff_id;
		this.order = order;
		this.staff = staff;
	}
	
	
}
