package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerce.user.BasePageNopCommerceUI;
import pageUIs.nopCommerce.user.UserAddressPageUI;

public class UserAddressPageObject extends BasePage {
	WebDriver driver;

	public UserAddressPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForCountryDropdownValueIsSelected() {
		waitForAllElementInvisible(driver, UserAddressPageUI.WAIT_ICON);
	}

	public boolean isAddNewAddressSuccessfulMessageDisplayed(String message) {
		waitForElementVisible(driver, BasePageNopCommerceUI.SUCCESSFUL_MESSAGE, message);
		return isElementDisplayed(driver, BasePageNopCommerceUI.SUCCESSFUL_MESSAGE, message);
	}

	public void clickToCloseAddNewSuccessfulMessageIcon() {
		waitForElementClickable(driver, BasePageNopCommerceUI.CLOSE_MESSAGE_ICON);
		clickToElement(driver, BasePageNopCommerceUI.CLOSE_MESSAGE_ICON);
	}

	public String getAddressInfoByClass( String dynamicClass) {
		waitForElementVisible(driver, UserAddressPageUI.DYNAMIC_ADDRESS_INFO_BY_CLASS, dynamicClass);
		return getElementText(driver, UserAddressPageUI.DYNAMIC_ADDRESS_INFO_BY_CLASS, dynamicClass);
	}
	
}
