package com.application.pages;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.application.utilities.BrowserFactory;
import com.application.utilities.ConfigDataProvider;
import com.application.utilities.ExcelDataProvider;
import com.application.utilities.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	
	@BeforeSuite
	public void setupSuite() {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();

		
	}
	
	@BeforeClass
	public void setup() {
		driver =  BrowserFactory.startApplication(driver, config.getBrowser(), config.getqaUrl()) ;
	}
	
	
	
	@AfterClass
	public void tearDwon() {
		BrowserFactory.quit(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenshots(driver);
		}
	}
	
	
	

}
