package com.ui.listner;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.ui.utility.BrowserUtility;
import com.ui.utility.ExtendsReportUtility;
import com.ui.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	ExtentSparkReporter extentsparkreporter = null;
	ExtentReports extendsreports = null;
	ExtentTest extentest = null;

	public void onTestStart(ITestResult result) {

		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtendsReportUtility.createExtendTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "PASSED");
		ExtendsReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtendsReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtendsReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

		Object testclass = result.getInstance();

		BrowserUtility browserUtility = ((TestBase) testclass).getInstance();
		logger.info("Capturing Screenshot for the failed tests");

		String screenshotPath = browserUtility.takeScreenShot(result.getMethod().getMethodName());
		logger.info("Attaching the Screenshot to the HTML File");

		ExtendsReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + "SKIPPED");
		ExtendsReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + "SKIPPED");
	}

	public void onStart(ITestContext context) {
		logger.info("Test suite started");
		ExtendsReportUtility.setUpSparkReport("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test suite finish");
		ExtendsReportUtility.flushReport();
	}

}
