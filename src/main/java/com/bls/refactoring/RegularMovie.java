package com.bls.refactoring;

public class RegularMovie extends Movie {

	public RegularMovie(String title) {
		super(title);
	}

	@Override
	public double calculateAmount(int daysRented) {
		if (daysRented > 3)
			return (double) 100 + (daysRented - 2) * 75;
		return 100;
	}

	@Override
	public int calculateFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
