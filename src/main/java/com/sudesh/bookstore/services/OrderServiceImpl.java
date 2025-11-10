package com.sudesh.bookstore.services;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudesh.bookstore.entity.Book;
import com.sudesh.bookstore.entity.Order;
import com.sudesh.bookstore.entity.OrderItem;
import com.sudesh.bookstore.repositories.BookRepository;
import com.sudesh.bookstore.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
//	
//	@Override
//	public Order placeOrder(Order order) {
//	    double totalAmount = 0.0;
//
//	    for (OrderItem item : order.getItems()) {
//	        // 🔥 Make sure quantity is set
//	        if (item.getQuantity() <= 0) {
//	            throw new RuntimeException("Quantity must be greater than 0");
//	        }
//
//	        Book book = bookRepository.findById(item.getBook().getId())
//	                .orElseThrow(() -> new RuntimeException("Book not found"));
//
//	        double totalPrice = book.getPrice() * item.getQuantity();
//	        item.setTotalPrice(totalPrice);
//	        item.setBook(book);
//	        item.setOrder(order);
//
//	        totalAmount += totalPrice;
//	    }
//
//	    order.setTotalAmount(totalAmount);
//
//	    return orderRepository.save(order);
//	}
//	
	@Override
	public Order placeOrder(Order order) {
		double totalAmount=0.0;
		
		//Set current date and time 
		order.setOrderDate(LocalDateTime.now());
		// Ensure each order item is linked correctly
		
		for(OrderItem item : order.getItems()) {
			
			// Validate that a book is provided
			if(item.getBook()==null || item.getBook().getId()==null) {
				throw new IllegalArgumentException("Book must not br null for each order item");
			}
			
			//Fetch the book from databases
			Book book=bookRepository.findById(item.getBook().getId())
					.orElseThrow(() -> new RuntimeException("Book not found"));
			
			
			//Set the fetched Book to this item
			item.setBook(book);
			
			//Link order item to this order
			item.setOrder(order);
			
			//calculate total price for this item
			double totalPrice=book.getPrice()*item.getQuantity();
			item.setTotalPrice(totalPrice);
			
			totalAmount += totalPrice;
		}
			
			//Set final total amount for the order
			order.setTotalAmount(totalAmount);
			
			//------Simulate payment success---------
			
			boolean paymentSuccess = simulatePayment();
			if(paymentSuccess) {
				order.setStatus("PAID");
				order.setPaymentStatus("CONFIRMED");
			}
			else {
				order.setStatus("FAILED");
				order.setPaymentStatus("CANCELLED");
			}
						
			//save the entire order with items
			return orderRepository.save(order);
			
	}
	
	//MOCK payment logic
	private boolean simulatePayment() {
		//Randomly simulate success (90% chance)
		return Math.random() > 0.1;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderById(Long id) {
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order Not Found With ID:"+id));
	}

	@Override
	public void deleteOrder(Long id) {
		orderRepository.deleteById(id);
		
	}


	

}
