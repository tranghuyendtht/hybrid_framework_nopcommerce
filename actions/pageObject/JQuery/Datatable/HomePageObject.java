package pageObject.JQuery.Datatable;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.jQuery.dataTable.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPagingByPageNumber(String pageNumber) {
		waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_PAGE_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_PAGE_NUMBER, pageNumber);
	}

	public void enterToHeaderTextboxByTitle(String titleHeaderName, String value) {
		waitForElementVisible(driver, HomePageUI.TEXTBOX_SEARCH_BY_TITLE_HEADER, titleHeaderName);
		sendkeyToElement(driver, HomePageUI.TEXTBOX_SEARCH_BY_TITLE_HEADER, value, titleHeaderName);
		pressKeyToElement(driver, HomePageUI.TEXTBOX_SEARCH_BY_TITLE_HEADER, Keys.ENTER, titleHeaderName);
	}

	public boolean isPageNumberActived(String pageNumber) {
		waitForElementVisible(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_PAGE_NUMBER, pageNumber);
		return isElementDisplayed(driver, HomePageUI.PAGINATION_PAGE_ACTIVED_BY_PAGE_NUMBER, pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total Size = " + totalPage);
		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyệt qua từng page
		for (int i = 1; i <= totalPage; i++) {
			System.out.println(i);
			waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(i));
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(i));
			sleepInSecond(1);

			// Duyệt qua từng row để lấy các value và đưa vào arraylist
			List<WebElement> allRowEachPage = getElements(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowEachPage) {
				allRowValueAllPage.add(eachRow.getText());
				System.out.println("Text: " + eachRow.getText());
			}

		}

		// In các giá trị của các row tất cả page
		for (String value : allRowValueAllPage) {
			System.out.println("-----------------------");
			System.out.println(value);
		}

		return allRowValueAllPage;
	}

	public List<String> getValueColumnByTitleName(String titleName) {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total Size = " + totalPage);
		List<String> allRowValueAllPage = new ArrayList<String>();

		// Duyệt qua từng page
		for (int i = 1; i <= totalPage; i++) {
			waitForElementClickable(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(i));
			clickToElement(driver, HomePageUI.PAGINATION_PAGE_INDEX, String.valueOf(i));

			// Duyệt qua từng row để lấy các value và đưa vào arraylist
			List<WebElement> allRowEachPage = getElements(driver, HomePageUI.COLUMN_BY_TITLENAME, titleName);
			for (WebElement eachRow : allRowEachPage) {

				allRowValueAllPage.add(eachRow.getText());
				System.out.println(eachRow.getText());
			}

		}

		// In các giá trị của các row tất cả page
		for (String value : allRowValueAllPage) {

			System.out.println(value);
		}

		return allRowValueAllPage;
	}

	public void enterToTextboxAtRowNumberByColumnName(String columnName, String rowNumber, String inputValue) {
		waitForElementVisible(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber,
				String.valueOf(getColumnIndex(columnName)));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, inputValue, rowNumber,
				String.valueOf(getColumnIndex(columnName)));
		sleepInSecond(1);
	}

	public void selectDropdownByColumnNameAtRowNumber(String columnName, String rowNumber, String dataSelected) {
		waitForElementClickable(driver, HomePageUI.SELECT_DROPDOWN_BY_TITLENAME, rowNumber,
				String.valueOf(getColumnIndex(columnName)));
		selectItemInDefaultDropDown(driver, HomePageUI.SELECT_DROPDOWN_BY_TITLENAME, dataSelected, rowNumber,
				String.valueOf(getColumnIndex(columnName)));
		sleepInSecond(1);

	}

	public void checkToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_TITLENAME, rowNumber,
				String.valueOf(getColumnIndex(columnName)));
		checkToCheckboxORRadio(driver, HomePageUI.CHECKBOX_BY_TITLENAME, rowNumber, String.valueOf(getColumnIndex(columnName)));
		sleepInSecond(1);
	}
	public void uncheckToCheckboxByColumnNameAtRowNumber(String columnName, String rowNumber) {
		waitForElementClickable(driver, HomePageUI.CHECKBOX_BY_TITLENAME, rowNumber,
				String.valueOf(getColumnIndex(columnName)));
		uncheckToCheckbox(driver, HomePageUI.CHECKBOX_BY_TITLENAME, rowNumber, String.valueOf(getColumnIndex(columnName)));
		sleepInSecond(1);
	}
	
	public void enterToDatePickerAtRowNumberByColumnName(String columnName, String rowNumber, String inputValue) {
		waitForElementClickable(driver, HomePageUI.DATE_PICKER_BY_TITLE, rowNumber,
				String.valueOf(getColumnIndex(columnName)));
		sendkeyToElement(driver, HomePageUI.DATE_PICKER_BY_TITLE, inputValue, rowNumber,
				String.valueOf(getColumnIndex(columnName)));
		sleepInSecond(2);
	}
	public void clickToIconAtRowNumberAndIconName(String rowNumber, String iconName) {
		waitForElementClickable(driver, HomePageUI.ICON_ON_TABLE_BY_ROW_NUMBER_AND_BY_NAME, rowNumber, iconName);
		clickToElementByJS(driver, HomePageUI.ICON_ON_TABLE_BY_ROW_NUMBER_AND_BY_NAME, rowNumber, iconName);
		sleepInSecond(1);
	}

	private int getColumnIndex(String columnName) {
		int columnIndex;
		return columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_TITLENAME, columnName) + 1;
	}

}
