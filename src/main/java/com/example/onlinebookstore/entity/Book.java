package com.example.onlinebookstore.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Books")
public class Book {

	@Id
	private long barcode;

	private String name;
	private String author;
	private int quantity;
	private BigDecimal pricePerUnit;

	public Book() {

	}

	public Book(long barcode, String name, String author, int quantity, BigDecimal pricePerUnit) {
		this.barcode = barcode;
		this.name = name;
		this.author = author;
		this.quantity = quantity;
		this.pricePerUnit = pricePerUnit;
	}

	public long getBarcode() {
		return barcode;
	}

	public void setBarcode(long barcode) {
		this.barcode = barcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(BigDecimal pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

}
