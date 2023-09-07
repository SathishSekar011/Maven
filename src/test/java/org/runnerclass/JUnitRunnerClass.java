package org.runnerclass;

import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.suite.SuiteExecution;

public class JUnitRunnerClass {
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(SuiteExecution.class);
		
		List<Failure> failures = result.getFailures();
		
		for(Failure failure:failures) {
			String message = failure.getMessage();
			System.out.println(message);
		}
		
		boolean wasSuccessful = result.wasSuccessful();
		System.out.println("All test Cases Passed : "+wasSuccessful);		
	}
}
