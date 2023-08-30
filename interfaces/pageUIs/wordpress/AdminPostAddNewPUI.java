package pageUIs.wordpress;

public class AdminPostAddNewPUI {
	public static final String TITLE_TEXTBOX = "xpath=//h1[contains(@class,'wp-block-post-title')]";
	public static final String BODY_BUTTON = "xpath=//p[contains(@class,'block-editor-default')]";
	public static final String BODY_TEXT = "xpath=//p[contains(@class,'block-editor-rich-text__editable')]";
	public static final String EDIT_BODY_BUTTON = "xpath=//p[contains(@class,'block-editor-rich-text__editable') and @aria-label='Paragraph block']";
	public static final String EDIT_BODY_TEXT = "xpath=//p[contains(@class,'is-selected')]";
	public static final String PUBLISH_OR_UPDATE_BUTTON = "xpath=//button[contains(@class,'editor-post-publish-button')]";
	public static final String CONFIRM_PUBLISH_BUTTON = "xpath=//div[@class='editor-post-publish-panel']//button[contains(@class,'editor-post-publish-button')]";
	public static final String PUBLISHED_OR_UPDATED_MESSAGE = "xpath=//div[@class='components-snackbar__content' and contains(text(),'%s')]";
}
