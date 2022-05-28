package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemPublishTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publish-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String name, final String  code, final String type) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.clickOnSubmit("Publish");
		super.checkNotErrorsExist();

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publish-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String name, final String  code, final String type) {
		super.signIn("inventor1", "inventor1");
		super.clickOnMenu("Inventor", "List All Mine Items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.clickOnListingRecord(recordIndex);
		
		super.checkFormExists();
		super.checkNotSubmitExists("Publish");

		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		// HINT+ a) Publish an item with a role different to "Inventor";		
	}

	// Ancillary methods ------------------------------------------------------

}
