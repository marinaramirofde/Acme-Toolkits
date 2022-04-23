package acme.testing.any.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyUserAccountListTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/any/user-account/list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, 
								final String roleList, final String name, final String surname, final String email) {
		
		super.clickOnMenu("Anonymous", "List All User Accounts");
		super.checkListingExists();
		super.sortListing(1, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, roleList);
        super.checkColumnHasValue(recordIndex, 1, name);
        super.checkColumnHasValue(recordIndex, 2, surname);
		
        super.clickOnListingRecord(recordIndex);
        super.checkFormExists();
        
        super.checkInputBoxHasValue("identity.name", name);
        super.checkInputBoxHasValue("identity.surname", surname);
        super.checkInputBoxHasValue("identity.email", email);
	}
}
