package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUIs.ProductDetailUI;
import commons.BasePage;

public class ProductDetailPageObject extends BasePage{
	private WebDriver driver;
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddYourReview() {
		waitForElementClickable(driver, ProductDetailUI.ADD_YOUR_REVIEW_LINK);
		clickToElement(driver, ProductDetailUI.ADD_YOUR_REVIEW_LINK);
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, ProductDetailUI.REVIEW_TITLE_TEXTBOX);
		sendkeyToElement(driver, ProductDetailUI.REVIEW_TITLE_TEXTBOX, reviewTitle);
	}

	public void inputToReviewTextArea(String reviewBody) {
		waitForElementVisible(driver, ProductDetailUI.REVIEW_BODY_TEXTAREA);
		sendkeyToElement(driver, ProductDetailUI.REVIEW_BODY_TEXTAREA, reviewBody);
		
	}

	public void clickToRatingCheckbox() {
		waitForElementClickable(driver, ProductDetailUI.PRODUCT_RATING_CHECKBOX);
		clickToElement(driver, ProductDetailUI.PRODUCT_RATING_CHECKBOX);
		
	}

	public void clickToAddReviewButton() {
		waitForElementClickable(driver, ProductDetailUI.ADD_REVIEW_BUTTON);
		clickToElement(driver, ProductDetailUI.ADD_REVIEW_BUTTON);
		
	}

	public String getSuccessfulReviewMessage() {
		waitForElementVisible(driver, ProductDetailUI.REVIEW_SUCCESS_MESSAGE);
		return getElementText(driver, ProductDetailUI.REVIEW_SUCCESS_MESSAGE);
	}

}
