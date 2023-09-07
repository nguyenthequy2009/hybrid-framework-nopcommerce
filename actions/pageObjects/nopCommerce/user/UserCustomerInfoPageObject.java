package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.user.UserCustomerInfoPageUI;

public class UserCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public UserCustomerInfoPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToNewLetterCheckbox() {

	}

	@Step("Verify 'Customer Info' page is displayed")
	public boolean isCustomerInfoPageDisplayed() {
		waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplayed(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_HEADER);
	}

	public boolean isCustomerInfoUpdateSuccessfulMessageDisplayed(String message) {
		waitForElementVisible(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_UPDATE_SUCCESS_MESSAGE, message);
		return isElementDisplayed(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_UPDATE_SUCCESS_MESSAGE, message);
	}

	public void clickToCloseUpdateMessageIcon() {
		waitForElementClickable(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_UPDATE_CLOSE_ICON);
		clickToElement(driver, UserCustomerInfoPageUI.CUSTOMER_INFO_UPDATE_CLOSE_ICON);
	}

	
	
}
