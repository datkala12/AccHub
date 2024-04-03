package com.PS23665.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String username;
	@NotBlank(message = "Không được để trống")
	private String email;
	@NotBlank(message = "Không được để trống")
	private String password;
	private int status;
	private String wl;

	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;

	@JsonIgnore
	@OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
	List<Authority> authorities;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getWl() {
		return wl;
	}

	public void setWl(String wl) {
		this.wl = wl;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Authority> authorities) {
		this.authorities = authorities;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Account(String username, @NotBlank(message = "Không được để trống") String email,
			@NotBlank(message = "Không được để trống") String password, int status, String wl, List<Order> orders,
			List<Authority> authorities) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
		this.wl = wl;
		this.orders = orders;
		this.authorities = authorities;
	}

	public Account() {
		super();
	}


}
