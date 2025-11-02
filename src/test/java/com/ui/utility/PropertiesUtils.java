package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.ui.constants.Env;

public class PropertiesUtils {

	public static String readproperty(Env env, String propertyname) {

		File property = new File(System.getProperty("user.dir") + "/Config/"+env+".properties");
		Properties properties = new Properties();
		FileReader reader = null;
		try {
			reader = new FileReader(property);
			properties.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		catch (IOException e) {
			
			e.printStackTrace();
		}
		String value = properties.getProperty(propertyname).toUpperCase();
		System.out.println(properties.getProperty(propertyname));
		return value;

	}

}
