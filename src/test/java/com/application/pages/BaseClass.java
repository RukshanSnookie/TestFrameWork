package com.application.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.application.utilities.BrowserFactory;
import com.application.utilities.ConfigDataProvider;
import com.application.utilities.ExcelDataProvider;
import com.application.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite() {
		
		Reporter.log("Setting up reports - Test ready", true);
		
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir") + "/Reports/" + Helper.getCurrentDateTime() + "_LoginReport.html"));

		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Config Done - Test Started", true);

	}
	
	@BeforeClass
	public void setup() {
		Reporter.log("Starting browser - Browser Ready", true);

		driver =  BrowserFactory.startApplication(driver, config.getBrowser(), config.getqaUrl()) ;
		
		Reporter.log("Browser Running", true);

	}
	
	
	
	@AfterClass
	public void tearDwon() {
		BrowserFactory.quit(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		Reporter.log("Test is about to end", true);

		
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.skip("Test skiped", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshots(driver)).build());
		}
		
		report.flush();
		
		Reporter.log("Test done - Reports generated", true);

	}
	
	
	

}
