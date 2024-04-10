package com.PS23665.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PS23665.dao.ContactRepo;
import com.PS23665.entity.Contact;
import com.PS23665.entity.Product;
import com.PS23665.service.ContactService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/contact")
public class ContactController {
	
	@Autowired
    private ContactService contactService;
	
	@Autowired
    private ContactRepo contactDAO;

	@GetMapping("/list")
	public List<Contact> getContact() {
		return this.contactDAO.findAll();
	}
	
	@PostMapping("/submit")
    public ResponseEntity<String> submitContact(@RequestBody Contact contact) {
        contactDAO.save(contact);
        return ResponseEntity.ok("Contact form submitted successfully!");
    }
	
}
