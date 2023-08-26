package pageObjects.wordpress.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.admin.AdminDashboardPUI;

public class AdminDashboardPO extends BasePage {
	WebDriver driver;

	public AdminDashboardPO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminPostSearchPO clickToPostMenuLink() {
		waitForElementClickable(driver, AdminDashboardPUI.POST_MENU_LINK);
		clickToElement(driver, AdminDashboardPUI.POST_MENU_LINK);
		return PageGeneratorManager_wordpress.getAdminPostSearchPage(driver);
	}
	
}