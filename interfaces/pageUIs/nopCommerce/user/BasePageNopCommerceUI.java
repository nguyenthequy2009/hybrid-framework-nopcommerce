package pageUIs.nopCommerce.user;

public class BasePageNopCommerceUI {
	public static final String ADDRESS_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String CUSTOMER_INFO_LINK = "XPATH=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String MY_PRODUCT_REVIEW_LINK = "XPath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xPath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String CHANGE_PASSWORD_LINK = "xPath=//div[contains(@class,'account-navigation')]//a[text()='Change password']";
	public static final String LOGOUT_LINK_AT_USER = "css=a[class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String AJAX_BUSY_AT_ADMIN = "xpath=//div[@id='ajaxBusy']";
	
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xPath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
	public static final String DYNAMIC_TEXTBOX_BY_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_BUTTON_BY_TEXT = "xpath=//button[text()='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[@name='%s']";
	public static final String DYNAMIC_RADIO_BUTTON_BY_LABEL = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String DYNAMIC_CHECKBOX_BY_LABEL = "xpath=//label[contains(text(),'%s')]/following-sibling::input";
	
	public static final String SUCCESSFUL_MESSAGE = "xpath=//div[@class='bar-notification success']/p[text()='%s']";
	public static final String CLOSE_MESSAGE_ICON = "xpath=//span[@class='close']";
}
