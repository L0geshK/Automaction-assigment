package com.ui.utility;

import java.time.Duration;

import org.openqa.selenium.By;
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

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BrowserUtility(String Browsername) {
		if (Browsername.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();

		} else if (Browsername.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();

		} else {
			System.err.println("Invalid Browser name You have to enter Chrome or Edge Browser");
		}

	}
	
	public BrowserUtility(Browser browsername) {
		if (browsername==Browser.CHROME) {
			driver = new ChromeDriver();

		} else if (browsername == Browser.EDGE) {
			driver = new EdgeDriver();

		} else if (browsername == Browser.FIREFOX) {
			driver = new FirefoxDriver();

		}
	}

	public void goToWebsite(String url) {
		driver.get(url);
	}

	public void maximizedSize() {
		driver.manage().window().maximize();
	}

	public void minimizedSized() {
		driver.manage().window().minimize();
	}

	public void clickOn(By Locatoer) {
		WebElement element = driver.findElement(Locatoer);
		element.click();
	}

	public void enterText(By locator, String Entertext) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(Entertext);
	}

	public String getusername(By Locatoer) {
		WebElement element = driver.findElement(Locatoer);
		return element.getText();

	}

	public void selectValueFromDropDown(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);

	}

	public void frameByname(String name) {
		driver.switchTo().frame(name);
	}

	public void waitElement(WebDriver driver, WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(Element)).click();

	}

}
