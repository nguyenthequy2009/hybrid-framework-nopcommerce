package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_15_ExtentReportV5 extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";
	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "Register to system with Email and Password");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to 'Register' Page");
		registerPage = homePage.openRegisterPage();

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Register new account");
		registerPage.registerNewAccount(firstName, lastName, emailAddress, password, password);

		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Verify 'Register Success Message' is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");
	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "Login to system");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to 'Login' Page");
		loginPage = homePage.openLoginPage();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Login with email = '" + emailAddress + "'" + " and password = '" + password + "'");
		homePage = loginPage.loginAsUser(emailAddress, password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Verify 'My Account Link' is displayed");
		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Navigate to 'Customer Info' Page");
		customerInfoPage = homePage.openMyAccountPage();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify 'Customer Info Page' is displayed");
		Assert.assertFalse(customerInfoPage.isCustomerInfoPageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String firstName, lastName, emailAddress, password;

}
