package com.nopcommerce.user;

import org.aeonbits.owner.ConfigFactory;
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
import utilities.JSonHelper;
import utilities.Servers;

public class Level_22_Multiple_Server_II_Java_Owner_Library extends BaseTest {
	Servers server;

	@Parameters({ "browser", "environment" })
	@BeforeClass
	public void beforeClass(String browserName, String serverName) {

		ConfigFactory.setProperty("env", serverName);
		server = ConfigFactory.create(Servers.class);
		driver = getBrowserDriver(browserName, server.getAppUrl());
		
		homePage = PageGeneratorManager.getUserHomePage(driver);

		userData = JSonHelper.getUserData();

		firstName = userData.getFirstName();
		lastName = userData.getLastName();
		dayOfBirth = userData.getDate();
		monthOfBirth = userData.getMonth();
		yearOfBirth = userData.getYear();
		emailAddress = userData.getEmailAddress() + generateFakeNumberByDateTime() + "@mail.net";
		password = userData.getPassword();
	}

	@Test
	public void User_01_Register() {
		log.info("Register - Step 01: Navigate to 'Register' Page");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 02: Register new account");
		registerPage.registerNewAccount(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, emailAddress, password, password);

		log.info("Register - Step 03: Verify 'Register Success Message' is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.openHomePage();
	}

	@Test
	public void User_02_Login() {
		log.info("Login - Step 01: Navigate to 'Login' Page");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Login with email = '" + emailAddress + "'" + " and password = '" + password + "'");
		homePage = loginPage.loginAsUser(emailAddress, password);

		log.info("Login - Step 03: Verify 'My Account Link' is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_My_Account() {
		log.info("My Account - Step 01: Navigate to 'Customer Info' Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("My Account - Step 02: Verify 'Customer Info Page' is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

		log.info("My Account - Step 03: Verify 'FirstName' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("My Account - Step 04: Verify 'LastName' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("My Account - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);
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
	private String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, emailAddress, password;
	JSonHelper userData;

}
