package com.example.onlinebookstore.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinebookstore.entity.Book;
import com.example.onlinebookstore.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {

	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}

	@PostMapping("/books")
	public ResponseEntity<HttpStatus> addBook(@RequestBody Book book) {
		bookService.addBook(book);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping("/books/{barcode}")
	public ResponseEntity<Optional<Book>> getBook(@PathVariable long barcode) {
		return new ResponseEntity<>(bookService.getBook(barcode), HttpStatus.CREATED);
	}

	@PutMapping("/books")
	public ResponseEntity<HttpStatus> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("/books/{barcode}/total-price")
	public ResponseEntity<BigDecimal> getBookTotalPrice(@PathVariable long barcode) {
		return new ResponseEntity<BigDecimal>(bookService.getBookTotalPrice(barcode), HttpStatus.OK);
	}

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		return new ResponseEntity<List<Book>>(bookService.getBooks(), HttpStatus.OK);
	}
}
