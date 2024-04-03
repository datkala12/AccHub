package com.PS23665.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PS23665.entity.OrderDetail;


@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetail, Long>{

}
