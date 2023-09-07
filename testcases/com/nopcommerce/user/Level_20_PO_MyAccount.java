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
import utilities.DataFaker;

public class Level_20_PO_MyAccount extends BaseTest {

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		dataFaker = DataFaker.getDataFaker();

		firstName = dataFaker.getFirstName();
		lastName = dataFaker.getLastName();
		dayOfBirth = "10";
		monthOfBirth = "August";
		yearOfBirth = "1993";
		emailAddress = dataFaker.getEmailAddress();
		password = dataFaker.getPassword();

		editGender = "Female";
		editFirstName = "Automation";
		editLastName = "FC";
		editDayOfBirth = "1";
		editMonthOfBirth = "January";
		editYearOfBirth = "1999";
		editEmailAddress = dataFaker.getEmailAddress();
		editCompanyName = "Automation Company";

		log.info("Pre-Condition - Step 01: Navigate to 'Register' Page");
		registerPage = homePage.openRegisterPage();

		log.info("Pre-Condition - Step 02: Register new account");
		registerPage.registerNewAccount(firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, emailAddress, password, password);

		log.info("Pre-Condition - Step 03: Verify 'Register Success Message' is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.openHomePage();

		log.info("Pre-Condition - Step 04: Navigate to 'Login' Page");
		loginPage = homePage.openLoginPage();

		log.info("Pre-Condition - Step 05: Login with email = '" + emailAddress + "'" + " and password = '" + password + "'");
		homePage = loginPage.loginAsUser(emailAddress, password);

		log.info("Pre-Condition - Step 06: Verify 'My Account Link' is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void MyAccount_01_Update_Info() {
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

		log.info("My Account - Step 06: Update Customer Gender = " + editGender);
		customerInfoPage.clickToRadioButtonByLabel(driver, editGender);

		log.info("My Account - Step 07: Update Customer FirstName = " + editFirstName);
		customerInfoPage.inputToTextboxByID(driver, "FirstName", editFirstName);

		log.info("My Account - Step 08: Update Customer LastName = " + editLastName);
		customerInfoPage.inputToTextboxByID(driver, "LastName", editLastName);

		log.info("My Account - Step 09: Update Customer DateOfBirth = " + editDayOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthDay", editDayOfBirth);

		log.info("My Account - Step 10: Update Customer MonthOfBirth = " + editMonthOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthMonth", editMonthOfBirth);

		log.info("My Account - Step 11: Update Customer YearOfBirth = " + editYearOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthYear", editYearOfBirth);

		log.info("My Account - Step 12: Update Customer Email Address = " + editEmailAddress);
		customerInfoPage.inputToTextboxByID(driver, "Email", editEmailAddress);

		log.info("My Account - Step 13: Update Customer Company Name = " + editCompanyName);
		customerInfoPage.inputToTextboxByID(driver, "Company", editCompanyName);

		log.info("My Account - Step 14: Click Save button");
		customerInfoPage.clickToButtonByText(driver, "Save");

		log.info("My Account - Step 15: Verify Update successful message");
		verifyTrue(customerInfoPage.isCustomerInfoUpdateSuccessfulMessageDisplayed("The customer info has been updated successfully."));

		log.info("My Account - Step 16: Click close Update successful message icon");
		customerInfoPage.clickToCloseUpdateMessageIcon();

		log.info("My Account - Step 17: Verify 'Gender' edit is correctly");
		Assert.assertTrue(customerInfoPage.isRadioButtonSelectedByLabel(driver, editGender));

		log.info("My Account - Step 18: Verify 'FirstName' edit is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), editFirstName);

		log.info("My Account - Step 19: Verify 'LastName' edit is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), editLastName);

		log.info("My Account - Step 20: Verify 'DateOfBirth' edit is correctly");
		Assert.assertEquals(customerInfoPage.getFirstSelectedItemInDefaultDropdownByName(driver, "DateOfBirthDay"), editDayOfBirth);

		log.info("My Account - Step 21: Verify 'MonthOfBirth' edit is correctly");
		Assert.assertEquals(customerInfoPage.getFirstSelectedItemInDefaultDropdownByName(driver, "DateOfBirthMonth"), editMonthOfBirth);

		log.info("My Account - Step 22: Verify 'YearOfBirth' edit is correctly");
		Assert.assertEquals(customerInfoPage.getFirstSelectedItemInDefaultDropdownByName(driver, "DateOfBirthYear"), editYearOfBirth);

		log.info("My Account - Step 23: Verify 'Email Address' edit is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), editEmailAddress);

		log.info("My Account - Step 24: Verify 'Company Name' edit is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company"), editCompanyName);

		log.info("My Account - Step 25: Click Logout button");
		homePage = customerInfoPage.clickToLogOutLinkAtUserPage(driver);

		log.info("My Account - Step 26: Navigate to 'Login' Page");
		loginPage = homePage.openLoginPage();

		log.info("My Account - Step 27: Login with edit email = '" + editEmailAddress + "'" + " and password = '" + password + "'");
		homePage = loginPage.loginAsUser(editEmailAddress, password);

		log.info("My Account - Step 28: Verify 'My Account Link' is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

//	@Test
//	public void User_02_Login() {
//
//	}
//
//	@Test
//	public void User_03_My_Account() {
//
//	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private DataFaker dataFaker;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInfoPageObject customerInfoPage;
	private String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, emailAddress, password;
	private String editGender, editFirstName, editLastName, editDayOfBirth, editMonthOfBirth, editYearOfBirth, editEmailAddress, editCompanyName;

}
