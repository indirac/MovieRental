package com.bls.refactoring;

//CHANGE #2/2: Added a new category called Bollywood
public class BollywoodMovie extends Movie {

	public BollywoodMovie(String title) {
		super(title);
	}

	@Override
	public double calculateAmount(int daysRented) {
		return (double) daysRented * 125;
	}

	@Override
	public int calculateFrequentRenterPoints(int daysRented) {
		if (daysRented > 1)
			return 2;
		else
			return 1;
	}

}
