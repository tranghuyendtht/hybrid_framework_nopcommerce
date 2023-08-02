package pageObjects.nopcommerce.User;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.nopcommerce.user.UserShoppingCartPageUI;
import PageUIs.nopcommerce.user.UserWishListPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserShoppingCartPageObject extends BasePage{
	private WebDriver driver;
	
	public UserShoppingCartPageObject (WebDriver driver) {
		this.driver = driver;
	}

	public boolean isSKUProductAddedOnWishlistPage(String skuProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserShoppingCartPageUI.SKU_PRODUCT_TEXT_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(skuProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;

	}

	public boolean isImageDisplayed() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_IMAGE_ON_WISHLIST_PAGE);
		return isImageUpLoaded(driver, UserShoppingCartPageUI.PRODUCT_IMAGE_ON_WISHLIST_PAGE);
	}

	public boolean isProductNameAddedOnWishlistPage(String keyword) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserShoppingCartPageUI.PRODUCT_NAME_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(keyword)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}

	public boolean isProductPriceAddedOnWishlistPage(String priceProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserShoppingCartPageUI.PRODUCT_PRICE_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(priceProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}

	public boolean isProductQuantityAddedOnWishlistPage(int quantityProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getAttribute("value"));
			System.out.println(eachColumn.getAttribute("value"));
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (Integer.valueOf(value).equals(quantityProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}

	public boolean isProductTotalAddedOnWishlistPage(String priceProduct) {
		boolean pass = true;
		List<String> allColumnValueAllPage = new ArrayList<String>();

		// Duyệt qua từng column để lấy các value và đưa vào arraylist
		List<WebElement> allColumnEachPage = getElements(driver,
				UserShoppingCartPageUI.PRODUCT_TOTAL_PRICE_ON_WISHLIST_PAGE);
		for (WebElement eachColumn : allColumnEachPage) {

			allColumnValueAllPage.add(eachColumn.getText());
			System.out.println(eachColumn.getText());
		}

		// In các giá trị của các row tất cả page
		for (String value : allColumnValueAllPage) {
			if (value.equals(priceProduct)) {
				pass = true;
			} else {
				pass = false;
			}
		}

		return pass;
	}

	public UserWishListPageObject clickToWishlistLinktext() {
		waitForElementClickable(driver, UserShoppingCartPageUI.WISHLIST_LINKTEXT);
		clickToElement(driver, UserShoppingCartPageUI.WISHLIST_LINKTEXT);
		return PageGeneratorManager.getUserWishListPage(driver);
	}


}
