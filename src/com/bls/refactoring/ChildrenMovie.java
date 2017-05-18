package com.bls.refactoring;

public class ChildrenMovie extends Movie {

	public ChildrenMovie(String title) {
		super(title);
	}

	@Override
	public double calculateAmount(int daysRented) {
		if (daysRented > 3)
			return (double) 75 + (daysRented - 3) * 75;
		return 75;
	}

	@Override
	public int calculateFrequentRenterPoints(int daysRented) {
		return 1;
	}

}
