package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageListMineTest extends TestHarness {

	// Test cases -------------------------------------------------------------
    //recordIndex,creationMoment,endMoment,startMoment,code,info,budget,legalStuff,status,patronId
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String creationMoment, final String endMoment, final String startMoment,
		final String code,final String info, final String budget, final String legalStuff, final String status, final String company) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Patronages");
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
		super.checkInputBoxHasValue("patron.company", company);
		


		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}