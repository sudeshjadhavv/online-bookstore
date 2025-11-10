package com.sudesh.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudesh.bookstore.entity.Book;
import com.sudesh.bookstore.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public Book saveBook(Book book) {
		
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		
		return bookRepository.findById(id);
	}

	@Override
	public List<Book> searchBooks(String keyword) {
		
		return bookRepository.findByTitleContainingIgnoreCase(keyword);
	}

	@Override
	public Book updateBook(Long id, Book updateBook) {
		Optional<Book> existing=bookRepository.findById(id);
		if(existing.isPresent()) {
			Book book=existing.get();
			book.setTitle(updateBook.getTitle());
			book.setAuthor(updateBook.getAuthor());
			book.setPrice(updateBook.getPrice());
			book.setDescription(updateBook.getDescription());
			return bookRepository.save(book);
		}
		else {
			throw new RuntimeException("Book Not Found With Id"+id);
		}
	
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
		
	}

	

}
