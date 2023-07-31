package pageObjects.nopcommerce.User;

import org.openqa.selenium.WebDriver;

import PageUIs.nopcommerce.user.UserProductDetailUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserProductDetailPageObject extends BasePage{
	private WebDriver driver;
	
	public UserProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddYourReview() {
		waitForElementClickable(driver, UserProductDetailUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, UserProductDetailUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, UserProductDetailUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, UserProductDetailUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewTextArea(String reviewBody) {
		waitForElementVisible(driver, UserProductDetailUI.REVIEW_BODY_TEXTAREA);
		sendkeyToElement(driver, UserProductDetailUI.REVIEW_BODY_TEXTAREA, reviewBody);
		
	}

	public void clickToRatingCheckbox() {
		waitForElementClickable(driver, UserProductDetailUI.PRODUCT_RATING_CHECKBOX);
		clickToElement(driver, UserProductDetailUI.PRODUCT_RATING_CHECKBOX);
		
	}

	public void clickToAddReviewButton() {
		waitForElementClickable(driver, UserProductDetailUI.ADD_REVIEW_BUTTON);
		clickToElement(driver, UserProductDetailUI.ADD_REVIEW_BUTTON);
		
	}

	public String getSuccessfulReviewMessage() {
		waitForElementVisible(driver, UserProductDetailUI.REVIEW_SUCCESS_MESSAGE);
		return getElementText(driver, UserProductDetailUI.REVIEW_SUCCESS_MESSAGE);
	}

	public void clickToAddToWishlistButton() {
		waitForElementClickable(driver, UserProductDetailUI.ADD_TO_WISHLISH_BUTTON);
		clickToElement(driver, UserProductDetailUI.ADD_TO_WISHLISH_BUTTON);
		
	}

	public String isSuccessMessageDisplayed() {
		waitForElementVisible(driver, UserProductDetailUI.ADDED_SUCCESS_MESSAGE);
		return getElementText(driver, UserProductDetailUI.ADDED_SUCCESS_MESSAGE);
	}

	public UserWishListPageObject clickToWishlistLinkText() {
		waitForElementClickable(driver, UserProductDetailUI.WISHLIST_LINKTEXT);
		clickToElement(driver, UserProductDetailUI.WISHLIST_LINKTEXT);
		return PageGeneratorManager.getUserWishListPage(driver);
	}

	public String getSKUProduct() {
		waitForElementVisible(driver, UserProductDetailUI.SKU_PRODUCT);
		return getElementText(driver, UserProductDetailUI.SKU_PRODUCT);
	}

	public String getPriceProduct() {
		waitForElementVisible(driver, UserProductDetailUI.PRICE_PRODUCT);
		return getElementText(driver, UserProductDetailUI.PRICE_PRODUCT);
	}

}
