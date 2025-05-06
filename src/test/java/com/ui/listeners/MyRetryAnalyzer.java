package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer{

private static final int MAX_RETRY_ATTEMPT=3;
private static int currentAttempt=1;

	
	
	@Override
	public boolean retry(ITestResult result) {
	if(currentAttempt<=MAX_RETRY_ATTEMPT)
	{
		currentAttempt++;
		return true;
	}
		return false;
	}

}
