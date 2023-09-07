package org.testngpractice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.pom.FacebookPOM;
import org.pom.LoginPOM;
import org.pom.PageManager;
import org.pom.SearchHotelPOM;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.channel.ChannelOption;

public class TestCases extends BaseClass {

	int a = 1;

	@Test()
	private void tc1() {
		browserLaunch("chrome");
		loadUrl("https://www.facebook.com/");
		FacebookPOM pom = new FacebookPOM();
		passValues(pom.getUserName(), "TestCase 1");
		passValues(pom.getPassword(), "8766");
		Actions actions = new Actions(driver);
		
	}

	@Test()
	private void tc() {
		browserLaunch("edge");
		loadUrl("https://www.facebook.com/");
		FacebookPOM pom = new FacebookPOM();
		passValues(pom.getUserName(), "Test Case 2");
		passValues(pom.getPassword(), "1234");
	}

	@Test()
	private void tc2() {
		browserLaunch("chrome");
		loadUrl("https://www.facebook.com/");
		FacebookPOM pom = new FacebookPOM();
		passValues(pom.getUserName(), "Failed Case");
		if (a < 2) {
			a++;
			Assert.assertTrue(false);
		}
		passValues(pom.getPassword(), "1234");
	}

}
