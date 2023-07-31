package pageUIs.nopCommerce.user;

public class UserBasePageUI {
	public static final String ADDRESS_LINK = "Xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String CUSTOMER_INFO_LINK = "XPATH=//div[contains(@class,'account-navigation')]//a[text()='Customer info']";
	public static final String MY_PRODUCT_REVIEW_LINK = "XPath=//div[contains(@class,'account-navigation')]//a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xPath=//div[contains(@class,'account-navigation')]//a[text()='Reward points']";
	public static final String LOGOUT_LINK_AT_USER = "css=a[class='ico-logout']";
	public static final String LOGOUT_LINK_AT_ADMIN = "xpath=//a[text()='Logout']";
	public static final String AJAX_BUSY_AT_ADMIN = "xpath=//div[@id='ajaxBusy']";
	
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xPath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
}
