package PageUIs.nopcommerce.admin;

public class AdminBasePageUI {
	public static final String DYNAMIC_MENU_LINKTEXT_BY_NAME = "xpath=//i[@class = 'right fas fa-angle-left ']//parent::p[contains(text(),'%s')]";
	public static final String DYNAMIC_CATEGORY_LINKTEXT_BY_NAME = "xpath=//i[@class = 'right fas fa-angle-left ']//parent::p[contains(text(),'%s')]//parent::a//following-sibling::ul//p[contains(text(),'%s')]";
}
