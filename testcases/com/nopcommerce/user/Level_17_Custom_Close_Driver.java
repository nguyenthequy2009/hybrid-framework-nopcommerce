package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";

		log.info("Register - Step 01: Navigate to 'Register' Page");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 02: Register new account");
		registerPage.registerNewAccount(firstName, lastName, emailAddress, password, password);

		log.info("Register - Step 03: Verify 'Register Success Message' is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		log.info("Login - Step 01: Navigate to 'Login' Page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Login with email = '" + emailAddress + "'" + " and password = '" + password + "'");
		homePage = loginPage.loginAsUser(emailAddress, password);

		log.info("Login - Step 03: Verify 'My Account Link' is displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 04: Navigate to 'Customer Info' Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("Login - Step 05: Verify 'Customer Info Page' is displayed");
		verifyTrue(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@Test
	public void Search_01_By_Name() {

	}

	@Test
	public void Search_02_By_Address() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String firstName, lastName, emailAddress, password;

}
