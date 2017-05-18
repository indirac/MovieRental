package com.bls.refactoring;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;

	// CHANGES: Added type Rental to ArrayList to avoid raw type reference
	private ArrayList<Rental> rentals = new ArrayList<>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentals.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {

		double totalAmount = 0;
		int frequentRenterPoints = 0;

		/*
		 * CHANGES: Used StringBuilder instead of String because it is much
		 * faster and consumes less memory.
		 */
		StringBuilder returnVal = new StringBuilder();
		returnVal.append("Rental record for : " + this.getName() + ".....\n");

		// CHANGES: Added type Rental to Iterator to avoid raw type reference
		Iterator<Rental> iter = rentals.iterator();

		while (iter.hasNext()) {
			Rental each = iter.next();

			/*
			 * CHANGES: Violates Open/Close Principle. Removed switch case to
			 * calculate amount and delegated the calculation to the respective
			 * movie classes
			 */
			double thisAmount = each.getMovie().calculateAmount(each.getDaysRented());

			/*
			 * CHANGES: Violates Open/Close Principle. Removed unnecessary if
			 * and delegated the calculation of frequenter points to the
			 * respective movie classes
			 */
			frequentRenterPoints += each.getMovie().calculateFrequentRenterPoints(each.getDaysRented());

			// show figures for this rental
			returnVal.append("\t" + each.getMovie().getTitle() + ": " + thisAmount + "\n");
			totalAmount += thisAmount;

		}

		// print footer
		returnVal.append("Amount owed is: " + totalAmount + "\n");
		returnVal.append("You have earned " + frequentRenterPoints + " frequent renter points");

		return returnVal.toString();
	}
}
