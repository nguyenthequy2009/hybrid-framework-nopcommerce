package pageObjects.sauceLab;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.SauceLab.LoginPUI;

public class LoginPO extends BasePage {
	WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String username) {
		waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, LoginPUI.USERNAME_TEXTBOX, username);
		
	}

	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX, password);
		
	}

	public ProductPO clickToLoginButton() {
		waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPUI.LOGIN_BUTTON);
		return PageGeneratorManager_SauceLab.getProductPage(driver);
	}

}
