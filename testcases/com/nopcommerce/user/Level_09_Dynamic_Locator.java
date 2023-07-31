package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointObject;

public class Level_09_Dynamic_Locator extends BaseTest {

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
	public void User_01_Register_And_Login() {
		registerPage = homePage.openRegisterPage();

		registerPage.registerNewAccount(firstName, lastName, emailAddress, password, password);
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		loginPage = homePage.openLoginPage();

		homePage = loginPage.loginAsUser(emailAddress, password);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

		customerInfoPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
		
	}

	@Test
	public void User_02_Dynamic_Page_I() {
		addressPage = (UserAddressPageObject) customerInfoPage.openPagesAtMyAccountByName(driver, "Addresses");
		
		myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openPagesAtMyAccountByName(driver, "My product reviews");
		
		rewardPointPage = (UserRewardPointObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Reward points");
		
		addressPage = (UserAddressPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "Addresses");
		
		rewardPointPage = (UserRewardPointObject) addressPage.openPagesAtMyAccountByName(driver, "Reward points");
		
		myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPagesAtMyAccountByName(driver, "My product reviews");
		
		customerInfoPage = (UserCustomerInfoPageObject) myProductReviewPage.openPagesAtMyAccountByName(driver, "Customer info");
	}
	
	@Test
	public void User_02_Dynamic_Page_II() {
		customerInfoPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		addressPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "Addresses");
		addressPage = PageGeneratorManager.getUserAddressPage(driver);
		
		addressPage.openPagesAtMyAccountByPageName(driver, "Reward points");
		rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
		
		rewardPointPage.openPagesAtMyAccountByPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
		
		myProductReviewPage.openPagesAtMyAccountByPageName(driver, "Customer info");
		customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
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
	private UserAddressPageObject addressPage;
	private UserMyProductReviewPageObject myProductReviewPage;
	private UserRewardPointObject rewardPointPage;
	private String firstName, lastName, emailAddress, password;

}
