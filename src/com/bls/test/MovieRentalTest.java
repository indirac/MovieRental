package com.bls.test;

import com.bls.refactoring.BollywoodMovie;
import com.bls.refactoring.ChildrenMovie;
import com.bls.refactoring.Customer;
import com.bls.refactoring.NewReleaseMovie;
import com.bls.refactoring.RegularMovie;
import com.bls.refactoring.Rental;

import junit.framework.TestCase;

/*
 * CHANGES: Only made changes for
 * movie object creation(RegularMovie, ChildrenMovie, New Release Movie, BollywoodMovie)
 * before and after refactoring.
 * And also a change in New Release amount due as I made changes in
 * amount calculation logic.
 */
public class MovieRentalTest extends TestCase {

	public void testRegularMovieRental() {
		Customer customer = new Customer("Indira");
		Rental rental = new Rental(new RegularMovie("Pursuit of Happyness"), 7);
		customer.addRental(rental);
		assertEquals("Rental record for : Indira.....\n" + "\tPursuit of Happyness: 475.0\n" + "Amount owed is: 475.0\n"
				+ "You have earned 1 frequent renter points", customer.statement());

	}

	public void testNewReleaseMovieRental() {
		Customer customer = new Customer("Ajit");
		Rental rental = new Rental(new NewReleaseMovie("Split"), 8);
		customer.addRental(rental);
		assertEquals("Rental record for : Ajit.....\n" + "\tSplit: 2100.0\n" + "Amount owed is: 2100.0\n"
				+ "You have earned 2 frequent renter points", customer.statement());
	}

	public void testChildrenMovieRental() {
		Customer customer = new Customer("Maya");
		Rental rental = new Rental(new ChildrenMovie("Moana"), 5);
		customer.addRental(rental);
		assertEquals("Rental record for : Maya.....\n" + "\tMoana: 225.0\n" + "Amount owed is: 225.0\n"
				+ "You have earned 1 frequent renter points", customer.statement());
	}

	public void testBollywoodMovieRental() {
		Customer customer = new Customer("Aaliya");
		Rental rental = new Rental(new BollywoodMovie("Taare Zameen Par"), 7);
		customer.addRental(rental);
		assertEquals("Rental record for : Aaliya.....\n" + "\tTaare Zameen Par: 875.0\n" + "Amount owed is: 875.0\n"
				+ "You have earned 2 frequent renter points", customer.statement());
	}

	public void testAllMovieRental() {
		Customer customer = new Customer("Ram");
		Rental rental = new Rental(new RegularMovie("Sixth Sense"), 7);
		customer.addRental(rental);
		rental = new Rental(new NewReleaseMovie("Logan"), 7);
		customer.addRental(rental);
		rental = new Rental(new ChildrenMovie("Monsters Inc."), 7);
		customer.addRental(rental);
		rental = new Rental(new BollywoodMovie("Rockstar"), 7);
		customer.addRental(rental);
		assertEquals("Rental record for : Ram.....\n" + "\tSixth Sense: 475.0\n" + "\tLogan: 1800.0\n"
				+ "\tMonsters Inc.: 375.0\n" + "\tRockstar: 875.0\n" + "Amount owed is: 3525.0\n"
				+ "You have earned 6 frequent renter points", customer.statement());
	}

}
