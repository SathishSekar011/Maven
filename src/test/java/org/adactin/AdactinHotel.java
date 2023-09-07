package org.adactin;

import org.baseclass.BaseClass;

import org.openqa.selenium.WebElement;
import org.pom.LoginPOM;
import org.pom.PageManager;
import org.pom.SearchHotelPOM;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AdactinHotel extends BaseClass {
	
	static PageManager manager;
	static SoftAssert softAssert;
	@BeforeClass
	public static void initialSetup() {
		browserLaunch("edge");
		maximize();
		loadUrl("https://adactinhotelapp.com/");
		manager = new PageManager();
		softAssert = new SoftAssert();
	}
	
	@Test
	public void loginPage() {
		LoginPOM loginPOM = manager.getLoginPOM();
		WebElement pageElement = findElement("classname", "login_title");
		String text = text(pageElement);
		//Assert.assertEquals(text, "Existing User Login - Build 1");
		
		softAssert.assertEquals(text, "qwert");
		passValues(loginPOM.getUserName(), "sathishgreens123");
		passValues(loginPOM.getPassword(), "Greens@123");
		elementClick(loginPOM.getLoginButton());
		String title = title();
		//Assert.assertEquals(title, "Adactin.com - Search Hotel");
		softAssert.assertEquals(title, "12345");
		System.out.println("Succesfully logined to user account");
		
	}
	
	@Test(dependsOnMethods="loginPage")
	public void searchHotel() {
		SearchHotelPOM hotelPom = manager.getHotelPom();
		WebElement location = hotelPom.getLocation();
		dropDown(location, "index", 2);
	}
	
	@AfterClass
	public static void quitBrowser() {
		softAssert.assertAll();
		quit();
	}
	
}
