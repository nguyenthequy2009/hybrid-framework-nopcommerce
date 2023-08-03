package com.jQuery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager_jQuery;

public class Level_11_Upload_File extends BaseTest {

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage=PageGeneratorManager_jQuery.getHomePage_I(driver);
	}

	@Test
	public void Upload_01_One_File_Per_Time() {
		homePage.uploadMultipleFiles(driver, catFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(catFileName));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(catFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(catFileName));

	}

	@Test
	public void Upload_02_Multiple_File_Per_Time() {
		homePage.refreshCurrentPage(driver);
		
		homePage.uploadMultipleFiles(driver, multipleFileName);
		Assert.assertTrue(homePage.isFileLoadedByName(catFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(mountainFileName));
		Assert.assertTrue(homePage.isFileLoadedByName(beachFileName));

		homePage.clickToStartButton();
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(catFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(mountainFileName));
		Assert.assertTrue(homePage.isFileLinkUpLoadedByName(beachFileName));
		
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(catFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(mountainFileName));
		Assert.assertTrue(homePage.isFileImageUpLoadedByName(beachFileName));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;
	private HomePageObject homePage;
	private String catFileName = "cat.jpg";
	private String mountainFileName = "mountain.jpg";
	private String beachFileName = "beach.jpg";
	private String[] multipleFileName = { catFileName, mountainFileName, beachFileName };

}
