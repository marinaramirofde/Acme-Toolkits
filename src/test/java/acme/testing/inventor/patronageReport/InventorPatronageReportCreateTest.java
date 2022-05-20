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

package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportCreateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int patronageIndex, final int recordIndex,final String confirmation ,final String memorandum, final String info) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(patronageIndex);
		
		
		
		super.clickOnButton("Create Patronage Report");
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("info", info);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");
        
		super.clickOnButton("Patronage Reports");
		super.checkListingExists();
		super.sortListing(0, "asc");
		

		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("info", info);

		

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int patronageIndex, final int recordIndex,final String confirmation, final String memorandum, final String info) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(patronageIndex);
		
		
		
		super.clickOnButton("Create Patronage Report");
		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("info", info);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");

		super.checkErrorsExist();

		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/patronage-report/create");
		super.checkPanicExists();

		super.signIn("patron1", "patron1");
		super.navigate("/inventor/patronage-report/create");
		super.checkPanicExists();
		super.signOut();
	}
	
	// Ancillary methods ------------------------------------------------------

}
