package com.ui.test;

import static com.ui.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.Userdata;
import com.ui.utility.LoggerUtility;




@Listeners({com.ui.listner.TestListener.class})
public class InvalidLoginTest extends TestBase {

		


	@Test(description = "Verifiy if the proper error message is showing for the invalid login Credentials", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "Logindataprovider",retryAnalyzer = com.ui.listner.MyRetryAnalyzer.class)
	public void loginTest(Userdata userdata) {
		
	

		assertEquals(h1.goToLoginPage().doLoginWithInvalidxCredentials(userdata.getEmailAddress(),userdata.getPassword()).getError(),
				"Authentication failed.");
		
		
	}
	
	@Test(description = "Verifiy if the proper error message is showing for the invalid login Credential", groups = { "e2e",
	"sanity" }, dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "logindataproviderCSV")
	public void loginTestCSVDataProvider(Userdata userdata) {
		
		assertEquals(h1.goToLoginPage().doLoginWithInvalidxCredentials(userdata.getEmailAddress(),userdata.getPassword()).getError(),
				"Authentication failed.");
		
		

	}
	
	
	@Test(description = "Verifiy if the proper error message is showing for the invalid login Credential", groups = { "e2e",
	"sanity" }, dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "logindataproviderExcel")
	public void loginTestExcelDataProvider(Userdata userdata) {
		
		assertEquals(h1.goToLoginPage().doLoginWithInvalidxCredentials(userdata.getEmailAddress(),userdata.getPassword()).getError(),
				"Authentication failed.");
		
		


	}

}
