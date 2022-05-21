package acme.testing.patron.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageListMineTest extends TestHarness {

	// Test cases -------------------------------------------------------------
    //recordIndex,creationMoment,endMoment,startMoment,code,info,budget,legalStuff,status,patronId
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String creationMoment, final String endMoment, final String startMoment,
		final String code,final String info, final String budget, final String legalStuff, final String status) {
		super.signIn("patron2", "patron2");

		super.clickOnMenu("Patron", "List All Mine Patronage");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, info);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, legalStuff);

		//recordIndex,creationMoment,endMoment,startMoment,code,info,budget,legalStuff,status,patronId
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("creationMoment",creationMoment);
		super.checkInputBoxHasValue("endMoment", endMoment);
		super.checkInputBoxHasValue("startMoment", startMoment);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("info", info);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("status", status);
		


		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}