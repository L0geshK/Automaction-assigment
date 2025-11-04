package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.constants.Browser;
import static com.ui.constants.Env.*;
import com.ui.utility.BrowserUtility;
import com.ui.utility.JsonUtility;
import com.ui.utility.PropertiesUtils;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[@class='login']");

	public HomePage(Browser Browsername,boolean isHeadless) {
		super(Browsername,isHeadless);
		//goToWebsite(PropertiesUtils.readproperty(QA, "URL"));
		goToWebsite(JsonUtility.readJson(QA).getUrl());
		maximizedSize();
	}
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JsonUtility.readJson(QA).getUrl());
	}
	
	
	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
	}

}
