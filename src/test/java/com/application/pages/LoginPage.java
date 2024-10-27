package com.application.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	
	public LoginPage(WebDriver lDriver) {
		
		this.driver =  lDriver;
		
	}
	
	
	@FindBy(name="user-name") WebElement username;
	
	
	@FindBy(name="password") WebElement password;
	
	
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	
	public void loginToWeb(String applicationUserName, String applicationPassword) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

		}
		
		username.sendKeys(applicationUserName);
		password.sendKeys(applicationPassword);
		loginButton.click();
	}
	
}
