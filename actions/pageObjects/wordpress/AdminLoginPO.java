package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminLoginPUI;

public class AdminLoginPO extends BasePage {
	WebDriver driver;

	public AdminLoginPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToUsernameTextbox(String adminUsername) {
		waitForElementVisible(driver, AdminLoginPUI.USERNAME_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPUI.USERNAME_TEXTBOX, adminUsername);
	}

	public void enterToPasswordTextbox(String adminPassword) {
		waitForElementVisible(driver, AdminLoginPUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPUI.LOGIN_BUTTON);
		return PageGeneratorManager_wordpress.getAdminDashboardPage(driver);
	}
}
