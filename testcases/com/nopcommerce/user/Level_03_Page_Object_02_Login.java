package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_03_Page_Object_02_Login {
	private WebDriver driver;
	private String firstName, lastName, existingEmail, invalidEmail, notFoundEmail, validPassword, incorrectPassword;
	private String projectPath = System.getProperty("user.dir");

	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		existingEmail = "afc" + generateFakeNumber() + "@mail.vn";
		invalidEmail = "afc@afc.com@.vn";
		notFoundEmail = "afcc" + generateFakeNumber() + "@mail.net";
		validPassword = "123456";
		incorrectPassword = "654321";

		System.out.println("Pre-Condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		System.out.println("Pre-Condition - Step 02: Input to Required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Pre-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Pre-Condition - Step 04: Verify success message displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Login_01_Empty_Data() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Please enter your email");
	}

	@Test
	public void Login_02_Invalid_Email() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Email_Not_Found() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(incorrectPassword);

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Login_Success() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);

		loginPage.clickToLoginButton();
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		return new Random().nextInt(9999);
	}

}
