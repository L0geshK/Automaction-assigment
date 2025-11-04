package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.constants.Browser;

public abstract class BrowserUtility {
	 Logger logger = LoggerUtility.getLogger(this.getClass());


	private static  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String Browsername) {
		logger.info("Launching the for: "+Browsername);
		if (Browsername.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());

		} else if (Browsername.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());

		} else {
			logger.info("Invalid Browser name You have to enter Chrome or Edge Browser");
			
		}

	}
	
	public BrowserUtility(Browser browsername) {
		if (browsername==Browser.CHROME) {
			driver.set(new ChromeDriver());

		} else if (browsername == Browser.EDGE) {
			driver.set(new EdgeDriver());

		} else if (browsername == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());

		}
	}

	public void goToWebsite(String url) {
		logger.info("Go to the Website :"+url);
		driver.get().get(url);
	}

	public void maximizedSize() {
		logger.info("WebSite Size is maximized");
		driver.get().manage().window().maximize();
	}

	public void minimizedSized() {
		driver.get().manage().window().minimize();
	}

	public void clickOn(By Locatoer) {
		logger.info("Finding the Element:"+Locatoer);
		WebElement element = driver.get().findElement(Locatoer);
		element.click();
		logger.info("Element Found now Performing the Click");
	}

	public void enterText(By locator, String Entertext) {

		logger.info("Finding the Element: "+locator+"Enter text: "+Entertext);

		WebElement element = driver.get().findElement(locator);
		element.sendKeys(Entertext);
		logger.info("Element Found and Enter the Text ");
	}

	public String getusername(By Locatoer) {
		logger.info("Finding the Element:"+Locatoer);
		WebElement element = driver.get().findElement(Locatoer);
		logger.info("Finding the text:"+element.getText());
		return element.getText();
		

	}

	public void selectValueFromDropDown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	public void frameByname(String name) {
		driver.get().switchTo().frame(name);
	}

	public void waitElement(WebDriver driver, WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(Element)).click();

	}
	
	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}
		
	

}
