package pageObjects.jQuery;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI_II;

public class HomePageObject_II extends BasePage {
	WebDriver driver;

	public HomePageObject_II(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextboxByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToEnter) {
		int columnIndex = getElementSize(driver, HomePageUI_II.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisible(driver, HomePageUI_II.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI_II.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToEnter, rowNumber, String.valueOf(columnIndex));
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String valueToSelect) {
		int columnIndex = getElementSize(driver, HomePageUI_II.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI_II.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI_II.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, valueToSelect, rowNumber, String.valueOf(columnIndex));
	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI_II.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI_II.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckboxOrRadio(driver, HomePageUI_II.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI_II.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(driver, HomePageUI_II.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckbox(driver, HomePageUI_II.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
	}

	public void clickToIconByRowNumber(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI_II.ICON_NAME_BY_ROW_INDEX, rowNumber, iconName);
		clickToElement(driver, HomePageUI_II.ICON_NAME_BY_ROW_INDEX, rowNumber, iconName);
	}

}
