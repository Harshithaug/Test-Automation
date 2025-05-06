package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {
	
	
	
	private static final By EMAIL_LOCATOR=By.id("email");
	private static final By PASSWORD_LOCATOR=By.id("passwd");  
	private static final By SUBMIT_LOGIN_LOCATOR=By.xpath("//button[@id=\"SubmitLogin\"]");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public MyAccountPage login(String un,String pwd)
	{
		entertext(EMAIL_LOCATOR, un);
		entertext(PASSWORD_LOCATOR, pwd);
		clickOn(SUBMIT_LOGIN_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}
	
	
	

}
