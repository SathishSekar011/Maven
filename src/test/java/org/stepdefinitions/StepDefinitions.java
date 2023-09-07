package org.stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.baseclass.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitions extends BaseClass {
	
	
	@Given("Facebook URL Launched")
	public void facebook_url_launched() {
		browserLaunch("Edge");
		maximize();
		loadUrl("https://www.facebook.com/");
	}

	@When("User Enters Username")
	public void user_enters_username() {
		WebElement userName = findElement("id", "email");
		passValues(userName, "Sathish Greens");
	}

	@Then("TakeScreenshot")
	public void take_screenshot() throws IOException {
		File file = new File(
				"C:\\Users\\Lenovo\\eclipse-workspace\\LanuageDetails\\MavenProject\\target\\cucumber.png");
		screnshot(file);
	}

	@Given("Facebook URL Launched in chrome")
	public void facebook_url_launched_in_chrome() {

		browserLaunch("chrome");
		maximize();
		loadUrl("https://www.facebook.com/");
	}

	@When("User Enters UserName and Password")
	public void user_enters_user_name_and_password(DataTable dataTable) {
		
		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map1 = asMaps.get(0);
		Map<String, String> map2 = asMaps.get(1);
		Map<String, String> map3 = asMaps.get(2);
		
		String string = map3.get("password");
		WebElement userName = findElement("id", "email");
		passValues(userName, string);
	}

//	@Then("TakeSnap")
//	public void take_snap() throws IOException {
////		File file = new File(
////				"C:\\Users\\Lenovo\\eclipse-workspace\\LanuageDetails\\MavenProject\\target\\cucumber2.png");
////		screnshot(file);
//	}

	@When("User Enters {string} and {string}")
	public void user_enters_and(String string, String string2) {
		WebElement userName = findElement("id", "email");
		
		passValues(userName, string);
		WebElement password = findElement("id","pass");
		passValues(password, string2);
		if(string.equals("sathish")) {
			Assert.assertTrue(false);
		}
	}

	@Given("Facebook URL Launched {string}")
	public void facebook_url_launched(String string) {
		browserLaunch(string);
		maximize();
		loadUrl("https://www.facebook.com/");
	}

	@Given("Background Execution")
	public void background_execution() {
	   System.out.println("Background is Executed");
	}







	
	
}
