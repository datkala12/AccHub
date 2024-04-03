package com.PS23665.service;

import org.springframework.stereotype.Service;

@Service
public interface OrderDetailService {

	Double getTodayIncome();

	Double getTotalIncome();

}
