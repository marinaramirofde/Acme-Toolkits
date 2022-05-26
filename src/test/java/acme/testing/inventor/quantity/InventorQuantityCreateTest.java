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

package acme.testing.inventor.quantity;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class InventorQuantityCreateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
    //"amount", "item.name", "item.code", "item.technology", "item.description", "item.retailPrice", "item.link","item.type", "item.published"
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int toolkitRecordIndex,final int recordIndex, final String amount, final String name, final String code,
		final String technology,final String description, final String retailPrice, final String link, final String type, final String published, final String itemId) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.clickOnListingRecord(toolkitRecordIndex);
		super.clickOnButton("Create Quantity");
		
		super.fillInputBoxIn("amount", amount);
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"itemId_proxy\"]/option[" + itemId +"]")).click();		
		super.clickOnSubmit("Create Quantity");

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
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/quantity/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int toolkitRecordIndex,final int recordIndex, final String amount, final String name, final String code,
		final String technology,final String description, final String retailPrice, final String link, final String type, final String published, final String itemId) {
		super.signIn("inventor1", "inventor1");

		super.clickOnMenu("Inventor", "List All Mine Toolkits");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.clickOnListingRecord(toolkitRecordIndex);
		super.clickOnButton("Create Quantity");
		
		super.fillInputBoxIn("amount", amount);
		final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"itemId_proxy\"]/option[" + itemId +"]")).click();
		super.clickOnSubmit("Create Quantity");
        super.checkErrorsExist();
		
		
	


		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/quantity/create");
		super.checkPanicExists();

		super.signIn("patron1", "patron1");
		super.navigate("/inventor/quantity/create");
		super.checkPanicExists();
		super.signOut();
		
	}
	// Ancillary methods ------------------------------------------------------

}
