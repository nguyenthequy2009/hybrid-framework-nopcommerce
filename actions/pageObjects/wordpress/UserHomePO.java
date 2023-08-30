package pageObjects.wordpress;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.wordpress.UserHomePUI;

public class UserHomePO extends BasePage {
	WebDriver driver;

	public UserHomePO(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isPostInfoDisplayedWithPostTitle(String postTitle) {
		waitForElementVisible(driver, UserHomePUI.POST_TITLE_TEXT, postTitle);
		return isElementDisplayed(driver, UserHomePUI.POST_TITLE_TEXT, postTitle);
	}

	public boolean isPostInfoDisplayedWithPostBody(String postTitle, String postBody) {
		waitForElementVisible(driver, UserHomePUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
		return isElementDisplayed(driver, UserHomePUI.POST_BODY_TEXT_BY_POST_TITLE, postTitle, postBody);
	}

	public boolean isPostInfoDisplayedWithAuthorName(String postTitle, String authorName) {
		waitForElementVisible(driver, UserHomePUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
		return isElementDisplayed(driver, UserHomePUI.POST_AUTHOR_TEXT_BY_POST_TITLE, postTitle, authorName);
	}

	public boolean isPostInfoDisplayedWithCurrentDay(String postTitle, String currentDay) {
		waitForElementVisible(driver, UserHomePUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
		return isElementDisplayed(driver, UserHomePUI.POST_CURRENT_DAY_TEXT_BY_POST_TITLE, postTitle, currentDay);
	}

	public UserPostDetailPO clickToPostTitle(String postTitle) {
		waitForElementClickable(driver, UserHomePUI.POST_TITLE_TEXT, postTitle);
		clickToElement(driver, UserHomePUI.POST_TITLE_TEXT, postTitle);
		return PageGeneratorManager_wordpress.getUserPostDetailPage(driver);
	}

	public boolean isPostInfoUndisplayedWithPostTitle(String editPostTitle) {
		return isElementUndisplayed(driver, UserHomePUI.POST_TITLE_TEXT, editPostTitle);
	}

	public void enterToSearchTextbox(String editPostTitle) {
		waitForElementVisible(driver, UserHomePUI.SEARCH_TEXTBOX, editPostTitle);
		sendkeyToElement(driver, UserHomePUI.SEARCH_TEXTBOX, editPostTitle);
	}

	public UserSearchPostPO clickToSearchButton() {
		waitForElementClickable(driver, UserHomePUI.SEARCH_BUTTON);
		clickToElement(driver, UserHomePUI.SEARCH_BUTTON);
		return PageGeneratorManager_wordpress.getUserSearchPostPage(driver);
	}

}
