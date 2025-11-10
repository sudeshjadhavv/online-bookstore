package com.sudesh.bookstore.services;

import java.util.List;
import java.util.Optional;

import com.sudesh.bookstore.entity.Book;

public interface BookService {
	
	Book saveBook(Book book);
	
	List<Book> getAllBooks();
	
	Optional<Book> getBookById(Long id);
	
	List<Book> searchBooks(String keyword);
	
	Book updateBook(Long id,Book updateBook);
	
	void deleteBook(Long id);

}
