package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.Listofuserdata;
import com.ui.pojo.Userdata;
import com.ui.utility.CSVReaderUtility;
import com.ui.utility.ExcelReaderUtility;

public class loginDataProvider {
	
	
	
	@DataProvider(name = "Logindataprovider")
	public Iterator<Object[]> logindataprovider() {
		Gson gson = new Gson();
		Listofuserdata  data=null;
		File testdata = new File(System.getProperty("user.dir") +"/testData/logindata.json");
		try {
			FileReader testdatareader = new FileReader(testdata);
			data=gson.fromJson(testdatareader, Listofuserdata.class);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  List<Object[]>dataToReturn = new ArrayList<Object[]>();
		  for(Userdata userdata:data.getData()) {
			  dataToReturn.add( new Object[] {userdata});
		  }
		  
		  return dataToReturn.iterator();
	  
	
		
	}
	
	
	@DataProvider(name="logindataproviderCSV")
	public Iterator<Userdata> logindataproviderCSV() {
		return CSVReaderUtility.readCSVFile("logindata.csv");
		
	}
	
	@DataProvider(name="logindataproviderExcel")
	public Iterator<Userdata> logindataproviderExcel() {
		return ExcelReaderUtility.readerExcel("logindata.xlsx");
		
	}
	

}
