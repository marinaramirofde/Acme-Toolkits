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

package acme.testing.administrator.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorAnnouncementCreateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
//recordIndex,confirmation,title,critical,text,info

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String confirmation ,final String title, final String critical, final String text, final String info) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Create Announcement");
		super.checkFormExists();
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("critical", critical);
		super.fillInputBoxIn("body", text);
		super.fillInputBoxIn("link", info);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");
        
		super.clickOnMenu("Authenticated", "List Recent Announcements");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 1, critical);
		super.checkColumnHasValue(recordIndex, 2, title);
		

		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("critical", critical);
		super.checkInputBoxHasValue("body", text);
		super.checkInputBoxHasValue("link", info);

		

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/announcement/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex,final String confirmation ,final String title, final String critical, final String text, final String info) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "Create Announcement");
        super.checkFormExists();
		
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("critical", critical);
		super.fillInputBoxIn("body", text);
		super.fillInputBoxIn("link", info);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create");

		super.checkErrorsExist();

		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/administrator/announcement/create");
		super.checkPanicExists();

		super.signIn("patron1", "patron1");
		super.navigate("/administrator/announcement/create");
		super.checkPanicExists();
		super.signOut();
	}
	
	// Ancillary methods ------------------------------------------------------

}
