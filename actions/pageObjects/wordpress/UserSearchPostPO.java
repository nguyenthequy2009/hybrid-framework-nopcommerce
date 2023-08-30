package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserSearchPostPUI;

public class UserSearchPostPO extends BasePage {
	WebDriver driver;

	public UserSearchPostPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isNothingFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, UserSearchPostPUI.NOTHING_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, UserSearchPostPUI.NOTHING_FOUND_MESSAGE, message);
	}

}
