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

	public AdminPostAddNewPO clickToPostTitleLink(String editPostTitle) {
		waitForElementClickable(driver, AdminPostSearchPUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, editPostTitle);
		clickToElement(driver, AdminPostSearchPUI.ROW_TITLE_DETAIL_BY_TITLE_NAME, editPostTitle);
		return PageGeneratorManager_wordpress.getAdminPostAddNewPage(driver);
	}

	public void selectPostCheckboxByPostTitle(String editPostTitle) {
		waitForElementClickable(driver, AdminPostSearchPUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
		checkToDefaultCheckboxOrRadio(driver, AdminPostSearchPUI.ROW_CHECKBOX_BY_TITLE_NAME, editPostTitle);
	}

	public void selectTextItemInActionDropdown(String dropdownItem) {
		waitForElementClickable(driver, AdminPostSearchPUI.ACTION_DROPDOWN);
		selectItemInDefaultDropdown(driver, AdminPostSearchPUI.ACTION_DROPDOWN, dropdownItem);
	}

	public void clickToApplyButton() {
		waitForElementClickable(driver, AdminPostSearchPUI.APPLY_BUTTON);
		clickToElement(driver, AdminPostSearchPUI.APPLY_BUTTON);
	}

	public boolean isMoveToTrashSucccessMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPUI.MOVE_TO_TRASH_SUCCESS_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPUI.MOVE_TO_TRASH_SUCCESS_MESSAGE, message);
	}

	public boolean isNoPostsFoundMessageDisplayed(String message) {
		waitForElementVisible(driver, AdminPostSearchPUI.NO_POST_FOUND_MESSAGE, message);
		return isElementDisplayed(driver, AdminPostSearchPUI.NO_POST_FOUND_MESSAGE, message);
	}

}
