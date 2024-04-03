package com.PS23665.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PS23665.entity.Role;

@Service
public interface RoleService {
	public List<Role> findAll();
}
