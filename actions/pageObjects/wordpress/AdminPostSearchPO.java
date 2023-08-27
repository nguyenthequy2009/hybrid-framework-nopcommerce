package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostSearchPUI;

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

	public void enterToSearchTextbox(String postTitle) {
		waitForElementVisible(driver, AdminPostSearchPUI.SEARCH_TEXTBOX);
		sendkeyToElement(driver, AdminPostSearchPUI.SEARCH_TEXTBOX, postTitle);
	}

	public void clickToSearchPostsButton() {
		waitForElementClickable(driver, AdminPostSearchPUI.SEARCH_POSTS_BUTTON);
		clickToElement(driver, AdminPostSearchPUI.SEARCH_POSTS_BUTTON);

	}

	public boolean isPostSearchTableDisplayed(String headerID, String cellValue) {
		int headerIndex = getElementSize(driver, AdminPostSearchPUI.TABLE_HEADER_INDEX_BY_HEADER_ID, headerID) + 1;
		waitForElementVisible(driver, AdminPostSearchPUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
		return isElementDisplayed(driver, AdminPostSearchPUI.TABLE_ROW_VALUE_BY_HEADER_INDEX, String.valueOf(headerIndex), cellValue);
	}

}
