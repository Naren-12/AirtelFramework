package com.comcast.crm.listernerUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	int count = 0;
	int retry = 4;
	@Override
	public boolean retry(ITestResult result) {
		if(retry>count) {
			count++;
			return true;
		}
		return false;
	}
	
	
}
