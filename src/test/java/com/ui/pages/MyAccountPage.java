package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
	private static final By SEARCH_TEXT_BOX_LOCATOR =By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR= By.xpath("//a[@title='Add my first address']");
	

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return getusername(USER_NAME_LOCATOR);

	}
	
	
	public SearchResultPage searchForProduct(String productname) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, productname);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		SearchResultPage searchresultpage = new SearchResultPage(getDriver());
		return searchresultpage;
		
	}

	public AddressPage goTOAddAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		AddressPage addresspage = new AddressPage(getDriver());
		return addresspage;
	}

	
}
