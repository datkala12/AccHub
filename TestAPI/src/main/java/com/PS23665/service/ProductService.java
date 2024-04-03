package com.PS23665.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.PS23665.entity.Product;


@Service
public interface ProductService{

	Page<Product> findAll(Pageable pageable);

	Page<Product> findByCategoryID(String cid,Pageable pageable);

	List<Product> findAll();

	Product findById(Integer productID);

	List<Product> findByCategoryID(String cid);

	Product create(Product product);

	Product update(Product product);

	void delete(Integer id);

}
