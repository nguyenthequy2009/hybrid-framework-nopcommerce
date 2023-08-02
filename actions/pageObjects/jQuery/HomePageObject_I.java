package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.HomePageUI_I;

public class HomePageObject_I extends BasePage {
	WebDriver driver;

	public HomePageObject_I(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI_I.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI_I.PAGINATION_PAGE_BY_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByLable(String headerLable, String value) {
		waitForAllElementVisible(driver, HomePageUI_I.HEADER_TEXTBOX_BY_LABLE_NAME, headerLable);
		sendkeyToElement(driver, HomePageUI_I.HEADER_TEXTBOX_BY_LABLE_NAME, value, headerLable);
		pressKeyToElement(driver, HomePageUI_I.HEADER_TEXTBOX_BY_LABLE_NAME, Keys.ENTER, headerLable);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForAllElementVisible(driver, HomePageUI_I.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI_I.PAGINATION_PAGE_ACTIVED_BY_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI_I.TOTAL_PAGINATION);
		List<String> allRowValueAllPage = new ArrayList<String>();
		for (int index = 1; index <= totalPage; index++) {
			clickToElement(driver, HomePageUI_I.PAGINATION_PAGE_INDEX, String.valueOf(index));
			
			List<WebElement> allRowElementEachPage = getListWebElement(driver, HomePageUI_I.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowElementEachPage) {
				allRowValueAllPage.add(eachRow.getText());
			}
		}
		
		for (String value : allRowValueAllPage) {
			System.out.println("------------------");
			System.out.println(value);
		}
		
		return allRowValueAllPage;
	}

}
