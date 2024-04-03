package com.PS23665.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private int orderStatus;
	@Temporal(TemporalType.DATE)
	@Column(name = "createDate")
	Date createDate = new Date();

    @ManyToOne
    @JoinColumn(name = "acc_user")
    Account account;

    @JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Order() {
		super();
	}

	public Order(Long id, int orderStatus, Date createDate, Account account, List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.orderStatus = orderStatus;
		this.createDate = createDate;
		this.account = account;
		this.orderDetails = orderDetails;
	}

}
