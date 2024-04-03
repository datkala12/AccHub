package com.PS23665.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "roles")
public class Role {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	private int id;
	private String name;

	@JsonIgnore
	@OneToMany(mappedBy = "role")
	List<Authority> authorities;

	public Role(int id, String name, List<Authority> authorities) {
		super();
		this.id = id;
		this.name = name;
		this.authorities = authorities;
	}

	public Role() {
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

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

}
