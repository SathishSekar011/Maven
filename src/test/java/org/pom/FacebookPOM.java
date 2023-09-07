package org.pom;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookPOM extends BaseClass {
	
	public FacebookPOM() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(id="email")
	private WebElement userName;
	@FindBy(id="pass")
	private WebElement password;
	@FindBy(name="login")
	private WebElement login;

	public WebElement getUserName() {
		return userName;
	}

	public WebElement getPassword() {
		return password;
	}

	
	public WebElement getLogin() {
		return login;
	}

}
