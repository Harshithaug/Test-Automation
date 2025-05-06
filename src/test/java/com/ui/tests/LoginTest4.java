package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;  // static import

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.utility.PropertiesUtil2.*;

import static com.constants.Env.*;
import com.ui.pages.SignInPage;
import com.utility.LoggerUtility;

@Listeners(com.ui.listeners.TestListeners.class)
public class LoginTest4 extends TestBase{
	
	@Test(description = "Verify the Login with valid credentials" ,groups = {"smoke","sanity"},
			retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void LoginTest() {
	
//		String Username = signin.signUp().login("fagah68980@harinv.com", "Password").getUserName();
//		assertEquals(Username, "User practice");
		//2nd way
		//assertEquals(signin.signUp().login("fagah68980@harinv.com", "Password").getUserName(), "User practice");
		Logger log = LoggerUtility.getLogger(this.getClass());
		log.info("Test Execution Started");
		assertEquals(signin.signUp().login(readProperty(QA,"username"), readProperty(QA,"pwd")).getUserName(), "User practice");
		log.info("Test Execution Ended");	
	}

}
