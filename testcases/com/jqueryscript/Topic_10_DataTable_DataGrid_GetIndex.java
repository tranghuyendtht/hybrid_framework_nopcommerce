package com.jqueryscript;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.JQuery.Datatable.HomePageObject;
import pageObject.JQuery.Datatable.PageGeneratorManager;

public class Topic_10_DataTable_DataGrid_GetIndex extends BaseTest {

	WebDriver driver;
	HomePageObject homePage;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Enter_To_Textbox_At_Any_Row() {
		homePage.enterToTextboxAtRowNumberByColumnName("Company", "1", "Automation FC");
		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "1", "Ms Chun");
		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed", "1", "12");
		homePage.enterToTextboxAtRowNumberByColumnName("Company", "2", "Viettel");
		homePage.enterToTextboxAtRowNumberByColumnName("Contact Person", "2", "Mr Đa");
		homePage.enterToTextboxAtRowNumberByColumnName("Order Placed", "2", "12");
	}

	@Test
	public void TC_02_Select_To_Dropdown_At_Any_Row() {
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "1", "Japan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "2", "Taiwan");
		homePage.selectDropdownByColumnNameAtRowNumber("Country", "3", "Germany");
	}
	
	@Test
	public void TC_03_Check_UnCheck_To_Checkbox_At_Any_Row() {
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.uncheckToCheckboxByColumnNameAtRowNumber("NPO?", "1");
		homePage.checkToCheckboxByColumnNameAtRowNumber("NPO?", "2");
	}
	
	@Test
	public void TC_04_Enter_To_Date_Picker_At_Any_Row() {
		homePage.enterToDatePickerAtRowNumberByColumnName("Member Since", "1", "2023-05-31");
		homePage.enterToDatePickerAtRowNumberByColumnName("Member Since", "2", "2022-05-31");
		homePage.enterToDatePickerAtRowNumberByColumnName("Member Since", "3", "2021-05-29");
	}
	
	@Test
	public void TC_05_Click_To_Icon_At_Any_Row_By_Icon_Name() {
		homePage.clickToIconAtRowNumberAndIconName("1", "Remove Current Row");
	//	homePage.clickToIconAtRowNumberAndIconName("1", "Move Up");
	//	homePage.clickToIconAtRowNumberAndIconName("2", "Insert Row Above");
		homePage.clickToIconAtRowNumberAndIconName("2", "Move Up");
		
	}
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
