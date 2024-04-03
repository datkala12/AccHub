package com.PS23665.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS23665.dao.CategoryRepo;
import com.PS23665.entity.Category;
import com.PS23665.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo cateRepo;

	@Override
	public List<Category> findAll() {
		return cateRepo.findAll();
	}

	@Override
	public Category findById(Integer id) {
		return cateRepo.findById(id).get();
	}

	@Override
	public Category create(Category category) {
		return cateRepo.save(category);
	}

	@Override
	public Category update(Category category) {
		return cateRepo.save(category);
	}

	@Override
	public void delete(Integer id) {
		cateRepo.deleteById(id);
	}


}
