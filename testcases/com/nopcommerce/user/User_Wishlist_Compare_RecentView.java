package com.nopcommerce.user;


import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_Cookie;

import commons.BaseTest;
import pageObjects.nopcommerce.Admin.PageGeneratorManager;
import pageObjects.nopcommerce.User.UserComputerProductPageObject;
import pageObjects.nopcommerce.User.UserHomePageObject;
import pageObjects.nopcommerce.User.UserLoginPageObject;
import pageObjects.nopcommerce.User.UserProductDetailPageObject;
import pageObjects.nopcommerce.User.UserSearchKeywordPageObject;
import pageObjects.nopcommerce.User.UserWishListPageObject;

public class User_Wishlist_Compare_RecentView extends BaseTest {

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserLoginPageObject userLoginPage;
	UserComputerProductPageObject userComputerProductPage;
	UserSearchKeywordPageObject userSearchKeywordPage;
	UserProductDetailPageObject userProductDetailPage;
	UserWishListPageObject userWishListPage;
	
	String productNotebooksUrl;
	String keyword, skuProduct, priceProduct;
	int quantityProduct;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		productNotebooksUrl = "https://demo.nopcommerce.com/notebooks";
		keyword = "Lenovo IdeaCentre 600 All-in-One PC";
		quantityProduct = 1;

		log.info("Pre-Condition - Step 01: Go to Login page ");
		userLoginPage = userHomePage.openLoginPage();

		log.info("Pre-Condition - Step 02: Login page ");
		userLoginPage.setCookies(driver, Common_01_Register_Cookie.loggedCookies);

		log.info("Pre-Condition - Step 03: Refresh page ");
		userLoginPage.refreshPage(driver);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Pre-Condition - Step 04: Verify login successfully ");
		verifyTrue(userHomePage.isMyAccountLinkIsDisplay());

		log.info("Pre-Condition - Step 05: Search product on 'Search' textbox");
		userHomePage.inputKeywordToSearchTextbox(keyword);
		
		log.info("Pre-Condition - Step 06: Click to 'Search' textbox");
		userSearchKeywordPage = userHomePage.clickToSearchButton();
		
		log.info("Pre-Condition - Step 06: Click to prroduct");
		userProductDetailPage = userSearchKeywordPage.clickToProductTitle(keyword);
		skuProduct = userProductDetailPage.getSKUProduct();
		priceProduct = userProductDetailPage.getPriceProduct();
	}

	@Test
	public void TC_01_Add_To_Wishlist() {
		
		log.info("Add_To_Wishlist - Step 01: Click to 'Add to Wishlist' button");
		
		userProductDetailPage.clickToAddToWishlistButton();
		
		log.info("Add_To_Wishlist - Step 01: Verify success message 'The product has been added to your wishlist' is displayed");
		
		verifyEquals(userProductDetailPage.isSuccessMessageDisplayed(),"The product has been added to your wishlist");
		
		
		log.info("Add_To_Wishlist - Step 01: Click to 'Wishlist' linktext");
		userWishListPage = userProductDetailPage.clickToWishlistLinkText();
		
		
		log.info("Add_To_Wishlist - Step 01: Verify added product in wishlist page");
		verifyTrue(userWishListPage.isSKUProductAddedOnWishlistPage(skuProduct));
		verifyTrue(userWishListPage.isImageDisplayed());
		verifyTrue(userWishListPage.isProductNameAddedOnWishlistPage(keyword));
		verifyTrue(userWishListPage.isProductPriceAddedOnWishlistPage(priceProduct));
		verifyTrue(userWishListPage.isProductQuantityAddedOnWishlistPage(quantityProduct));
		verifyTrue(userWishListPage.isProductTotalAddedOnWishlistPage(priceProduct));
		
		log.info("Add_To_Wishlist - Step 01: View wishlist from URL sharing by click Url");
		userWishListPage.clickToUrlSharing();
		
		log.info("Add_To_Wishlist - Step 01: Verify added product in wishlist page");
		verifyTrue(userWishListPage.isSKUProductAddedOnWishlistPage(skuProduct));
		verifyTrue(userWishListPage.isImageDisplayed());
		verifyTrue(userWishListPage.isProductNameAddedOnWishlistPage(keyword));
		verifyTrue(userWishListPage.isProductPriceAddedOnWishlistPage(priceProduct));
		verifyTrue(userWishListPage.isProductQuantityAddedOnWishlistOfPage(quantityProduct));
		verifyTrue(userWishListPage.isProductTotalAddedOnWishlistPage(priceProduct));
		
		
		
	}

	//@Test
	public void TC_02_Add_Product_To_Cart_From_Wishlist_Page() {
		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Click to checkbox on product");
		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Click to 'Add to cart' button form wishlist page");
		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Verify product in shopping cart");
		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Click to 'Wishlist' linktext on footer");
		log.info("Add_Product_To_Cart_From_Wishlist_Page - Step 01: Verify product is removed from wishlist page");
		
	}

	//@Test
	public void TC_03_Remove_Product_In_Wishlist_Page() {
	}
	//@Test
	public void TC_04_Add_Product_To_Compare() {

	}

	@Test
	public void TC_05_Recently_Viewed_Product() {

	}

	@Test
	public void TC_06_Display_6_Products() {
	}
	@Test
	public void TC_07_Display_9_Products() {
		
	}


	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
