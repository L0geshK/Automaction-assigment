package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.Addresspojo;
import com.ui.utility.FakeAddressUtility;

@Listeners({com.ui.listner.TestListener.class})
public class AddNewAddressTest extends  TestBase {
	
	
private  MyAccountPage myaccount;
private AddressPage addresspage;
private Addresspojo address;
	
	@BeforeMethod(description = "valid user credentials login")
	public void setup() {
		myaccount = h1.goToLoginPage().doLoginWith("loky@gmail.com", "password");
		address = FakeAddressUtility.getFakeAddress();
		
		
	}
	@Test
	public void addNewAddress() {
		 String newAddress = myaccount.goTOAddAddressPage().saveAddress(address);
		 Assert.assertEquals(newAddress, address.getAddressAlias().toUpperCase());
		
	}
	
	

}
