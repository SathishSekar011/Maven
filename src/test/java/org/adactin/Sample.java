package org.adactin;

import org.baseclass.BaseClass;

import org.pom.FacebookPOM;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Sample extends BaseClass {
	
	@Test(dataProvider="inputDatas",groups="Sanity")
	public void sampleTest1(String browser,String userName,String password) {
		browserLaunch(browser);
		loadUrl("https://www.facebook.com/");
		FacebookPOM pom = new FacebookPOM();
		passValues(pom.getUserName(), userName);
		passValues(pom.getPassword(),password);
		
	}
	
	@DataProvider(name="inputDatas")
	public Object[][] data(){
		return new Object[][] {
			{"firefox","Sathish Greens","123"},
			{"chrome","Sababathy","65434"},
			{"edge","Yogi","9876"}
		};	
	}
	
	
	@Parameters("browser2")
	@Test(groups="Smoke")
	public void sampleTest2(String browser) {
		browserLaunch(browser);
		loadUrl("https://www.facebook.com/");
		FacebookPOM pom = new FacebookPOM();
		passValues(pom.getUserName(), "Smoke Testing");
		
	}
	@Parameters("browser")
	@Test(groups="Regression")
	public void sampleTest3(@Optional("chrome")String browser) {
		browserLaunch(browser);
		loadUrl("https://www.facebook.com/");
		FacebookPOM pom = new FacebookPOM();
		passValues(pom.getUserName(), "Regression Testing");
		
	}
	@Test(groups= {"Sanity","Regression"})
	public void sampleTest4() {
		browserLaunch("edge");
		loadUrl("https://www.facebook.com/");
		FacebookPOM pom = new FacebookPOM();
		passValues(pom.getUserName(), "Sanity and Regression Testing");
		
	}
	@Test(groups= {"Smoke","Regression"})
	public void sampleTest5() {
		browserLaunch("edge");
		loadUrl("https://www.facebook.com/");
		FacebookPOM pom = new FacebookPOM();
		passValues(pom.getUserName(), "Smoke and Regression testing");
		
	}

}
