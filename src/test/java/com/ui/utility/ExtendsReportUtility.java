package com.ui.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendsReportUtility {
	private static ExtentReports extendsreports;
	private static ThreadLocal<ExtentTest> extentest= new ThreadLocal<ExtentTest>();
	public  static void setUpSparkReport(String filename) {
		ExtentSparkReporter	extentsparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/"+filename);
		extendsreports = new ExtentReports();
		extendsreports.attachReporter(extentsparkreporter);
	}
	
	public static void createExtendTest(String testname) {
		ExtentTest test = extendsreports.createTest(testname);
		extentest.set(test);
		
	}
	
	public static ExtentTest getTest() {
		return extentest.get();
	}
	
	public static void flushReport() {
		extendsreports.flush();
		
	}
}
