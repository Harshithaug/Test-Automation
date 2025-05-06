package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;// static import becoz which we can directly access static members without using specifying class name

import  com.constants.Env;
import com.utility.BrowserUtility;
import static com.utility.PropertiesUtil2.*;

public final class SignInPage extends BrowserUtility {

	
	private static final  By SIGN_IN_LOCATOR=By.linkText("Sign in");
	
	public SignInPage(Browser broswerName,boolean isHeadless) {
		super(broswerName,isHeadless);
		LaunchUrl(readProperty(QA,"url"));
		// TODO Auto-generated constructor stub
	}
	
	public LoginPage signUp()//called as Page Functions in page object design pattern which cannot be void
	{
		clickOn(SIGN_IN_LOCATOR);
		LoginPage login = new LoginPage(getDriver());
		return login;
	}

}
