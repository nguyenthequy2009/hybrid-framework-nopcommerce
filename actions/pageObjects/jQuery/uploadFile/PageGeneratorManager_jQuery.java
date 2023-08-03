package pageObjects.jQuery.uploadFile;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager_jQuery {
	
	public static HomePageObject getHomePage_I(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
}
