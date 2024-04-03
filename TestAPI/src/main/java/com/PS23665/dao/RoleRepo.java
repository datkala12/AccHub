package com.PS23665.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PS23665.entity.Role;


@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}