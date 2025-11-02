package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.ui.constants.Env;
import com.ui.pojo.Config;
import com.ui.pojo.environments;

public class JsonUtility {
	public static String readJson(Env env) {
		
		Gson gson = new Gson();
		File jsonfile = new File(System.getProperty("user.dir") + "/Config/config.json");
		FileReader jsonfilereader=null;
		try {
			jsonfilereader = new FileReader(jsonfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	    Config  config= gson.fromJson(jsonfilereader, Config.class);
	    environments envurl= config.getEnvironments().get("QA");
	    return envurl.getUrl();
	   
	   
	   
		
		
	}

}
