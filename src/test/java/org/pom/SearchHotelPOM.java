package org.pom;

import org.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPOM extends BaseClass {
	
	public SearchHotelPOM() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="hotels")
	private WebElement hotel;
	@FindBy(id="room_type")
	private WebElement roomType;
	@FindBy(id="no_of_rooms")
	private WebElement noOfRooms;
	@FindBy(id="chek-in date")
	private WebElement inDate;
	@FindBy(name="username_show")
	private WebElement welcomeUser;
	
	public WebElement getLocation() {
		return location;
	}
	
	public WebElement getHotel() {
		return hotel;
	}
	
	public WebElement getRoomType() {
		return roomType;
	}
	
	public WebElement getNoOfRooms() {
		return noOfRooms;
	}
	
	public WebElement getInDate() {
		return inDate;
	}
	
	public WebElement getWelcomeUser() {
		return welcomeUser;
	}

}
