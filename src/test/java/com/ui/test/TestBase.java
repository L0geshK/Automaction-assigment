package com.ui.test;

import static com.ui.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.ui.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.utility.BrowserUtility;
import com.ui.utility.LambdaTestUtility;
import com.ui.utility.LoggerUtility;

public class TestBase {

	public HomePage h1;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private boolean isLambdaTest;
	

	
	@Parameters({"browser","isHeadless","isLambdaTest"})
	@BeforeMethod(description = "Load the HomePage of WebSite!!")
	public void setUp(
			@Optional("Chrome") String browser, 
			@Optional("false") boolean isHeadless,
			@Optional("false") boolean isLambdaTest,
			ITestResult result) {
		this.isLambdaTest=isLambdaTest;
		WebDriver lambdadriver;
		if (isLambdaTest) {
			lambdadriver = LambdaTestUtility.intializedLambdaTest(result.getMethod().getMethodName(), "Chrome");
			h1 = new HomePage(lambdadriver);

		} else {

			logger.info("Load the HomePage of the WebSite");

			h1 = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);

		}
	}

	public BrowserUtility getInstance() {
		return h1;
	}

	/*@AfterMethod(description = "Tear Down the Browser!!")
	public void tearDown() {
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {
			h1.getDriver().quit();
		}
	}*/
}
