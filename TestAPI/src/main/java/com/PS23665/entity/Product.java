	package com.PS23665.entity;

import java.util.List;
import java.util.Date;

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

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class Product {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private int id;
	private String name;
	private String description;
	private int status;
	private String image_cover;
	private String image_detail;
	private double price;
	private Long rentalDuration;
	private String rank;
	private int level;
	private String item;
	private String type;
	private String accUser;
	private String accPass;
	@Temporal(TemporalType.DATE)
    @Column(name = "date_create")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateCreate = new Date();
	@ManyToOne
    @JoinColumn(name = "cate_id")
    private Category category;

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	List<OrderDetail> orderDetails;

	public Product() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public String getImage_cover() {
		return image_cover;
	}

	public void setImage_cover(String image_cover) {
		this.image_cover = image_cover;
	}

	public String getImage_detail() {
		return image_detail;
	}

	public void setImage_detail(String image_detail) {
		this.image_detail = image_detail;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Long getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(Long rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccUser() {
		return accUser;
	}

	public void setAccUser(String accUser) {
		this.accUser = accUser;
	}

	public String getAccPass() {
		return accPass;
	}

	public void setAccPass(String accPass) {
		this.accPass = accPass;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Product(int id, String name, String description, String image_cover, String image_detail, int status, double price, Long rentalDuration,
			String rank, Integer level, String item, String type, String accUser, String accPass, Date dateCreate, Category category,
			List<OrderDetail> orderDetails) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.status = status;
		this.image_cover = image_cover;
		this.image_detail = image_detail;
		this.price = price;
		this.rentalDuration = rentalDuration;
		this.rank = rank;
		this.level = level;
		this.item = item;
		this.type = type;
		this.accUser = accUser;
		this.accPass = accPass;
		this.dateCreate = dateCreate;
		this.category = category;
		this.orderDetails = orderDetails;
	}

}
