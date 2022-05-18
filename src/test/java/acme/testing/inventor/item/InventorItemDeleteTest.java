package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemDeleteTest extends TestHarness {

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/delete-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String name, final String  code, final String technology, final String description, final String retailPrice, final String link, final String type) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Items");
		super.checkListingExists();
		
		// name, code, technology, description, retailPrice, link, type
		
		super.clickOnMenu("Inventor", "List All Mine Items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);

		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("type", type);
		
		super.clickOnSubmit("Delete");

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/delete-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String name, final String  code, final String technology, final String description, final String retailPrice, final String link, final String type) {
		
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Items");
		super.checkListingExists();
		
		// name, code, technology, description, retailPrice, link, type
		
		super.clickOnMenu("Inventor", "List All Mine Items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(recordIndex);

		super.checkFormExists();
		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("retailPrice", retailPrice);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("type", type);
		
		super.checkNotSubmitExists("Delete");

		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		// HINT+ a) Update an item with a role different to "Inventor";	
	}

	// Ancillary methods ------------------------------------------------------

}
