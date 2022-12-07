package com.example.onlinebookstore.entity;

import java.math.BigDecimal;

import org.hibernate.validator.constraints.Range;

import jakarta.persistence.Entity;

@Entity
public class ScienceJournal extends Book {

	@Range(min = 1, max = 10, message = "Science index must be between 1 and 10")
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

	@Override
	public BigDecimal bookTotalPrice() {
		return new BigDecimal(super.getQuantity())
				.multiply(super.getPricePerUnit()
						.multiply(new BigDecimal(scienceIndex)));
	}
}
