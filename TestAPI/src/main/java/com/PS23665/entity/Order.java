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
    private int id;
	private int order_status;
	@Temporal(TemporalType.DATE)
	@Column(name = "createDate")
	Date createDate = new Date();
	private String fullname;
	private String email;

    @JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;

}
