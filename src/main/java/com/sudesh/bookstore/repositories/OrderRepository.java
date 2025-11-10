package com.sudesh.bookstore.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.sudesh.bookstore.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Long >{
	
	

}
