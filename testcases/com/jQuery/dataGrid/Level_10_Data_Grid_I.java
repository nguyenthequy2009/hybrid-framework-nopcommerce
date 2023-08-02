package com.jQuery.dataGrid;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject_I;
import pageObjects.jQuery.PageGeneratorManager_jQuery;

public class Level_10_Data_Grid_I extends BaseTest {
	HomePageObject_I homePage1;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage1 = PageGeneratorManager_jQuery.getHomePage_I(driver);
	}

	@Test
	public void Table_01_Paging() {
		homePage1.openPagingByPageNumber("10");
		homePage1.sleepInSecond(1);
		Assert.assertTrue(homePage1.isPageNumberActived("10"));
		
		homePage1.openPagingByPageNumber("3");
		homePage1.sleepInSecond(1);
		Assert.assertTrue(homePage1.isPageNumberActived("3"));
		
		homePage1.openPagingByPageNumber("21");
		homePage1.sleepInSecond(1);
		Assert.assertTrue(homePage1.isPageNumberActived("21"));
		
		homePage1.openPagingByPageNumber("1");
		homePage1.sleepInSecond(1);
		Assert.assertTrue(homePage1.isPageNumberActived("1"));
	}

	@Test
	public void Table_02_Enter_To_Header_Search() {
		homePage1.refreshCurrentPage(driver);
		homePage1.enterToHeaderTextboxByLable("Country", "Argentina");
		homePage1.enterToHeaderTextboxByLable("Females", "338282");
		homePage1.enterToHeaderTextboxByLable("Males", "349238");
		homePage1.enterToHeaderTextboxByLable("Total", "687522");
	}
	
	@Test
	public void Table_03_Get_All_Data_On_Table_At_Page() {
		homePage1.refreshCurrentPage(driver);
		homePage1.getValueEachRowAtAllPage();
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
