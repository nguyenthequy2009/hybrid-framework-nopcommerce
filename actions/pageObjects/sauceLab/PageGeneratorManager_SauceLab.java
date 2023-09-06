package pageObjects.sauceLab;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager_SauceLab {

	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}

	public static ProductPO getProductPage(WebDriver driver) {
		return new ProductPO(driver);
	}

}
