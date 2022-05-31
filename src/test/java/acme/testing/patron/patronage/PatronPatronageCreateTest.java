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

package acme.testing.patron.patronage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;

import acme.framework.testing.BrowserDriver;
import acme.testing.TestHarness;

public class PatronPatronageCreateTest extends TestHarness {

	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------
//recordIndex,code,info,budget,legalStuff,status

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code, final String info, final String budget,
		final String legalStuff,final String status,final String inventorId) throws ParseException {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patron", "List All Mine Patronage");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		Date creationDate;
		Date startDate;
		Date endDate;
		
		super.clickOnButton("Create Patronage");
		//final String creationMoment = super.getDriver().locateOne(By.id("creationMoment")).getAttribute("creationMoment");
		creationDate = new Date(System.currentTimeMillis() - 1);
		startDate = DateUtils.addMonths(creationDate, 2);
		endDate = DateUtils.addMonths(creationDate, 4);
		
       
		
		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");

	    final String startDateS = dateFormat.format(startDate);
	    final String endDateS = dateFormat.format(endDate);
	    
	


		super.fillInputBoxIn("startMoment", startDateS);
		super.fillInputBoxIn("endMoment", endDateS);
	    super.fillInputBoxIn("code", code);
	    super.fillInputBoxIn("info", info);
	    super.fillInputBoxIn("budget", budget);
	    super.fillInputBoxIn("legalStuff", legalStuff);
	    super.fillInputBoxIn("status", status);
	    final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"inventorId_proxy\"]/option[" + inventorId +"]")).click();	
		super.clickOnSubmit("Create Patronage");

		super.checkListingExists();
		super.sortListing(0, "asc");
		super.checkColumnHasValue(recordIndex, 0, info);
		super.checkColumnHasValue(recordIndex, 1, code);
		super.checkColumnHasValue(recordIndex, 2, legalStuff);


		super.clickOnListingRecord(recordIndex);
		super.checkInputBoxHasValue("startMoment", startDateS);
		super.checkInputBoxHasValue("endMoment", endDateS);
	    super.checkInputBoxHasValue("code", code);
	    super.checkInputBoxHasValue("info", info);
	    super.checkInputBoxHasValue("budget", budget);
	    super.checkInputBoxHasValue("legalStuff", legalStuff);
	    super.checkInputBoxHasValue("status", status);

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeTest(final int recordIndex, final String code, final String info, final String budget,
		final String legalStuff,final String status, final int badStartDate, final int badEndDate, final String inventorId) {
		super.signIn("patron1", "patron1");

		super.clickOnMenu("Patron", "List All Mine Patronage");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		Date creationDate;
	    Date startDate;
	    Date endDate;
		
		super.clickOnButton("Create Patronage");
		//final String creationMoment = super.getDriver().locateOne(By.id("creationMoment")).getAttribute("creationMoment");
		creationDate = new Date(System.currentTimeMillis() - 1);
		if(badStartDate == 1) {
			startDate = DateUtils.addMonths(creationDate, 0);
		}
		else {
		startDate = DateUtils.addMonths(creationDate, 2);
		}
		if(badEndDate == 1) {
			endDate = DateUtils.addMonths(creationDate, 0);
		}
		else {
		endDate = DateUtils.addMonths(creationDate, 4);
		}
		

		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");


	    final String startDateS = dateFormat.format(startDate);
	    final String endDateS = dateFormat.format(endDate);
	    
	


		super.fillInputBoxIn("startMoment", startDateS);
		super.fillInputBoxIn("endMoment", endDateS);
	    super.fillInputBoxIn("code", code);
	    super.fillInputBoxIn("info", info);
	    super.fillInputBoxIn("budget", budget);
	    super.fillInputBoxIn("legalStuff", legalStuff);
	    super.fillInputBoxIn("status", status);
	    final BrowserDriver driver = super.getDriver();
		driver.locateOne(By.xpath("//*[@id=\"inventorId_proxy\"]/option[" + inventorId +"]")).click();	
		super.clickOnSubmit("Create Patronage");

		super.checkErrorsExist();

		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/patron/patronage/create");
		super.checkPanicExists();

		super.signIn("inventor1", "inventor1");
		super.navigate("/patron/patronage/create");
		super.checkPanicExists();
		super.signOut();
	}
	
	// Ancillary methods ------------------------------------------------------

}