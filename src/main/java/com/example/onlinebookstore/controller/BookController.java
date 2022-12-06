package com.example.onlinebookstore.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}
