package com.saucedemo.sort;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.sauceLab.LoginPO;
import pageObjects.sauceLab.PageGeneratorManager_SauceLab;
import pageObjects.sauceLab.ProductPO;

public class Level_19_Sort_Asc_Desc extends BaseTest {

	@Parameters({ "browser", "appUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGeneratorManager_SauceLab.getLoginPage(driver);

		loginPage.enterToUsernameTextbox("standard_user");
		loginPage.enterToPasswordTextbox("secret_sauce");
		productPage = loginPage.clickToLoginButton();

	}

	@Test
	public void Sort_01_Name() {
		productPage.selectItemInProductSortDropdown("Name (A to Z)");
		productPage.sleepInSecond(1);
		Assert.assertTrue(productPage.isProductNameSortByAscending());

		productPage.selectItemInProductSortDropdown("Name (Z to A)");
		productPage.sleepInSecond(1);
		Assert.assertTrue(productPage.isProductNameSortByDescending());
		
	}

	@Test
	public void Sort_02_Price() {
		productPage.selectItemInProductSortDropdown("Price (low to high)");
		productPage.sleepInSecond(1);
		Assert.assertTrue(productPage.isProductPriceSortByAscending());
		
		productPage.selectItemInProductSortDropdown("Price (high to low)");
		productPage.sleepInSecond(1);
		Assert.assertTrue(productPage.isProductPriceSortByDescending());
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

	private WebDriver driver;
	private LoginPO loginPage;
	private ProductPO productPage;
}
