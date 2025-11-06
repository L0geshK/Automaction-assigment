package com.ui.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;

@Listeners({com.ui.listner.TestListener.class})
public class SearchProductTest extends TestBase {
	

	private MyAccountPage myaccount;
	
	@BeforeMethod(description = "valid user credentials login")
	public void setup() {
		myaccount = h1.goToLoginPage().doLoginWith("loky@gmail.com", "password");
		
		
	}
	
	@Test(description = "Verfify if the logger in user is able to 	search for a product and correct product",groups = {"e2e","sanity"})
	public void verifySearchProductTest() {
	 boolean	result= myaccount.searchForProduct("PRINTED SUMMER DRESS").isProductTearmPresentList("PRINTED SUMMER DRESS");
		assertEquals(result, true);
		
	
		
	}

}
