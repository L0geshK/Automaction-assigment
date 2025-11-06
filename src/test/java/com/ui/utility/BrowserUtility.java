package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ui.constants.Browser;

public abstract class BrowserUtility {
	 Logger logger = LoggerUtility.getLogger(this.getClass());


	private static  ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private WebDriverWait wait;
	

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}
	
	public BrowserUtility(Browser browsername,boolean isHeadless) {
		if (browsername==Browser.CHROME) {
			if(isHeadless) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--windows-size=1920,1080");
			driver.set(new ChromeDriver(options));
			
			}else {
				driver.set(new ChromeDriver());
			}

		} else if (browsername == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				
				
			}else {
			driver.set(new EdgeDriver());
			}

		} else if (browsername == Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				driver.set(new FirefoxDriver(options));
				
			}else {
				driver.set(new FirefoxDriver());
			}
			

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

	public void enterSpecialKey(By locator, Keys keytoEnetr) {

		logger.info("Finding the Element: "+locator+"Enter text: "+keytoEnetr);

		WebElement element = driver.get().findElement(locator);
		element.sendKeys(keytoEnetr);
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
		
	public String getVisibleText(By locator) {
		logger.info("Finding the Element:"+locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Element found and now return visible text"+element.getText());
		return element.getText();
	}
	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding All Elements with the locator" + locator);

		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Elements Found and now printing the List of Elements");
		List<String> visibleTextList = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}

		return visibleTextList;

	}
	public String getVisibleText(WebElement element ) {
		
		logger.info("return visible text"+element.getText());
		return element.getText();
	}
	
	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding Element with the locator" + dropDownLocator);
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(dropDownLocator));
		// element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Selecting the Option " + optionToSelect);

		select.selectByVisibleText(optionToSelect);
	}
	public void clearText(By textBoxLocator) {
		logger.info("Finding Element with the locator" + textBoxLocator);

		// WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));

		logger.info("Element Found and clearing the text box field");

		element.clear();
	}

}
