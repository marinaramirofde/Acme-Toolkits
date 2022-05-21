/*
 * EmployerDutyCreateTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.patron.patronage;

import java.text.ParseException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronagePublishTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
//recordIndex,code,info,budget,legalStuff,status

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/publish-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code, final String info, final String budget,
		final String legalStuff,final String status) throws ParseException {
		super.signIn("patron2", "patron2");

		super.clickOnMenu("Patron", "List All Mine Patronage");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		
		super.clickOnListingRecord(recordIndex);
        super.checkFormExists();
		


	    super.fillInputBoxIn("code", code);
	    super.fillInputBoxIn("info", info);
	    super.fillInputBoxIn("budget", budget);
	    super.fillInputBoxIn("legalStuff", legalStuff);
	    super.fillInputBoxIn("status", status);
		super.clickOnSubmit("Publish Patronage");

		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, info);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, legalStuff);


		super.clickOnListingRecord(recordIndex);
	    super.checkInputBoxHasValue("code", code);
	    super.checkInputBoxHasValue("info", info);
	    super.checkInputBoxHasValue("budget", budget);
	    super.checkInputBoxHasValue("legalStuff", legalStuff);
	    super.checkInputBoxHasValue("status", status);

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/publish-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String code, final String info, final String budget,
		final String legalStuff,final String status) {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patron", "List All Mine Patronage");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		
		super.clickOnListingRecord(recordIndex);
        super.checkFormExists();
		
		

		super.checkNotButtonExists("Publish Patronage");

		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		// HINT+ a) Update an item with a role different to "Patron";

	}
	
	// Ancillary methods ------------------------------------------------------

}
