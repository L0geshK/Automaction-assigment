package com.ui.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.Userdata;

public class ExcelReaderUtility {

	public static Iterator<Userdata> readerExcel(String filename) {

		XSSFWorkbook xssfworkbook;
		XSSFSheet xssfsheet;
		Iterator<Row> rowiterator;
		Row row;
		org.apache.poi.ss.usermodel.Cell emailAddress;
		org.apache.poi.ss.usermodel.Cell password;
		List<Userdata> userlist = null;
		Userdata user;
		File xlsxfile = new File(System.getProperty("user.dir") + "/testData/" + filename);
		try {
			xssfworkbook = new XSSFWorkbook(xlsxfile);
			xssfsheet = xssfworkbook.getSheet("Logintestdata");
			rowiterator = xssfsheet.iterator();
			rowiterator.next();
			userlist= new ArrayList<Userdata>();
			while (rowiterator.hasNext()) {
				row = rowiterator.next();
				emailAddress = row.getCell(0);
				password = row.getCell(1);
				user = new Userdata(emailAddress.toString(), password.toString());
				userlist.add(user);
				xssfworkbook.close();

			}

		} catch (InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlist.iterator();
	}

}
