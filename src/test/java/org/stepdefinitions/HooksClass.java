package org.stepdefinitions;

import org.baseclass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class HooksClass extends BaseClass {
	
	@Before
	public void initial() {
		System.out.println("@Before");
	}
	
	@After
	public void tearDown(Scenario scenario) {
		System.out.println("@After");
		//if (scenario.isFailed()) {
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotAs, "image/png", scenario.getName());
		//}
		driver.quit();
	}
	
	@BeforeStep
	public void beforeEveryStep() {
		System.out.println("@BeforeStep");
	}
	
	@AfterStep
	public void afterEveryStep(Scenario scenario) {
		System.out.println("@AfterStep");
//		if (scenario.isFailed()) {
//			TakesScreenshot screenshot = (TakesScreenshot) driver;
//			byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshotAs, "image/png", scenario.getName());
//		}
	}

}
