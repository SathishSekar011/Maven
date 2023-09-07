package org.testngpractice;

import org.testng.ITestContext;
import org.testng.ITestListener;



public class CutomReports implements ITestListener{
	
	@Override
	public void onStart(ITestContext context) {
		System.out.println("################");
		ITestListener.super.onStart(context);
	}

}
