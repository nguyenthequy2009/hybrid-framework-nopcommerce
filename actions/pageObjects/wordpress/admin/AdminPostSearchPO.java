package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminPostSearchPUI;

public class AdminPostSearchPO extends BasePage {
	WebDriver driver;

	public AdminPostSearchPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostAddNewPO clickToAddNewButton() {
		waitForElementClickable(driver, AdminPostSearchPUI.ADD_NEW_BUTTON);
		clickToElement(driver, AdminPostSearchPUI.ADD_NEW_BUTTON);
		return PageGeneratorManager_wordpress.getAdminPostAddNewPage(driver);
	}
}
