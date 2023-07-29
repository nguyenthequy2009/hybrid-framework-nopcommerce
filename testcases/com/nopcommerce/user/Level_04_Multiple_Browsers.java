package com.nopcommerce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Multiple_Browsers extends BaseTest {
	private WebDriver driver;
	String firstName, lastName, emailAddress, password;

	HomePageObject homePage;
	RegisterPageObject registerPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = new HomePageObject(driver);

		firstName = "Automation";
		lastName = "FC";
		emailAddress = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";
	}

	@Test
	public void Register_01_Empty_Data() {
//		System.out.println("Register_01 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_01 - Step 02: Input to Required fields");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_01 - Step 03: Verify error message displayed");
//		Assert.assertEquals(registerPage.getErrorMessageAtFirstnameTextbox(), "First name is required.");
//		Assert.assertEquals(registerPage.getErrorMessageAtLastnameTextbox(), "Last name is required.");
//		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Email is required.");
//		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password is required.");
//		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "Password is required.");

	}

	@Test
	public void Register_02_Invalid_Data() {
//		System.out.println("Register_02 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_02 - Step 02: Input to Required fields");
//		registerPage.inputToFirstnameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox("123@123!@#");
//		registerPage.inputToPasswordTextbox(password);
//		registerPage.inputToConfirmPasswordTextbox(password);
//
//		System.out.println("Register_02 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_02 - Step 04: Verify error message displayed");
//		Assert.assertEquals(registerPage.getErrorMessageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Register_03_Register_Success() {
//		System.out.println("Register_03 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_03 - Step 02: Input to Required fields");
//		registerPage.inputToFirstnameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox(emailAddress);
//		registerPage.inputToPasswordTextbox(password);
//		registerPage.inputToConfirmPasswordTextbox(password);
//
//		System.out.println("Register_03 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_03 - Step 04: Verify success message displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void Register_04_Existing_Email() {
//		System.out.println("Register_04 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_04 - Step 02: Input to Required fields");
//		registerPage.inputToFirstnameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox(emailAddress);
//		registerPage.inputToPasswordTextbox(password);
//		registerPage.inputToConfirmPasswordTextbox(password);
//
//		System.out.println("Register_04 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_04 - Step 04: Verify error message displayed");
//		Assert.assertEquals(registerPage.getEmailExistingErrorMessage(), "The specified email already exists");

	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
//		System.out.println("Register_05 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_05 - Step 02: Input to Required fields");
//		registerPage.inputToFirstnameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox(emailAddress);
//		registerPage.inputToPasswordTextbox("123");
//		registerPage.inputToConfirmPasswordTextbox("123");
//
//		System.out.println("Register_05 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_05 - Step 04: Verify error message displayed");
//		Assert.assertEquals(registerPage.getErrorMessageAtPasswordTextbox(), "Password must meet the following rules:\nmust have at least 6 characters");

	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
//		System.out.println("Register_06 - Step 01: Click to Register link");
//		homePage.clickToRegisterLink();
//		registerPage = new RegisterPageObject(driver);
//
//		System.out.println("Register_06 - Step 02: Input to Required fields");
//		registerPage.inputToFirstnameTextbox(firstName);
//		registerPage.inputToLastnameTextbox(lastName);
//		registerPage.inputToEmailTextbox(emailAddress);
//		registerPage.inputToPasswordTextbox(password);
//		registerPage.inputToConfirmPasswordTextbox(emailAddress);
//
//		System.out.println("Register_06 - Step 03: Click to Register button");
//		registerPage.clickToRegisterButton();
//
//		System.out.println("Register_06 - Step 04: Verify error message displayed");
//		Assert.assertEquals(registerPage.getErrorMessageAtConfirmPasswordTextbox(), "The password and confirmation password do not match.");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int generateFakeNumber() {
		return new Random().nextInt(9999);
	}

}
