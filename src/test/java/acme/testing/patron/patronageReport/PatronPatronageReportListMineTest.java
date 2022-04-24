package acme.testing.patron.patronageReport;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageReportListMineTest extends TestHarness {

	// Test cases -------------------------------------------------------------
    //recordIndex,sequenceNumber,creationMoment,memorandum,info
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronageReport/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String sequenceNumber, final String creationMoment, final String memorandum,
		final String info) {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patron", "List All Mine Patronage Reports");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 1, creationMoment);
		super.checkColumnHasValue(recordIndex, 2, info);

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