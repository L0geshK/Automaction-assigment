package com.ui.test;

import static com.ui.constants.Browser.CHROME;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.Userdata;

public class LoginTest {
	HomePage h1;

	@BeforeMethod(description = "Load the HomePage of WebSite!!")
	public void setUp() {
		h1 = new HomePage(CHROME);

	}

	@Test(description = "Verifiy with the valid user able to login into application", groups = { "e2e",
			"sanity" }, dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "Logindataprovider")
	public void loginTest(Userdata userdata) {

		assertEquals(h1.goToLoginPage().doLoginWith(userdata.getEmailAddress(),userdata.getPassword()).getUserName(),
				"Logeshkanna V");

	}
	
	@Test(description = "Verifiy with the valid user able to login into application", groups = { "e2e",
	"sanity" }, dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "logindataproviderCSV")
	public void loginTestCSVDataProvider(Userdata userdata) {

		assertEquals(h1.goToLoginPage().doLoginWith(userdata.getEmailAddress(),userdata.getPassword()).getUserName(),
				"Logeshkanna V");

	}
	
	
	@Test(description = "Verifiy with the valid user able to login into application", groups = { "e2e",
	"sanity" }, dataProviderClass = com.ui.dataproviders.loginDataProvider.class, dataProvider = "logindataproviderExcel")
	public void loginTestExcelDataProvider(Userdata userdata) {

		assertEquals(h1.goToLoginPage().doLoginWith(userdata.getEmailAddress(),userdata.getPassword()).getUserName(),
				"Logeshkanna V");

	}

}
