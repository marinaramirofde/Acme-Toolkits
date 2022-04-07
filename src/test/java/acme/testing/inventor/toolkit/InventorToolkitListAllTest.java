package acme.testing.inventor.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitListAllTest extends TestHarness {

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/list-all-toolkits.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String title, final String code, final String published,
		final String description, final String link,final String assemblyNotes ,final String reference) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2,reference);
		super.checkColumnHasValue(recordIndex, 3, description);

		//recordIndex,title,code,published,description,link,assemblyNotes,reference
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("toolkit.title", title);
		super.checkInputBoxHasValue("toolkit.code", code);
		super.checkInputBoxHasValue("toolkit.assemblyNotes", assemblyNotes);
		super.checkInputBoxHasValue("toolkit.description", description);
		super.checkInputBoxHasValue("toolkit.published", published);
		super.checkInputBoxHasValue("toolkit.link", link);
		super.checkInputBoxHasValue("item.name", reference);

		super.signOut();
	}

}
