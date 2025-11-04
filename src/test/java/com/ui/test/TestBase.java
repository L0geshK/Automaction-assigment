package com.ui.test;

import static com.ui.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;

import com.ui.pages.HomePage;
import com.ui.utility.BrowserUtility;
import com.ui.utility.LoggerUtility;

public class TestBase {
	
	public HomePage h1;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@BeforeMethod(description = "Load the HomePage of WebSite!!")
	public void setUp() {
		
		h1 = new HomePage(CHROME);
		

	}
	
	public BrowserUtility getInstance() {
		return h1;
	}

}
