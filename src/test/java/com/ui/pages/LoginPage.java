package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class LoginPage extends BrowserUtility {

	private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXT_BOX_LOACTOR = By.id("passwd");
	private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By ERROR_MSG_LOCATOR=By.xpath("//div[contains(@class,' alert-danger')]/ol/li");

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public MyAccountPage doLoginWith(String emailAddress, String Password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOACTOR, Password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		MyAccountPage myaccountpage = new MyAccountPage(getDriver());
		return myaccountpage;

	}
	public LoginPage doLoginWithInvalidxCredentials(String emailAddress, String Password) {
		enterText(EMAIL_TEXT_BOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOACTOR, Password);
		clickOn(SUBMIT_BUTTON_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
		
	}
	public String getError() {
		return getVisibleText(ERROR_MSG_LOCATOR);
	}

}
