package com.example.onlinebookstore.payload;

import java.math.BigDecimal;
import java.time.Year;

public class BookRequest {

	private long barcode;
	private String name;
	private String author;
	private int quantity;
	private BigDecimal pricePerUnit;
	private Year releaseYear;
	private int scienceIndex;

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

	public Year getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Year releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getScienceIndex() {
		return scienceIndex;
	}

	public void setScienceIndex(int scienceIndex) {
		this.scienceIndex = scienceIndex;
	}

}
