package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class MyAccountPage extends BrowserUtility {
	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return getusername(USER_NAME_LOCATOR);

	}

}
