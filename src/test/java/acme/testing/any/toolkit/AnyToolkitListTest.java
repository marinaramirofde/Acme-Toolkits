package acme.testing.any.toolkit;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyToolkitListTest extends TestHarness{

	//recordIndex,assemblyNotes,code,description,link,published,title,reference,price
	@ParameterizedTest
	@CsvFileSource(resources = "/any/toolkit/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, 
								final String assemblyNotes, final String code, final String description, final String link,
								 final String published, final String title, 
								final String reference, final String price) {
		
		super.clickOnMenu("Anonymous", "List All Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, title);
        super.checkColumnHasValue(recordIndex, 1, code);
        super.checkColumnHasValue(recordIndex, 2, reference);
        super.checkColumnHasValue(recordIndex, 3, description);
        
        super.clickOnListingRecord(recordIndex);
        super.checkFormExists();
        
        super.checkInputBoxHasValue("price", price);
        super.checkInputBoxHasValue("toolkit.assemblyNotes", assemblyNotes);
        super.checkInputBoxHasValue("toolkit.code", code);
        super.checkInputBoxHasValue("toolkit.description", description);
        super.checkInputBoxHasValue("toolkit.link", link);
        super.checkInputBoxHasValue("toolkit.published", published);
        super.checkInputBoxHasValue("toolkit.title", title);
        super.checkInputBoxHasValue("item.name", reference);
	}
}
