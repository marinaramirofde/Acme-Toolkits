package acme.testing.inventor.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportListMineTest extends TestHarness {

	// Test cases -------------------------------------------------------------
    //recordIndex,sequenceNumber,creationMoment,memorandum,info
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String sequenceNumber, final String creationMoment, final String memorandum,
		final String info) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Patronage Reports");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 1, creationMoment);

		//"sequenceNumber", "creationMoment", "memorandum", "info"
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		//super.checkInputBoxHasValue("sequenceNumber",sequenceNumber);
		super.checkInputBoxHasValue("creationMoment",creationMoment);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("info", info);
		
		


		super.signOut();
	}

	// Ancillary methods ------------------------------------------------------

}