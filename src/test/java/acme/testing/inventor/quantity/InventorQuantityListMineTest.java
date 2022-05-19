package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorQuantityListMineTest extends TestHarness {

	// Test cases -------------------------------------------------------------
    //recordIndex,assemblyNotes,code,description,link,published,title,price
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/list-mine.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int toolkitRecordIndex,final int recordIndex, final String amount, final String name, final String code,
		final String technology,final String description, final String retailPrice, final String link, final String type, final String published) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.clickOnListingRecord(toolkitRecordIndex);
		super.clickOnButton("Items");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, name);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, type);
		super.checkColumnHasValue(recordIndex, 3, amount);


		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("amount", amount);
		super.checkInputBoxHasValue("item.code", code);
		super.checkInputBoxHasValue("item.name", name);
		super.checkInputBoxHasValue("item.technology", technology);
		super.checkInputBoxHasValue("item.retailPrice", retailPrice);
		super.checkInputBoxHasValue("item.link", link);
		super.checkInputBoxHasValue("item.type", type);

		super.signOut();
	}

}