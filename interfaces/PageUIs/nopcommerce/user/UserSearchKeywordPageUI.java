package PageUIs.nopcommerce.user;

public class UserSearchKeywordPageUI {
	public static final String SEARCH_BUTTON = "xpath=//button[contains(@class,'search-button')]";
	public static final String SEARCH_TERM_LENGTH_MESSAGE = "xpath=//div[@class='warning' and text()='Search term minimum length is 3 characters']";
	public static final String MESSAGE_NO_PRODUCT_FOUND = "xpath=// div[@class='no-result' and text()='No products were found that matched your criteria.']";
	public static final String LIST_PRODUCT_TITLE = "xpath=//div[@class = 'product-item']//h2[@class ='product-title']//a";
	public static final String ADVANCED_SEARCH_CHECKBOX = "xpath=//input[@id='advs']";
	public static final String CATEGORY_DROPDOWN_LIST = "xpath=//select[@id='cid']";
	public static final String SUB_CATEGORY_DROPDOWN_LIST = "xpath=//select[@id='mid']";
	public static final String SUB_CATEGORY_CHECKBOX = "xpath=//input[@id='isc']";
	public static final String PRODUCT_TITLE = "xpath=//h2[@class='product-title']//a[text()='%s']";
}
