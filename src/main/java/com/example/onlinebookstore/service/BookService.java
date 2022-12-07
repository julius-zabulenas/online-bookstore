package com.example.onlinebookstore.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.onlinebookstore.entity.AntiqueBook;
import com.example.onlinebookstore.entity.Book;
import com.example.onlinebookstore.entity.ScienceJournal;
import com.example.onlinebookstore.payload.BookRequest;
import com.example.onlinebookstore.repository.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void addBook(BookRequest bookRequest) throws Exception {
		if (bookRequest.getReleaseYear() != null) {
			bookRepository.save(new AntiqueBook(
					bookRequest.getBarcode(), bookRequest.getName(), bookRequest.getAuthor(),
					bookRequest.getQuantity(), bookRequest.getPricePerUnit(), bookRequest.getReleaseYear()));
		} else if (bookRequest.getScienceIndex() != 0) {
			bookRepository.save(new ScienceJournal(
					bookRequest.getBarcode(), bookRequest.getName(), bookRequest.getAuthor(),
					bookRequest.getQuantity(), bookRequest.getPricePerUnit(), bookRequest.getScienceIndex()));
		} else {
			bookRepository.save(new Book(
					bookRequest.getBarcode(), bookRequest.getName(), bookRequest.getAuthor(),
					bookRequest.getQuantity(), bookRequest.getPricePerUnit()));
		}
	}

	public Optional<Book> getBook(long barcode) {
		return bookRepository.findById(barcode);
	}

	public void updateBook(BookRequest bookRequest) {
		if (bookRequest.getReleaseYear() != null) {
			AntiqueBook antiqueBookFromDatabase = (AntiqueBook) bookRepository.findById(bookRequest.getBarcode()).orElse(null);

			antiqueBookFromDatabase.setAuthor(bookRequest.getAuthor());
			antiqueBookFromDatabase.setName(bookRequest.getName());
			antiqueBookFromDatabase.setPricePerUnit(bookRequest.getPricePerUnit());
			antiqueBookFromDatabase.setQuantity(bookRequest.getQuantity());
			antiqueBookFromDatabase.setReleaseYear(bookRequest.getReleaseYear());

			bookRepository.save(antiqueBookFromDatabase);
		} else if (bookRequest.getScienceIndex() != 0) {
			ScienceJournal scienceJournalFromDatabase = (ScienceJournal) bookRepository.findById(bookRequest.getBarcode()).orElse(null);

			scienceJournalFromDatabase.setAuthor(bookRequest.getAuthor());
			scienceJournalFromDatabase.setName(bookRequest.getName());
			scienceJournalFromDatabase.setPricePerUnit(bookRequest.getPricePerUnit());
			scienceJournalFromDatabase.setQuantity(bookRequest.getQuantity());
			scienceJournalFromDatabase.setScienceIndex(bookRequest.getScienceIndex());

			bookRepository.save(scienceJournalFromDatabase);
		} else {
			Book bookFromDatabase = bookRepository.findById(bookRequest.getBarcode()).orElse(null);

			bookFromDatabase.setAuthor(bookRequest.getAuthor());
			bookFromDatabase.setName(bookRequest.getName());
			bookFromDatabase.setPricePerUnit(bookRequest.getPricePerUnit());
			bookFromDatabase.setQuantity(bookRequest.getQuantity());

			bookRepository.save(bookFromDatabase);
		}
	}

	public BigDecimal getBookTotalPrice(long barcode) {
		Book bookFromDatabase = bookRepository.findById(barcode).orElse(null);

//		return bookFromDatabase.getPricePerUnit().multiply(new BigDecimal(bookFromDatabase.getQuantity()));
		return bookFromDatabase.bookTotalPrice();
	}

	public List<Book> getBooks() {
		return bookRepository.findAll(Sort.by(Sort.Direction.DESC, "quantity"));
	}
}
