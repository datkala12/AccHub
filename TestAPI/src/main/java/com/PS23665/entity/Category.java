package com.PS23665.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "categories")
public class Category implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String cate_image;
	private String cate_cover;
	private String cate_des;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> product;

	public Category(int id, String name, String cate_image, String cate_cover, String cateDes, List<Product> product) {
		super();
		this.id = id;
		this.name = name;
		this.cate_image = cate_image;
		this.cate_cover = cate_cover;
		this.cate_des = cate_des;
		this.product = product;
	}

	public Category() {
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
	
	public String getCate_image() {
		return cate_image;
	}
	
	public void setCateImage(String cate_image) {
		this.cate_image = cate_image;
	}
	
	public String getCate_cover() {
		return cate_cover;
	}
	
	public void setCateCover(String cate_cover) {
		this.cate_cover = cate_cover;
	}
	
	public String getCateDes() {
		return cate_des;
	}
	
	public void setCateDes(String cate_des) {
		this.cate_des = cate_des;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

}
