package com.example.onlinebookstore.entity;

import java.math.BigDecimal;
import java.time.Year;

import jakarta.persistence.Entity;

@Entity
public class AntiqueBook extends Book {

	private Year releaseYear;

	public AntiqueBook() {

	}

	public AntiqueBook(long barcode, String name, String author, int quantity, BigDecimal pricePerUnit, Year releaseYear) {
		super(barcode, name, author, quantity, pricePerUnit);
		this.releaseYear = releaseYear;
	}

	public Year getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Year releaseYear) {
		this.releaseYear = releaseYear;
	}

}
