package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageUIs.nopcommerce.user.UserProductDetailUI;
import commons.BasePage;
import commons.BasePageFactory;

public class ProductDetailPageFactory extends BasePageFactory{
	private WebDriver driver;
	
	// UI
	@FindBy(xpath = "//a[text()='Add your review']")
	private WebElement addYourReviewLink;
	@FindBy(id = "AddProductReview_Title")
	private WebElement reviewTitleTextbox;
	@FindBy(id ="AddProductReview_ReviewText")
	private WebElement reviewBodyTextArea;
	@FindBy(id = "addproductrating_4")
	private WebElement ratingCheckbox;
	@FindBy(name = "add-review")
	private WebElement addReviewButton;
	@FindBy(className = "result")
	private WebElement reviewSuccessMessage;
	//Action
	public ProductDetailPageFactory(WebDriver mappingDriver) {
		driver = mappingDriver;
		PageFactory.initElements(driver, this);
	}

	public void clickToAddYourReview() {
		waitForElementClickable(driver, addYourReviewLink);
		clickToElement(driver, addYourReviewLink);
	}

	public void inputToReviewTitleTextbox(String reviewTitle) {
		waitForElementVisible(driver, reviewTitleTextbox);
		sendkeyToElement(driver, reviewTitleTextbox, reviewTitle);
	}

	public void inputToReviewTextArea(String reviewBody) {
		waitForElementVisible(driver, reviewBodyTextArea);
		sendkeyToElement(driver, reviewBodyTextArea, reviewBody);
		
	}

	public void clickToRatingCheckbox() {
		waitForElementClickable(driver, ratingCheckbox);
		clickToElement(driver, ratingCheckbox);
		
	}

	public void clickToAddReviewButton() {
		waitForElementClickable(driver, addReviewButton);
		clickToElement(driver, addReviewButton);
		
	}

	public String getSuccessfulReviewMessage() {
		waitForElementVisible(driver, reviewSuccessMessage);
		return getElementText(driver, reviewSuccessMessage);
	}

}
