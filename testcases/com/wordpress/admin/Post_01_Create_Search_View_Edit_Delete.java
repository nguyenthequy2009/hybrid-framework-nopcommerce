package com.wordpress.admin;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.wordpress.admin.AdminDashboardPO;
import pageObjects.wordpress.admin.AdminLoginPO;
import pageObjects.wordpress.admin.AdminPostAddNewPO;
import pageObjects.wordpress.admin.AdminPostSearchPO;
import pageObjects.wordpress.admin.PageGeneratorManager_wordpress;

public class Post_01_Create_Search_View_Edit_Delete extends BaseTest {

	private String adminUsername = "quynt";
	private String adminPassword = "quynt";
	String searchPostURL;
	int randomNumber = generateFakeNumber();
	String postTitle = "Live Coding Title " + randomNumber;
	String postBody = "Live Coding Body " + randomNumber;

	@Parameters({ "browser", "urlAdmin" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition - Step 01: Open browser and Admin URL");
		driver = getBrowserDriver(browserName, appUrl);
		adminLoginPage = PageGeneratorManager_wordpress.getAdminLoginPage(driver);

		log.info("Pre-Condition - Step 02: Enter to 'USERNAME' textbox with value: " + adminUsername);
		adminLoginPage.enterToUsernameTextbox(adminUsername);

		log.info("Pre-Condition - Step 03: Enter to 'PASSWORD' textbox with value: " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-Condition - Step 04: Click to 'LOGIN' button");
		adminDashboardPage = adminLoginPage.clickToLoginButton();

	}

	@Test
	public void Post_01_Create_New_Post() {
		log.info("Create-Post - Step 01: Click to 'POST' menu link");
		adminPostSearchPage = adminDashboardPage.clickToPostMenuLink();

		log.info("Create-Post - Step 02: Get 'Search Post' Page URL");
		searchPostURL = adminPostSearchPage.getPageUrl(driver);

		log.info("Create-Post - Step 03: Click to 'ADD NEW' button");
		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton();

		log.info("Create-Post - Step 04: Enter to post title");
		adminPostAddNewPage.enterToPostTitle(postTitle);

		log.info("Create-Post - Step 05: Enter to body");
		adminPostAddNewPage.enterToPostBody(postBody);

		log.info("Create-Post - Step 06: Click to 'PUBLISH' button");
		adminPostAddNewPage.clickToPublishButton();

		log.info("Create-Post - Step 07: Click to 'CONFIRM PUBLISH' button");
		adminPostAddNewPage.clickToConfirmPublishButton();

		log.info("Create-Post - Step 08: Verify 'Post publish message' displayed");
		verifyTrue(adminPostAddNewPage.isPostPublishMessageDisplayed("Post published."));

	}

	@Test
	public void Post_02_Search_Post() {
		log.info("Search-Post - Step 01: Open 'Search Post' Page");
		adminPostSearchPage = adminPostAddNewPage.openSearchPostPageUrl(searchPostURL);

	}

	@Test
	public void Post_03_View_Post() {

	}

	@Test
	public void Post_04_Edit_Post() {

	}

	@Test
	public void Post_05_Delete_Post() {

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

}
