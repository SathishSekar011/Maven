package org.testngpractice;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class FailureRerun implements IRetryAnalyzer {
	int min=1;
	int max=3;
	@Override
	public boolean retry(ITestResult result) {
		if(min<=max) {
			min++;
			return true;
		}
		return false;
	}
	
}
