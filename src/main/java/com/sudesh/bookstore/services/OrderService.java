package com.sudesh.bookstore.services;

import java.util.List;

import com.sudesh.bookstore.entity.Order;

public interface OrderService {
	
	Order placeOrder(Order order);
	
	List<Order> getAllOrders();
	
	Order getOrderById(Long id);
	
	void deleteOrder(Long id);
	

}
