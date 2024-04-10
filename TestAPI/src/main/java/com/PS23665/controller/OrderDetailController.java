package com.PS23665.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PS23665.dao.OrderDetailRepo;
import com.PS23665.dao.OrderRepo;
import com.PS23665.entity.Contact;
import com.PS23665.entity.Order;
import com.PS23665.entity.OrderDetail;
import com.PS23665.service.OrderDetailService;
import com.PS23665.service.OrderService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/orderdetail")
public class OrderDetailController {

	@Autowired
	private OrderDetailRepo orderdetailDAO;
	
	@GetMapping("/list")
    public List<OrderDetail> getOrder() {
      return this.orderdetailDAO.findAll();
   }
	
}
