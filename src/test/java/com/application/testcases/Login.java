package com.application.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.application.pages.BaseClass;
import com.application.pages.LoginPage;

public class Login extends BaseClass{
	

	
	
	@Test
	public void LoginApp() {
		
		logger = report.createTest("Login To App");
		LoginPage  loginPage = PageFactory.initElements(driver, LoginPage.class) ;
		
		logger.info("Start the Application");
		
		loginPage.loginToWeb(excel.getStringData("logindata", 0, 0), excel.getStringData("logindata", 0, 1));
		
		logger.pass("Logged In Successfully");		
		
	}
	
	

}
