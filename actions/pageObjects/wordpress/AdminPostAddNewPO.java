package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.AdminPostAddNewPUI;

public class AdminPostAddNewPO extends BasePage {
	WebDriver driver;

	public AdminPostAddNewPO(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToPostTitle(String postTitle) {
		waitForElementVisible(driver, AdminPostAddNewPUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminPostAddNewPUI.TITLE_TEXTBOX, postTitle);
	}

	public void enterToPostBody(String postBody) {
		waitForElementClickable(driver, AdminPostAddNewPUI.BODY_BUTTON);
		clickToElement(driver, AdminPostAddNewPUI.BODY_BUTTON);
		
		waitForElementVisible(driver, AdminPostAddNewPUI.BODY_TEXT);
		sendkeyToElement(driver, AdminPostAddNewPUI.BODY_TEXT, postBody);
	}

	public void clickToPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPUI.PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPUI.PUBLISH_BUTTON);
	}
	
	public void clickToConfirmPublishButton() {
		waitForElementClickable(driver, AdminPostAddNewPUI.CONFIRM_PUBLISH_BUTTON);
		clickToElement(driver, AdminPostAddNewPUI.CONFIRM_PUBLISH_BUTTON);
	}

	public boolean isPostPublishMessageDisplayed(String postPublishMessage) {
		waitForElementVisible(driver, AdminPostAddNewPUI.PUBLISH_MESSAGE, postPublishMessage);
		return isElementDisplayed(driver, AdminPostAddNewPUI.PUBLISH_MESSAGE, postPublishMessage);
	}

	public AdminPostSearchPO openSearchPostPageUrl(String searchPostURL) {
		openPageUrl(driver, searchPostURL);
		return PageGeneratorManager_wordpress.getAdminPostSearchPage(driver);
	}
	
}
