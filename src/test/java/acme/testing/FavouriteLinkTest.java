/*
 * FavouriteLinkTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class FavouriteLinkTest extends TestHarness {
	
	// Lifecycle management ---------------------------------------------------

	// Test cases -------------------------------------------------------------

	@Test
	@Order(10)
	public void favouriteLink() {
		super.navigateHome();
		super.clickOnMenu("Anonymous", "54183920Z: Lorenzo Casas, Angel");		
		super.checkCurrentUrl("https://www.youtube.com");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "47557390Z: Avila Sanchez, Rafael");		
		super.checkCurrentUrl("https://es.wikipedia.org");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "47394372C: Suarez Perea, Daniel");		
		super.checkCurrentUrl("http://www.twitter.com");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "47428674Y: Montalban Martin, Raul");		
		super.checkCurrentUrl("http://www.twitch.com");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "X7517297T: Danko, Siamion");		
		super.checkCurrentUrl("https://www.youtube.com");
		
		super.navigateHome();
		super.clickOnMenu("Anonymous", "75902954X: Ramiro Fernandez, Marina");		
		super.checkCurrentUrl("https://www.pinterest.de");
	}
	
	
	
	// Ancillary methods ------------------------------------------------------ 
	
}
