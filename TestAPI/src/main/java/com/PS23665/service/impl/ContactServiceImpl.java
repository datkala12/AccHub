package com.PS23665.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS23665.dao.ContactRepo;
import com.PS23665.entity.Contact;
import com.PS23665.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepo ctrepo;

	@Override
	public List<Contact> findAll() {
		return ctrepo.findAll();
	}

//	@Override
//	public List<Account> getAdministrators() {
//		return accrepo.getAdministrators();
//	}

	@Override
	public Contact create(Contact contact) {
		return ctrepo.save(contact);
	}

	@Override
	public Contact update(Contact contact) {
		return ctrepo.save(contact);
	}

	@Override
	public Contact delete(Contact contact) {
		return ctrepo.save(contact);
	}
}
