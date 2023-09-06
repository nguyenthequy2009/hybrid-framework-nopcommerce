package pageObjects.sauceLab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.SauceLab.ProductPUI;

public class ProductPO extends BasePage {
	WebDriver driver;

	public ProductPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String textItem) {
		waitForElementClickable(driver, ProductPUI.PRODUCT_CONTAINER_DROPDOWN);
		selectItemInDefaultDropdown(driver, ProductPUI.PRODUCT_CONTAINER_DROPDOWN, textItem);
	}

	public boolean isProductNameSortByAscending() {
		List<String> productUIList = new ArrayList<String>();

		List<WebElement> productNameTextList = getListWebElement(driver, ProductPUI.PRODUCTS_NAME_TEXT);

		for (WebElement productName : productNameTextList) {
			productUIList.add(productName.getText());
		}

		List<String> productSortList = new ArrayList<String>();

		for (String productUI : productUIList) {
			productSortList.add(productUI);
		}

		Collections.sort(productSortList);

		return productSortList.equals(productUIList);
	}

	public boolean isProductNameSortByDescending() {
		List<String> productUIList = new ArrayList<String>();

		List<WebElement> productNameTextList = getListWebElement(driver, ProductPUI.PRODUCTS_NAME_TEXT);

		for (WebElement productName : productNameTextList) {
			productUIList.add(productName.getText());
		}

		List<String> productSortList = new ArrayList<String>();

		for (String productUI : productUIList) {
			productSortList.add(productUI);
		}

		Collections.sort(productSortList);

		Collections.reverse(productSortList);

		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByAscending() {
		List<Float> productUIList = new ArrayList<Float>();

		List<WebElement> productPriceTextList = getListWebElement(driver, ProductPUI.PRODUCTS_PRICE_TEXT);

		for (WebElement productPrice : productPriceTextList) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		List<Float> productSortList = new ArrayList<Float>();

		for (Float productUI : productUIList) {
			productSortList.add(productUI);
		}

		Collections.sort(productSortList);

		return productSortList.equals(productUIList);
	}

	public boolean isProductPriceSortByDescending() {
		List<Float> productUIList = new ArrayList<Float>();

		List<WebElement> productPriceTextList = getListWebElement(driver, ProductPUI.PRODUCTS_PRICE_TEXT);

		for (WebElement productPrice : productPriceTextList) {
			productUIList.add(Float.parseFloat(productPrice.getText().replace("$", "")));
		}

		List<Float> productSortList = new ArrayList<Float>();

		for (Float productUI : productUIList) {
			productSortList.add(productUI);
		}

		Collections.sort(productSortList);
		
		Collections.reverse(productSortList);

		return productSortList.equals(productUIList);
	}
}
