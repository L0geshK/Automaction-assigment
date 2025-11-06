package com.ui.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.Addresspojo;

public class FakeAddressUtility {
	
	public static Addresspojo getFakeAddress() {
		Faker faker = new Faker(Locale.US);

		Addresspojo addressPojo =

				new Addresspojo(faker.company().name(), faker.address().buildingNumber(),
						faker.address().streetAddress(), faker.address().city(), faker.numerify("#####"),
						faker.phoneNumber().cellPhone(), faker.phoneNumber().cellPhone(), "other", "office address",
						faker.address().state());

		return addressPojo;
	}
	

}
