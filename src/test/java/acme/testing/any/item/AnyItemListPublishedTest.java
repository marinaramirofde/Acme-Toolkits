package acme.testing.any.item;


import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyItemListPublishedTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/any/item/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, 
								 final String name,  final String code,  final String technology, 
								 final String description,  final String retailPrice,  final String link, 
								 final String type) {
		
		super.clickOnMenu("Anonymous", "List All Items");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, name);
        super.checkColumnHasValue(recordIndex, 1, code);
        super.checkColumnHasValue(recordIndex, 2, type);
		
        super.clickOnListingRecord(recordIndex);
        super.checkFormExists();
        
        // "name", "code", "technology", "description", "retailPrice", "link","type"
        super.checkInputBoxHasValue("name", name);
        super.checkInputBoxHasValue("code", code);
        super.checkInputBoxHasValue("technology", technology);
        super.checkInputBoxHasValue("description", description);
        super.checkInputBoxHasValue("retailPrice", retailPrice);
        super.checkInputBoxHasValue("link", link);
        super.checkInputBoxHasValue("type", type);
        
	}
}
