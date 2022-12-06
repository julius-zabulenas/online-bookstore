package com.example.onlinebookstore.service;

import org.springframework.stereotype.Service;

import com.example.onlinebookstore.entity.Book;
import com.example.onlinebookstore.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void addBook(Book book) {
		bookRepository.save(book);
	}
}