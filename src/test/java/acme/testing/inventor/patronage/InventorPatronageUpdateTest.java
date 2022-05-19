package acme.testing.inventor.patronage;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageUpdateTest extends TestHarness {


	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code,final String info, final String legalStuff, final String status) {
		
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Patronages");
		super.checkListingExists();
				
		super.clickOnListingRecord(recordIndex);
		super.fillInputBoxIn("status", status);
		super.clickOnSubmit("Update!");

		super.clickOnMenu("Inventor", "List All Mine Patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, info);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, legalStuff);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("info", info);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("status", status);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String code,final String info, final String legalStuff, final String status) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Patronages");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.checkNotSubmitExists("Update!");

		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		// HINT: ...
	}

	// Ancillary methods ------------------------------------------------------

}
