package com.ui.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	private static final String hubURL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitieslocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver intializedLambdaTest(String testname, String browsername) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browsername);
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("user", "1ogesh1408k");
		ltOptions.put("accessKey", "LT_sJubnpuCCdtyQNy0kbvr71lvUiRUCaQUE8uE8pns1kl2NrD");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testname);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "latest");
		capabilities.setCapability("LT:Options", ltOptions);
		capabilitieslocal.set(capabilities);
		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL(hubURL), capabilitieslocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		driverlocal.set(driver);
		

		return driverlocal.get();

	}

	public static void quitSession() {
		if (driverlocal.get() != null) {
			driverlocal.get().quit();
		}

	}

}
