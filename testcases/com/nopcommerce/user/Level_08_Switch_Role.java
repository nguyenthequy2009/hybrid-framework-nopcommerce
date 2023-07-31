package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.admin.AdminDashboardPageObject;
import pageObjects.nopCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_08_Switch_Role extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		userEmailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		userPassword = "123456";
		adminEmailAddress = "admin@yourstore.com";
		adminPassword = "admin";

		userRegisterPage = userHomePage.openRegisterPage();

		userRegisterPage.registerNewAccount(firstName, lastName, userEmailAddress, userPassword, userPassword);

		Assert.assertEquals(userRegisterPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Role_01_User_To_Admin() {
		userLoginPage = userHomePage.openLoginPage();
		userHomePage = userLoginPage.loginAsUser(userEmailAddress, userPassword);
		Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
		
		userCustomerInfoPage = userHomePage.openMyAccountPage();
		userHomePage = userCustomerInfoPage.clickToLogOutLinkAtUserPage(driver);
		
		userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
		Assert.assertTrue(adminDashboardPage.isDashboardHeaderDisplayed());
		
		adminLoginPage = adminDashboardPage.clickToLogOutLinkAtAdminPage(driver);
	}

	@Test
	public void Role_02_Admin_To_User() {
		adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject userHomePage;
	private UserLoginPageObject userLoginPage;
	private UserRegisterPageObject userRegisterPage;
	private UserCustomerInfoPageObject userCustomerInfoPage;
	private AdminLoginPageObject adminLoginPage;
	private AdminDashboardPageObject adminDashboardPage;
	private String userEmailAddress, userPassword, adminEmailAddress, adminPassword, firstName, lastName;

}
