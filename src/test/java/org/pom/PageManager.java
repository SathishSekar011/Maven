package org.pom;

public class PageManager {
	
	
	private LoginPOM loginPOM;
	
	private SearchHotelPOM hotelPOM;
	
	public LoginPOM getLoginPOM() {
		if(loginPOM==null) {
		loginPOM = new LoginPOM();
		}
		return loginPOM;
	}
	
	public SearchHotelPOM getHotelPom() {
		if(hotelPOM==null) {
		hotelPOM = new SearchHotelPOM();
		}
		return hotelPOM;
	}

}
