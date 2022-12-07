package com.example.onlinebookstore.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;

@Entity
public class ScienceJournal extends Book {

	private int scienceIndex;

	public ScienceJournal() {

	}

	public ScienceJournal(long barcode, String name, String author, int quantity, BigDecimal pricePerUnit, int scienceIndex) {
		super(barcode, name, author, quantity, pricePerUnit);
		this.scienceIndex = scienceIndex;
	}

	public int getScienceIndex() {
		return scienceIndex;
	}

	public void setScienceIndex(int scienceIndex) {
		this.scienceIndex = scienceIndex;
	}

}
