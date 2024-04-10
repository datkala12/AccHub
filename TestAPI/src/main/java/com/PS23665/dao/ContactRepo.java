package com.PS23665.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PS23665.entity.Account;
import com.PS23665.entity.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer> {

}
