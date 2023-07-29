package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewPageObject;
import pageObjects.AddressPageObject;
import pageObjects.CustomerInfoPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;
import pageObjects.RewardPointObject;

public class Level_07_Switch_Page extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		firstName = "Automation";
		lastName = "FC";
		email = "afc" + generateFakeNumber() + "@mail.vn";
		password = "123456";
	}

	@Test
	public void User_01_Register() {
		registerPage = homePage.openRegisterPage();

		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login() {
		loginPage = homePage.openLoginPage();

		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);

		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void User_03_Customer_Info() {
		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
		
	}

	@Test
	public void User_04_Switch_Page() {
		addressPage = customerInfoPage.openAddressPage(driver);
		
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		
		addressPage = rewardPointPage.openAddressPage(driver);
		
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
		
		customerInfoPage = myProductReviewPage.openCustomerInfoPage(driver);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressPageObject addressPage;
	private MyProductReviewPageObject myProductReviewPage;
	private RewardPointObject rewardPointPage;
	private String firstName, lastName, email, password;

}
