package com.bls.refactoring;

public class NewReleaseMovie extends Movie {

	public NewReleaseMovie(String title) {
		super(title);
	}

	@Override
	public double calculateAmount(int daysRented) {
		/*
		 * CHANGE #1/2: If rented for more than two days, then rental amount for
		 * the remaining days will be twice the amount paid on day 1 and day 2
		 */
		if (daysRented > 2)
			return (double) 150 * 2 + (daysRented - 2) * 300;
		else
			return (double) daysRented * 150;
	}

	@Override
	public int calculateFrequentRenterPoints(int daysRented) {
		if (daysRented > 1)
			return 2;
		else
			return 1;
	}

}
