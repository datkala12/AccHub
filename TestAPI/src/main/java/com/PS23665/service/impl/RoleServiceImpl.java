package com.PS23665.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS23665.dao.RoleRepo;
import com.PS23665.entity.Role;
import com.PS23665.service.RoleService;

//import com.evnt.dao.RoleDAO;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepo rrepo;

	@Override
	public List<Role> findAll() {
		return rrepo.findAll();
	}
}
