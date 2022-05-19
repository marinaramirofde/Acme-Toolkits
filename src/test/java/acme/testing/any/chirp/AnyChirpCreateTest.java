package acme.testing.any.chirp;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyChirpCreateTest extends TestHarness {

	// Test cases -------------------------------------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String creationMoment, final String title, final String author, final String body, final String email, final String confirmation) {
		

		super.clickOnMenu("Anonymous", "List Recent Chirps");
		super.checkListingExists();
		
		super.clickOnButton("Create Chirp");
		super.checkFormExists();
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create Chirp");


	}

	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String creationMoment, final String title, final String author, final String body, final String email, final String confirmation) {

		
		super.clickOnMenu("Anonymous", "List Recent Chirps");
		super.checkListingExists();
		
		super.clickOnButton("Create Chirp");
		super.checkFormExists();
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("body", body);
		super.fillInputBoxIn("email", email);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create Chirp");

		super.checkErrorsExist();

	}

	@Test
	@Order(30)
	public void hackingTest() {
		// havent
	}

	// Ancillary methods ------------------------------------------------------

}
