package com.PS23665.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Authorities", uniqueConstraints =
{ @UniqueConstraint(columnNames = { "acc_user", "role_id" }) })
public class Authority {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "acc_user")
	private Account account;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Authority(Integer id, Account account, Role role) {
		super();
		this.id = id;
		this.account = account;
		this.role = role;
	}

	public Authority() {
		super();
	}

}
