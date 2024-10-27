package com.application.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.application.pages.BaseClass;
import com.application.pages.LoginPage;
import com.application.utilities.Helper;

public class Login extends BaseClass{
	

	
	
	@Test
	public void LoginApp() {
		
		LoginPage  loginPage = PageFactory.initElements(driver, LoginPage.class) ;
		loginPage.loginToWeb(excel.getStringData("logindata", 0, 0), excel.getStringData("logindata", 0, 1));
		Helper.captureScreenshots(driver);
		
		
	}
	
	

}
