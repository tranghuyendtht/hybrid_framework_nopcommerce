package javaBasic;

public class Topic_12_StringFormat {
	public static final String ADDRESS_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Addresses']";
	public static final String ORDER_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Orders']";
	public static final String DOWNLOADABLE_PRODUCT_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Downloadable products']";
	public static final String BACK_IN_STOCK_SUBSCRIPTION_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Back in stock subscriptions']";
	public static final String REWARD_POINT_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Reward points']";
	public static final String CHANGE_PASSWORD_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='Change password']";
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//div[@class ='master-wrapper-content']//a[text()='My product reviews']";

	public static final String DYNAMIC_LINK_PAGE_NAME = "xpath=//div[@class ='master-wrapper-content']//a[text()='%s']";

	
	// 0 tham số động
	public static void clickToLink(String locator) {
		System.out.println("Click to:  " + locator);
	}

	
	 //1 tham số động
	public static void clickToLink(String dynamicLocator, String pageName) {

		// dynamicLocator = xpath=//div[@class='master-wrapper-content']//a[text()='%s']
		// pageName = My product reviews | Orders | .....
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("Click to:  " + locator);
	}

	// Khi có từ 2 tham số động trở lên thì người ta viết hàm sử dụng rest parameter
	// - tham số còn lại | varargs
	public static void clickToLink(String locator, String... dynamicValue) {

		
		System.out.println("Click to:  " +  String.format(locator,(Object[]) dynamicValue));
	}

	public static void main(String[] args) {
		clickToLink(ADDRESS_LINK);
		clickToLink(ORDER_LINK);
		clickToLink(DOWNLOADABLE_PRODUCT_LINK);
		clickToLink(BACK_IN_STOCK_SUBSCRIPTION_LINK);
		clickToLink(REWARD_POINT_LINK);
		clickToLink(CHANGE_PASSWORD_LINK);
		clickToLink(MY_PRODUCT_REVIEW_LINK);
		System.out.println("-----------------------------------");
		clickToLink(DYNAMIC_LINK_PAGE_NAME, "Addresses");
		clickToLink(DYNAMIC_LINK_PAGE_NAME, "Orders");
		clickToLink(DYNAMIC_LINK_PAGE_NAME, "Downloadable products");
		clickToLink(DYNAMIC_LINK_PAGE_NAME, "Back in stock subscriptions");
		clickToLink(DYNAMIC_LINK_PAGE_NAME, "Reward points");
		clickToLink(DYNAMIC_LINK_PAGE_NAME, "Change password");
		clickToLink(DYNAMIC_LINK_PAGE_NAME, "My product reviews");
	}
}
