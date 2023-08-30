package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToAddNewPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPUI.TITLE_TEXTBOX, postTitle);
	}

	public void enterToAddNewPostBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewPUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPUI.BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddNewPUI.BODY_TEXT);
		sendkeyToElement(driver, AdminPostAddNewPUI.BODY_TEXT, postBody);
	}
	
	public void enterToEditPostBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewPUI.EDIT_BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPUI.EDIT_BODY_BUTTON);
		clearValueInElementByDeleteKey(driver, AdminPostAddNewPUI.EDIT_BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddNewPUI.EDIT_BODY_TEXT);
		sendkeyToElement(driver, AdminPostAddNewPUI.EDIT_BODY_TEXT, postBody);
	}

	public void clickToPublishOrUpdateButton() {
		waitForElementClickable(driver, AdminPostAddNewPUI.PUBLISH_OR_UPDATE_BUTTON);
		clickToElement(driver, AdminPostAddNewPUI.PUBLISH_OR_UPDATE_BUTTON);
	}
	
	public void clickToConfirmPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPUI.CONFIRM_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPUI.CONFIRM_PUBLISH_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishMessage) {
		waitForElementVisible(driver, AdminPostAddNewPUI.PUBLISHED_OR_UPDATED_MESSAGE, postPublishMessage);
		return isElementDisplayed(driver, AdminPostAddNewPUI.PUBLISHED_OR_UPDATED_MESSAGE, postPublishMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostURL) {
		openPageUrl(driver, searchPostURL);
		return PageGeneratorManager_wordpress.getAdminPostSearchPage(driver);
	}
	
}
