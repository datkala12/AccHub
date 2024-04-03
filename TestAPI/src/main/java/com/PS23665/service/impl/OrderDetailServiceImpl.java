package com.PS23665.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS23665.dao.OrderDetailRepo;
import com.PS23665.service.OrderDetailService;
import com.PS23665.util.XDate;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
	@Autowired
	 private OrderDetailRepo dtrepo;
	@Autowired private XDate xdate;

	@Override
	public Double getTodayIncome() {
		return dtrepo.findAll().stream().filter(e->e.getOrder().getCreateDate().toString().equals(xdate.convertToPattern(new Date(), "yyyy-MM-dd"))).mapToDouble(item->item.getPrice()).sum();
	}
	@Override
	public Double getTotalIncome() {
		return dtrepo.findAll().stream().mapToDouble(item->item.getPrice()).sum();
	}

}
