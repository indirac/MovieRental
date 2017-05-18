package com.bls.refactoring;
/*
 * CHANGES: Turned Movie into an abstract class as I added the logic
 * for amount and frequent renter point calculation as abstract methods.
 * Different movies will now be added as derived classes inheriting this Movie class.
 * Thus making it easy to add new categories, simply derive this Movie class
 * and add your logic for amount and frequent renter point calculation
 */
public abstract class Movie {
	
	/*
	 * CHANGES: Removed the constants and priceCode datamember as it's no longer
	 * needed. Earlier we used these information for the switch case in
	 * Customer.statement() to calculate amount. Now since we have refactored
	 * the logic into different movies as derived classes of Movie superclass it
	 * is no longer needed
	 */

	private String title;

	public Movie(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	/*
	 * CHANGES: Added the logic for amount and frequent renter point calculation
	 * as abstract methods.
	 */
	public abstract double calculateAmount(int daysRented);

	public abstract int calculateFrequentRenterPoints(int daysRented);
}
