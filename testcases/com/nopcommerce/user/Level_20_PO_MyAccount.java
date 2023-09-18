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
import pageObjects.nopCommerce.user.UserChangePasswordPO;
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
		newPassword = dataFaker.getPassword();

		editGender = "Female";
		editFirstName = "Automation";
		editLastName = "FC";
		editDayOfBirth = "1";
		editMonthOfBirth = "January";
		editYearOfBirth = "1999";
		editEmailAddress = dataFaker.getEmailAddress();
		editCompanyName = "Automation Company";

		cityName = dataFaker.getCityName();
		address1 = dataFaker.getAddress();
		address2 = dataFaker.getAddress();
		zipcode = dataFaker.getPhoneNumber();
		phoneNumber = dataFaker.getPhoneNumber();
		faxNumber = dataFaker.getPhoneNumber();
		countryName = "United States";
		stateName = "Washington";

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
	public void MyAccount_01_Update_Customer_Info() {
		log.info("Update_Customer_Info - Step 01: Navigate to 'Customer Info' Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("Update_Customer_Info - Step 02: Verify 'Customer Info Page' is displayed");
		Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());

		log.info("Update_Customer_Info - Step 03: Verify 'FirstName' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), firstName);

		log.info("Update_Customer_Info - Step 04: Verify 'LastName' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), lastName);

		log.info("Update_Customer_Info - Step 05: Verify 'Email' value is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), emailAddress);

		log.info("Update_Customer_Info - Step 06: Update Customer Gender = " + editGender);
		customerInfoPage.clickToRadioButtonByLabel(driver, editGender);

		log.info("Update_Customer_Info - Step 07: Update Customer FirstName = " + editFirstName);
		customerInfoPage.inputToTextboxByID(driver, "FirstName", editFirstName);

		log.info("Update_Customer_Info - Step 08: Update Customer LastName = " + editLastName);
		customerInfoPage.inputToTextboxByID(driver, "LastName", editLastName);

		log.info("Update_Customer_Info - Step 09: Update Customer DateOfBirth = " + editDayOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthDay", editDayOfBirth);

		log.info("Update_Customer_Info - Step 10: Update Customer MonthOfBirth = " + editMonthOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthMonth", editMonthOfBirth);

		log.info("Update_Customer_Info - Step 11: Update Customer YearOfBirth = " + editYearOfBirth);
		customerInfoPage.selectToDropdownByName(driver, "DateOfBirthYear", editYearOfBirth);

		log.info("Update_Customer_Info - Step 12: Update Customer Email Address = " + editEmailAddress);
		customerInfoPage.inputToTextboxByID(driver, "Email", editEmailAddress);

		log.info("Update_Customer_Info - Step 13: Update Customer Company Name = " + editCompanyName);
		customerInfoPage.inputToTextboxByID(driver, "Company", editCompanyName);

		log.info("Update_Customer_Info - Step 14: Click Save button");
		customerInfoPage.clickToButtonByText(driver, "Save");

		log.info("Update_Customer_Info - Step 15: Verify Update successful message");
		Assert.assertTrue(customerInfoPage.isCustomerInfoUpdateSuccessfulMessageDisplayed("The customer info has been updated successfully."));

		log.info("Update_Customer_Info - Step 16: Click close Update successful message icon");
		customerInfoPage.clickToCloseUpdateMessageIcon();

		log.info("Update_Customer_Info - Step 17: Verify 'Gender' edit is correctly");
		Assert.assertTrue(customerInfoPage.isRadioButtonSelectedByLabel(driver, editGender));

		log.info("Update_Customer_Info - Step 18: Verify 'FirstName' edit is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "FirstName"), editFirstName);

		log.info("Update_Customer_Info - Step 19: Verify 'LastName' edit is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "LastName"), editLastName);

		log.info("Update_Customer_Info - Step 20: Verify 'DateOfBirth' edit is correctly");
		Assert.assertEquals(customerInfoPage.getFirstSelectedItemInDefaultDropdownByName(driver, "DateOfBirthDay"), editDayOfBirth);

		log.info("Update_Customer_Info - Step 21: Verify 'MonthOfBirth' edit is correctly");
		Assert.assertEquals(customerInfoPage.getFirstSelectedItemInDefaultDropdownByName(driver, "DateOfBirthMonth"), editMonthOfBirth);

		log.info("Update_Customer_Info - Step 22: Verify 'YearOfBirth' edit is correctly");
		Assert.assertEquals(customerInfoPage.getFirstSelectedItemInDefaultDropdownByName(driver, "DateOfBirthYear"), editYearOfBirth);

		log.info("Update_Customer_Info - Step 23: Verify 'Email Address' edit is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Email"), editEmailAddress);

		log.info("Update_Customer_Info - Step 24: Verify 'Company Name' edit is correctly");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID(driver, "Company"), editCompanyName);

		log.info("Update_Customer_Info - Step 25: Click Logout button");
		homePage = customerInfoPage.clickToLogOutLinkAtUserPage(driver);

		log.info("Update_Customer_Info - Step 26: Navigate to 'Login' Page");
		loginPage = homePage.openLoginPage();

		log.info("Update_Customer_Info - Step 27: Login with edit email = '" + editEmailAddress + "'" + " and password = '" + password + "'");
		homePage = loginPage.loginAsUser(editEmailAddress, password);

		log.info("Update_Customer_Info - Step 28: Verify 'My Account Link' is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void MyAccount_02_Add_New_Address() {
		log.info("Add_New_Address - Step 01: Navigate to 'Customer Info' Page");
		customerInfoPage = homePage.openMyAccountPage();

		log.info("Add_New_Address - Step 02: Navigate to 'Addresses' Page");
		addressPage = customerInfoPage.openAddressPage(driver);

		log.info("Add_New_Address - Step 03: Click to Add New button");
		addressPage.clickToButtonByText(driver, "Add new");

		log.info("Add_New_Address - Step 04: Enter to FirstName textbox value = " + firstName);
		addressPage.inputToTextboxByID(driver, "Address_FirstName", firstName);

		log.info("Add_New_Address - Step 05: Enter to LastName textbox value = " + lastName);
		addressPage.inputToTextboxByID(driver, "Address_LastName", lastName);

		log.info("Add_New_Address - Step 06: Enter to Email textbox value = " + emailAddress);
		addressPage.inputToTextboxByID(driver, "Address_Email", emailAddress);

		log.info("Add_New_Address - Step 07: Enter to Company textbox value = " + editCompanyName);
		addressPage.inputToTextboxByID(driver, "Address_Company", editCompanyName);

		log.info("Add_New_Address - Step 08: Select country dropdown value = " + countryName);
		addressPage.selectToDropdownByName(driver, "Address.CountryId", countryName);
		addressPage.waitForCountryDropdownValueIsSelected();

		log.info("Add_New_Address - Step 09: Select State dropdown value = " + stateName);
		addressPage.selectToDropdownByName(driver, "Address.StateProvinceId", stateName);

		log.info("Add_New_Address - Step 10: Enter to City textbox value = " + cityName);
		addressPage.inputToTextboxByID(driver, "Address_City", cityName);

		log.info("Add_New_Address - Step 11: Enter to Address1 textbox value = " + address1);
		addressPage.inputToTextboxByID(driver, "Address_Address1", address1);

		log.info("Add_New_Address - Step 12: Enter to Address2 textbox value = " + address2);
		addressPage.inputToTextboxByID(driver, "Address_Address2", address2);

		log.info("Add_New_Address - Step 13: Enter to Zipcode textbox value = " + zipcode);
		addressPage.inputToTextboxByID(driver, "Address_ZipPostalCode", zipcode);

		log.info("Add_New_Address - Step 14: Enter to Phone Number textbox value = " + phoneNumber);
		addressPage.inputToTextboxByID(driver, "Address_PhoneNumber", phoneNumber);

		log.info("Add_New_Address - Step 15: Enter to Fax Number textbox value = " + faxNumber);
		addressPage.inputToTextboxByID(driver, "Address_FaxNumber", faxNumber);

		log.info("Add_New_Address - Step 16: Click to Save button");
		addressPage.clickToButtonByText(driver, "Save");

		log.info("Add_New_Address - Step 17: Verify Successful Message");
		Assert.assertTrue(addressPage.isAddNewAddressSuccessfulMessageDisplayed("The new address has been added successfully."));

		log.info("Add_New_Address - Step 18: Click to close Message icon");
		addressPage.clickToCloseAddNewSuccessfulMessageIcon();

		log.info("Add_New_Address - Step 19: Verify 'FirstName' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("name").contains(firstName));

		log.info("Add_New_Address - Step 20: Verify 'LastName' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("name").contains(lastName));

		log.info("Add_New_Address - Step 21: Verify 'Email' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("email").contains(emailAddress));

		log.info("Add_New_Address - Step 22: Verify 'Company' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("company").contains(editCompanyName));

		log.info("Add_New_Address - Step 23: Verify 'Country' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("country").contains(countryName));

		log.info("Add_New_Address - Step 24: Verify 'State' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("city-state-zip").contains(stateName));

		log.info("Add_New_Address - Step 25: Verify 'City' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("city-state-zip").contains(cityName));

		log.info("Add_New_Address - Step 26: Verify 'Address 1' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("address1").contains(address1));

		log.info("Add_New_Address - Step 27: Verify 'Address 2' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("address2").contains(address2));

		log.info("Add_New_Address - Step 28: Verify 'Zipcode' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("city-state-zip").contains(zipcode));

		log.info("Add_New_Address - Step 29: Verify 'Phone Number' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("phone").contains(phoneNumber));

		log.info("Add_New_Address - Step 30: Verify 'Fax Number' is correctly");
		Assert.assertTrue(addressPage.getAddressInfoByClass("fax").contains(faxNumber));

	}

	@Test
	public void MyAccount_03_Change_Password() {
		log.info("Change_Password - Step 01: Navigate to 'Change Password' Page");
		changePasswordPage = addressPage.openChangePasswordPage(driver);

		log.info("Change_Password - Step 02: Enter to Old Password textbox value = " + password);
		changePasswordPage.inputToTextboxByID(driver, "OldPassword", password);

		log.info("Change_Password - Step 03: Enter to New Password textbox value = " + newPassword);
		changePasswordPage.inputToTextboxByID(driver, "NewPassword", newPassword);

		log.info("Change_Password - Step 04: Enter to Confirm New Password textbox value = " + newPassword);
		changePasswordPage.inputToTextboxByID(driver, "ConfirmNewPassword", newPassword);

		log.info("Change_Password - Step 05: Click to Change Password button");
		changePasswordPage.clickToButtonByText(driver, "Change password");

		log.info("Change_Password - Step 06: Verify Chang pass mess display");
		Assert.assertTrue(changePasswordPage.isChangePasswordSuccessfulMessageDisplayed("Password was changed"));

		log.info("Change_Password - Step 07: Click to close message icon");
		changePasswordPage.clickToCloseChangePasswordSuccessfulMessageIcon();

		log.info("Change_Password - Step 08: Click to logout link");
		homePage = changePasswordPage.clickToLogOutLinkAtUserPage(driver);

		log.info("Change_Password  - Step 09: Navigate to 'Login' Page");
		loginPage = homePage.openLoginPage();

		log.info("Change_Password  - Step 10: Login with edit email = '" + editEmailAddress + "'" + " and old password = '" + password + "'");
		homePage = loginPage.loginAsUser(editEmailAddress, password);

		log.info("Change_Password  - Step 11: Verify incorrect password");
		Assert.assertEquals(loginPage.getErrorMessageUnsuccessful(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

		log.info("Change_Password  - Step 12: Login with edit email = '" + editEmailAddress + "'" + " and new password = '" + newPassword + "'");
		homePage = loginPage.loginAsUser(editEmailAddress, newPassword);

		log.info("Change_Password  - Step 13: Verify 'My Account Link' is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}
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
	private UserAddressPageObject addressPage;
	private UserChangePasswordPO changePasswordPage;
	private String firstName, lastName, dayOfBirth, monthOfBirth, yearOfBirth, emailAddress, password, newPassword;
	private String editGender, editFirstName, editLastName, editDayOfBirth, editMonthOfBirth, editYearOfBirth, editEmailAddress, editCompanyName;
	private String cityName, address1, address2, zipcode, phoneNumber, faxNumber, countryName, stateName;

}
