package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager_jQuery {
	
	public static HomePageObject_I getHomePage_I(WebDriver driver) {
		return new HomePageObject_I(driver);
	}
	
	public static HomePageObject_II getHomePage_II(WebDriver driver) {
		return new HomePageObject_II(driver);
	}
	
}
