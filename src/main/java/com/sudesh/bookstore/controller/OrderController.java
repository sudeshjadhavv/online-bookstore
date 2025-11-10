package com.sudesh.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sudesh.bookstore.entity.Order;
import com.sudesh.bookstore.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	// place a new order for a book
	@PostMapping
	public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
		Order newOrder = orderService.placeOrder(order);
		return ResponseEntity.ok(newOrder);
	}
	
	// Get all orders
	@GetMapping
	public ResponseEntity<List<Order>> getAllOders(){
		List<Order> orders =orderService.getAllOrders();
		return ResponseEntity.ok(orders);
	}
	
	// Get single order by id
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Long id){
		Order order=orderService.getOrderById(id);
		return ResponseEntity.ok(order);
	}
	
	
	// Delete an order
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrderById(@PathVariable Long id){
		orderService.deleteOrder(id);
		return ResponseEntity.ok("Order Deleted Successfully with Id"+id);
	}

}
