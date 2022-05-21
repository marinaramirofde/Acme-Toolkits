/*
 * EmployerDutyCreateTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.administrator.configuration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorConfigurationUpdateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
//recordIndex,systemCurrency,acceptedCurrencies,strongTerms,strongThreshold,weakTerms,weakThreshold

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/configuration/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex,final String systemCurrency ,final String acceptedCurrencies,
		final String strongTerms, final String strongThreshold, final String weakTerms,final String weakThreshold) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "System Configuration");
		super.checkFormExists();
		
		super.fillInputBoxIn("systemCurrency", systemCurrency);
		super.fillInputBoxIn("acceptedCurrencies", acceptedCurrencies);
		super.fillInputBoxIn("strongTerms", strongTerms);
		super.fillInputBoxIn("strongThreshold", strongThreshold);
		super.fillInputBoxIn("weakTerms", weakTerms);
		super.fillInputBoxIn("weakThreshold", weakThreshold);
		super.clickOnSubmit("Update");
        
		super.clickOnMenu("Administrator", "System Configuration");
		super.checkFormExists();
		
		super.checkInputBoxHasValue("systemCurrency", systemCurrency);
		super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
		super.checkInputBoxHasValue("strongTerms", strongTerms);
		super.checkInputBoxHasValue("strongThreshold", strongThreshold);
		super.checkInputBoxHasValue("weakTerms", weakTerms);
		super.checkInputBoxHasValue("weakThreshold", weakThreshold);

		

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/configuration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex,final String systemCurrency ,final String acceptedCurrencies,
		final String strongTerms, final String strongThreshold, final String weakTerms,final String weakThreshold) {
		super.signIn("administrator", "administrator");

		super.clickOnMenu("Administrator", "System Configuration");
		super.checkFormExists();
		
		super.fillInputBoxIn("systemCurrency", systemCurrency);
		super.fillInputBoxIn("acceptedCurrencies", acceptedCurrencies);
		super.fillInputBoxIn("strongTerms", strongTerms);
		super.fillInputBoxIn("strongThreshold", strongThreshold);
		super.fillInputBoxIn("weakTerms", weakTerms);
		super.fillInputBoxIn("weakThreshold", weakThreshold);
		super.clickOnSubmit("Update");

		super.checkErrorsExist();

		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		// HINT+ a) Update an item with a role different to "Administrator";

	}
	
	// Ancillary methods ------------------------------------------------------

}
