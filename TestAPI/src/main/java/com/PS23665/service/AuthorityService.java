package com.PS23665.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PS23665.entity.Authority;

@Service
public interface AuthorityService {

//	public List<Authority> findAuthoritiesOfAdministrators();

	public List<Authority> findAll();

	public Authority create(Authority auth);

	public void delete(Integer id);

	List<Authority> getOneByRole(String username);

	void deleteByUsername(String username);

	Long getTotalCustomer();
}
