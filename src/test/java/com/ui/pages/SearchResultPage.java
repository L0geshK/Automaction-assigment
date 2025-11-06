	package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {
	
	private static final By product_listing_title_locator= By.xpath("//span[@class='lighter']");
	private static final By PRODUCT_LIST_NAMES_LOCATOR = By.xpath("//h5[@itemprop='name']/a");
	
	

	public SearchResultPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String getSearchResultTitle() {
		return getVisibleText(product_listing_title_locator);
		
	}
	public boolean isProductTearmPresentList(String Keyword) {
		 List<String>Keywords=Arrays.asList(Keyword.toLowerCase());
		 List<String>productnamelist=getAllVisibleText(PRODUCT_LIST_NAMES_LOCATOR);
		 boolean result= productnamelist.stream()
		 .anyMatch(name->(Keywords.stream().anyMatch(name.toLowerCase()::contains)));
		 return result;
		 
		
	}
	
}
