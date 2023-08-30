package pageUIs.wordpress;

public class AdminPostSearchPUI {
	public static final String ADD_NEW_BUTTON = "xpath=//div[@class='wrap']//a[text()='Add New']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@id='post-search-input']";
	public static final String SEARCH_POSTS_BUTTON = "xpath=//input[@id='search-submit']";
	public static final String TABLE_HEADER_INDEX_BY_HEADER_ID = "xpath=//table[contains(@class,'table-view-list posts')]/thead//th[@id='%s']/preceding-sibling::*";
	public static final String TABLE_ROW_VALUE_BY_HEADER_INDEX = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/*[%s]//a[text()='%s']";
	public static final String ROW_TITLE_DETAIL_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody//tr//a[@class='row-title' and text()='%s']";
	public static final String ROW_CHECKBOX_BY_TITLE_NAME = "xpath=//table[contains(@class,'table-view-list posts')]/tbody/tr/th/label/span[contains(text(),'%s')]/parent::label/following-sibling::input";
	public static final String ACTION_DROPDOWN = "xpath=//select[@id='bulk-action-selector-top']";
	public static final String APPLY_BUTTON = "xpath=//input[@id='doaction']";
	public static final String MOVE_TO_TRASH_SUCCESS_MESSAGE = "xpath=//div[@id='message']/p[contains(text(),'%s')]";
	public static final String NO_POST_FOUND_MESSAGE = "xpath=//table[contains(@class,'table-view-list posts')]//tr[@class='no-items']/td[text()='%s']";
	
}
