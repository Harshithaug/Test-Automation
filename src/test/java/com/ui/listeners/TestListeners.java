package com.ui.listeners;

import java.lang.System.Logger;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;

public class TestListeners implements ITestListener {
	ExtentSparkReporter extenSparkReporter;/// create html file(look & styling)
	ExtentReports extentReport; // create heavy lify(data that needs to be dumped into html file)
	ExtentTest extenTest; // store info about test

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		extenSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//report.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(extenSparkReporter);
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();//generates the  a report in destination

	}

	public void onTestStart(ITestResult result) {
		
		extenTest= extentReport.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		extenTest.log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		extenTest.log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		Object testclass=result.getInstance();
		BrowserUtility bu = ((TestBase)testclass).getInstance();
		bu.takeScreenshot(result.getMethod().getMethodName());
	}
}
