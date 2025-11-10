package com.sudesh.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sudesh.bookstore.entity.Book;
import com.sudesh.bookstore.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book saved=bookService.saveBook(book);
		return ResponseEntity.ok(saved);
	}
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBook(@PathVariable Long id){
		Book book=bookService.getBookById(id).orElse(null);
		if(book !=null) {
			return ResponseEntity.ok().body(book);
		}
		else {
			return ResponseEntity.notFound().build();
			
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book updateBook){
		Book book=bookService.updateBook(id, updateBook);
		return ResponseEntity.ok(book);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
		return ResponseEntity.noContent().build();
	}

}
