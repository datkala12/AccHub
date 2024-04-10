package com.PS23665.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PS23665.dao.AccountRepo;
import com.PS23665.dao.OrderRepo;
import com.PS23665.entity.Account;
import com.PS23665.entity.Contact;
import com.PS23665.entity.Order;
import com.PS23665.service.OrderDetailService;
import com.PS23665.service.OrderService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class LoginController {

	@Autowired
	private AccountRepo accDAO;
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Account acc) {
		Account account = accDAO.findByUsernameAndPassword(acc.getUsername(), acc.getPassword());
		if (account != null) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }
	
}
