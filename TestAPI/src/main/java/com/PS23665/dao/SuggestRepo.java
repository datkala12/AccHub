package com.PS23665.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PS23665.entity.Category;
import com.PS23665.entity.Suggest;


@Repository
public interface SuggestRepo extends JpaRepository<Suggest, Integer>{

}
