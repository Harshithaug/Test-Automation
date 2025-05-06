package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.testng.annotations.BeforeMethod;

import com.ui.pages.SignInPage;
import com.utility.BrowserUtility;

public class TestBase {
	protected SignInPage signin;
	@BeforeMethod(description = "Load the homepage of website")
	public void setUp()
	{
		signin = new SignInPage(CHROME,true);
	}
	
	public BrowserUtility getInstance()
	{
		return signin;
	}

}
