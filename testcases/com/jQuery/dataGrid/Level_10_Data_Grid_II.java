package com.jQuery.dataGrid;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.HomePageObject_II;
import pageObjects.jQuery.PageGeneratorManager_jQuery;

public class Level_10_Data_Grid_II extends BaseTest {
	HomePageObject_II homePage2;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage2 = PageGeneratorManager_jQuery.getHomePage_II(driver);
	}

	@Test
	public void Table_01_Action_At_Any_Row() {
		homePage2.enterToTextboxByColumnNameAtRowNumber("Company","1","AutoFC1");
		homePage2.enterToTextboxByColumnNameAtRowNumber("Contact Person","1","FC");
		homePage2.enterToTextboxByColumnNameAtRowNumber("Order Placed","1","1991");
		
		homePage2.selectDropdownByColumnNameAtRowNumber("Country","1","Japan");
		homePage2.selectDropdownByColumnNameAtRowNumber("Country","2","Hong Kong");
		
		homePage2.checkToCheckboxByColumnNameAtRowNumber("NPO?","1");
		homePage2.checkToCheckboxByColumnNameAtRowNumber("NPO?","2");
		homePage2.uncheckToCheckboxByColumnNameAtRowNumber("NPO?","2");
		
		homePage2.clickToIconByRowNumber("1", "Remove Current Row");
		homePage2.clickToIconByRowNumber("1", "Insert Row Above");
		homePage2.clickToIconByRowNumber("2", "Move Up");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private WebDriver driver;

}
