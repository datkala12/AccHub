package com.PS23665.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PS23665.entity.Contact;

@Service
public interface ContactService {

	List<Contact> findAll();

	Contact create(Contact contact);

	Contact update(Contact contact);

	Contact delete(Contact contact);
}
