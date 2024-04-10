package com.PS23665.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS23665.dao.OrderDetailRepo;
import com.PS23665.dao.OrderRepo;
import com.PS23665.entity.Order;
import com.PS23665.entity.OrderDetail;
import com.PS23665.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class OrderServiceImpl implements OrderService{
@Autowired
	 private OrderRepo orepo;
@Autowired
	 private OrderDetailRepo odrepo;
	@Override
	public Order create(JsonNode orderData) {
		ObjectMapper mapper = new ObjectMapper();

		Order order = mapper.convertValue(orderData, Order.class);
		orepo.save(order);

		TypeReference<List<OrderDetail>> type = new TypeReference(){};
		List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
				.stream().peek(d->d.setOrder(order)).collect(Collectors.toList());
		odrepo.saveAll(details);

		return order;
	}
}
