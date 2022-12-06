package com.example.onlinebookstore.service;

import java.util.Optional;

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

	public Optional<Book> getBook(long barcode) {
		return bookRepository.findById(barcode);
	}

	public void updateBook(Book book) {
		Book bookFromDatabase = bookRepository.findById(book.getBarcode()).orElse(null);

		bookFromDatabase.setAuthor(book.getAuthor());
		bookFromDatabase.setName(book.getName());
		bookFromDatabase.setPricePerUnit(book.getPricePerUnit());
		bookFromDatabase.setQuantity(book.getQuantity());

		bookRepository.save(bookFromDatabase);
	}
}
