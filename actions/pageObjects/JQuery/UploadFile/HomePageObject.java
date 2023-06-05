package pageObjects.JQuery.UploadFile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.jQuery.uploadFile.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_LOADED, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_LOADED, fileName);
	}
	public void clickToStartButton() {
		List<WebElement> listStartButton = getElements(driver, HomePageUI.START_BUTTON);
		for (WebElement startButton : listStartButton) {
			startButton.click();
			sleepInSecond(5);
		}
	}
	public boolean isFileUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
		return isElementDisplayed(driver, HomePageUI.FILE_NAME_UPLOADED_LINK, fileName);
	}
	public boolean isImageUploadedByName(String fileName) {
		waitForElementVisible(driver, HomePageUI.FILE_NAME_UPLOADED_IMG, fileName);
		return isImageUpLoaded(driver, HomePageUI.FILE_NAME_UPLOADED_IMG, fileName);
	}
	
}
