package com.example.onlinebookstore.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.onlinebookstore.entity.Book;
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
		};
	}
}
