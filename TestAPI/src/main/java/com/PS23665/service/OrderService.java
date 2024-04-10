package com.PS23665.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.PS23665.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;


@Service
public interface OrderService {
	Order create(JsonNode orderData);
}
