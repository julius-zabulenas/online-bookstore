package com.example.onlinebookstore.config;

import java.math.BigDecimal;
import java.time.Year;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.onlinebookstore.entity.AntiqueBook;
import com.example.onlinebookstore.entity.Book;
import com.example.onlinebookstore.entity.ScienceJournal;
import com.example.onlinebookstore.repository.BookRepository;

@Configuration
public class AppConfig {

	@Bean
	public CommandLineRunner seedDatabase(BookRepository bookRepository) {
		return (args) -> {
			bookRepository.save(new Book(9786099619002L, "Silkė, Menkė Ir Banginis: Ir maži gali būti galingi",
					"Jón Baldvin Hannibalsson", 10, new BigDecimal(14.99)));
			bookRepository.save(new Book(9780300216103L, "The Hundred Years War: A People's History",
					"David Green", 1, new BigDecimal(11.99)));
			bookRepository.save(new AntiqueBook(9780486220437L, "The Merry Adventures of Robin Hood",
					"Howard Pyle", 57, new BigDecimal(12.99), Year.of(1883)));
			bookRepository.save(new ScienceJournal(9781617298691L, "Spring Start Here: Learn what you need and learn it well",
					"Laurentiu Spilca", 1, new BigDecimal(36.99), 10));
		};
	}
}
