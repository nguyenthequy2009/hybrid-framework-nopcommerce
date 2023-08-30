package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.AdminDashboardPO;
import pageObjects.wordpress.AdminLoginPO;
import pageObjects.wordpress.AdminPostAddNewPO;
import pageObjects.wordpress.AdminPostSearchPO;
import pageObjects.wordpress.PageGeneratorManager_wordpress;
import pageObjects.wordpress.UserHomePO;
import pageObjects.wordpress.UserPostDetailPO;
import pageObjects.wordpress.UserSearchPostPO;

public class Post_01_Create_Search_View_Edit_Delete extends BaseTest {

	private String adminUsername = "quynt";
	private String adminPassword = "quynt";
	String searchPostURL;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;
	String editPostTitle = "Edit Title " + randomNumber;
	String editPostBody = "Edit Body " + randomNumber;
	String authorName = "Quy NT";
	String adminUrl, endUserUrl;
	String currentDay = getCurrentDay();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminUrl, String endUserUrl) {
		log.info("Pre-Condition - Step 01: Open browser and Admin Site");
		this.adminUrl = adminUrl;
		this.endUserUrl = endUserUrl;
		driver = getBrowserDriver(browserName, this.adminUrl);
		adminLoginPage = PageGeneratorManager_wordpress.getAdminLoginPage(driver);

		log.info("Pre-Condition - Step 02: Enter to 'USERNAME' textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-Condition - Step 03: Enter to 'PASSWORD' textbox with value: " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-Condition - Step 04: Click to 'Login' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create-Post - Step 01: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Create-Post - Step 02: Get 'Search Post' Page URL");
		searchPostURL = adminPostSearchPage.getPageUrl(driver);

		log.info("Create-Post - Step 03: Click to 'Add New' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create-Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToAddNewPostTitle(postTitle);

		log.info("Create-Post - Step 05: Enter to post body");
		adminPostAddNewPage.enterToAddNewPostBody(postBody);

		log.info("Create-Post - Step 06: Click to 'Publish' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Create-Post - Step 07: Click to 'CONFIRM PUBLISH' button");
		adminPostAddNewPage.clickToConfirmPublishButton();

		log.info("Create-Post - Step 08: Verify 'Post published.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));

	}

	@Test
	public void Post_02_Search_And_View_Post() {
		log.info("Search-Post - Step 01: Open 'Search Post' Page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostURL);

		log.info("Search-Post - Step 02: Enter to 'SEARCH' textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Search-Post - Step 03: Click to 'Search posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Search-Post - Step 04: Verify search table contains '" + postTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", postTitle));

		log.info("Search-Post - Step 05: Verify search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Search-Post - Step 06: Open 'END USER' Site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Search-Post - Step 07: Verify Post info displayed at Home Page");
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userHomePage.isPostInfoDisplayedWithAuthorName(postTitle, authorName));
		verifyTrue(userHomePage.isPostInfoDisplayedWithCurrentDay(postTitle, currentDay));

		log.info("Search-Post - Step 08: Click to Post Title");
		userPostDetailPage = userHomePage.clickToPostTitle(postTitle);

		log.info("Search-Post - Step 09: Verify Post info displayed at 'Post Detail' Page");
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(postTitle));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(postTitle, postBody));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithAuthorName(postTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithCurrentDay(postTitle, currentDay));

	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Edit-Post - Step 01: Open 'ADMIN' Site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);

		log.info("Edit-Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Edit-Post - Step 03: Enter to 'SEARCH' textbox");
		adminPostSearchPage.enterToSearchTextbox(postTitle);

		log.info("Edit-Post - Step 04: Click to 'Search posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Edit-Post - Step 05: Click to Post Title link and navigate to 'Edit Post' Page");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(postTitle);

		log.info("Edit-Post - Step 06: Enter to Post Title");
		adminPostAddNewPage.enterToAddNewPostTitle(editPostTitle);

		log.info("Edit-Post - Step 07: Enter to Post Body");
		adminPostAddNewPage.enterToEditPostBody(editPostBody);

		log.info("Edit-Post - Step 08: Click to 'Update' button");
		adminPostAddNewPage.clickToPublishOrUpdateButton();

		log.info("Edit-Post - Step 09: Verify 'Post update.' message is displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post updated."));

		log.info("Edit-Post - Step 10: Open 'Search Post' Page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostURL);

		log.info("Edit-Post - Step 11: Enter to 'SEARCH' textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Edit-Post - Step 12: Click to 'Search posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Edit-Post - Step 13: Verify search table contains '" + editPostTitle + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("title", editPostTitle));

		log.info("Edit-Post - Step 14: Verify search table contains '" + authorName + "'");
		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayed("author", authorName));

		log.info("Edit-Post - Step 15: Open 'END USER' Site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Edit-Post - Step 16: Verify Post info displayed at Home Page");
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userHomePage.isPostInfoDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userHomePage.isPostInfoDisplayedWithAuthorName(editPostTitle, authorName));
		verifyTrue(userHomePage.isPostInfoDisplayedWithCurrentDay(editPostTitle, currentDay));

		log.info("Edit-Post - Step 08: Click to Post Title");
		userPostDetailPage = userHomePage.clickToPostTitle(editPostTitle);

		log.info("Edit-Post - Step 09: Verify Post info displayed at 'Post Detail' Page");
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostTitle(editPostTitle));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithPostBody(editPostTitle, editPostBody));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithAuthorName(editPostTitle, authorName));
		verifyTrue(userPostDetailPage.isPostInfoDisplayedWithCurrentDay(editPostTitle, currentDay));

	}

	@Test
	public void Post_04_Delete_Post() {
		log.info("Delete-Post - Step 01: Open 'ADMIN' Site");
		adminDashboardPage = userPostDetailPage.openAdminSite(driver, this.adminUrl);

		log.info("Delete-Post - Step 02: Click to 'Posts' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Delete-Post - Step 03: Enter to 'Search' textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete-Post - Step 04: Click to 'Search posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Delete-Post - Step 05: Select Post Detail checkbox");
		adminPostSearchPage.selectPostCheckboxByPostTitle(editPostTitle);

		log.info("Delete-Post - Step 06: Select 'Move to Trash' item in dropdown");
		adminPostSearchPage.selectTextItemInActionDropdown("Move to Trash");

		log.info("Delete-Post - Step 07: Clcik to 'Apply' button");
		adminPostSearchPage.clickToApplyButton();

		log.info("Delete-Post - Step 08: Verify '1 post moved to the Trash.' message is displayed");
		verifyTrue(adminPostSearchPage.isMoveToTrashSucccessMessageDisplayed("1 post moved to the Trash."));

		log.info("Delete-Post - Step 09: Enter to 'SEARCH' textbox");
		adminPostSearchPage.enterToSearchTextbox(editPostTitle);

		log.info("Delete-Post - Step 10: Click to 'Search posts' button");
		adminPostSearchPage.clickToSearchPostsButton();

		log.info("Delete-Post - Step 11: Verify 'No posts found.' message is displayed");
		verifyTrue(adminPostSearchPage.isNoPostsFoundMessageDisplayed("No posts found."));

		log.info("Delete-Post - Step 12: Open 'END USER' Site");
		userHomePage = adminPostSearchPage.openEndUserSite(driver, this.endUserUrl);

		log.info("Delete-Post - Step 13: Verify Post Title is undisplayed");
		verifyTrue(userHomePage.isPostInfoUndisplayedWithPostTitle(editPostTitle));

		log.info("Delete-Post - Step 14: Enter to 'Search' textbox");
		userHomePage.enterToSearchTextbox(editPostTitle);

		log.info("Delete-Post - Step 15: Click to 'Search' button");
		userSearchPostPage = userHomePage.clickToSearchButton();

		log.info("Delete-Post - Step 16: Verify 'Nothing Found' message is displayed");
		verifyTrue(userSearchPostPage.isNothingFoundMessageDisplayed("Nothing Found"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private AdminPostSearchPO adminPostSearchPage;
	private UserHomePO userHomePage;
	private UserPostDetailPO userPostDetailPage;
	private UserSearchPostPO userSearchPostPage;

}
