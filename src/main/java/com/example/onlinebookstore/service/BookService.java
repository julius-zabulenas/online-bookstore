package com.example.onlinebookstore.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.onlinebookstore.entity.AntiqueBook;
import com.example.onlinebookstore.entity.Book;
import com.example.onlinebookstore.payload.BookRequest;
import com.example.onlinebookstore.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void addBook(BookRequest bookRequest) {
		if (bookRequest.getReleaseYear() != null) {
			bookRepository.save(new AntiqueBook(
					bookRequest.getBarcode(), bookRequest.getName(), bookRequest.getAuthor(),
					bookRequest.getQuantity(), bookRequest.getPricePerUnit(), bookRequest.getReleaseYear()));
		} else {
			bookRepository.save(new Book(
					bookRequest.getBarcode(), bookRequest.getName(), bookRequest.getAuthor(),
					bookRequest.getQuantity(), bookRequest.getPricePerUnit()));
		}
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

	public BigDecimal getBookTotalPrice(long barcode) {
		Book bookFromDatabase = bookRepository.findById(barcode).orElse(null);

		return bookFromDatabase.getPricePerUnit().multiply(new BigDecimal(bookFromDatabase.getQuantity()));
	}

	public List<Book> getBooks() {
		return bookRepository.findAll(Sort.by(Sort.Direction.DESC, "quantity"));
	}
}
