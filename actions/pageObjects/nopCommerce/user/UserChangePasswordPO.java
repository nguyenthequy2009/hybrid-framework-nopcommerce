package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;

public class UserChangePasswordPO extends BasePage {
	private WebDriver driver;

	public UserChangePasswordPO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isChangePasswordSuccessfulMessageDisplayed(String message) {
		waitForElementVisible(driver, BasePageNopCommerceUI.SUCCESSFUL_MESSAGE, message);
		return isElementDisplayed(driver, BasePageNopCommerceUI.SUCCESSFUL_MESSAGE, message);
	}

	public void clickToCloseChangePasswordSuccessfulMessageIcon() {
		waitForElementClickable(driver, BasePageNopCommerceUI.CLOSE_MESSAGE_ICON);
		clickToElement(driver, BasePageNopCommerceUI.CLOSE_MESSAGE_ICON);
		sleepInSecond(1);
	}

}
