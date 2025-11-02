package com.ui.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.Userdata;

public class CSVReaderUtility {
	
	
	public static Iterator<Userdata> readCSVFile (String filename) {

		File csvFile = new File(System.getProperty("user.dir") + "/testData/"+filename);
		FileReader filereader = null;
		CSVReader csevreader = null;
		String[] dataline;
		List<Userdata> userlist = null;
		Userdata user;
		try {
			filereader = new FileReader(csvFile);
			csevreader = new CSVReader(filereader);
			csevreader.readNext();

			 userlist = new ArrayList<Userdata>();
			

			while ((dataline = csevreader.readNext()) != null) {
				user = new Userdata(dataline[0], dataline[1]);
				userlist.add(user);

			}

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {
			
			e.printStackTrace();
		}
		return userlist.iterator();

	}

}
