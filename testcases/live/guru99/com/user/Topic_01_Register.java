package live.guru99.com.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageUIs.liveGuru.admin.AdminCustomerPageUI;
import commons.BaseTest;
import commons.GlobalConstantsLiveGuru;
import pageObjects.liveguru99.Admin.AdminCustomerPageObject;
import pageObjects.liveguru99.Admin.AdminLoginPageObject;
import pageObjects.liveguru99.User.PageGeneratorManager;
import pageObjects.liveguru99.User.UserAccountDashboardPageObject;
import pageObjects.liveguru99.User.UserHomePageObject;
import pageObjects.liveguru99.User.UserRegisterPageObject;

public class Topic_01_Register extends BaseTest {

	WebDriver driver;
	UserHomePageObject userHomePage;
	UserRegisterPageObject userRegisterPage;
	UserAccountDashboardPageObject userAccountDashboardPage;
	AdminLoginPageObject adminLoginPage;
	AdminCustomerPageObject adminCustomerPage;
	String firstName, lastName, emailAdd, password;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		userHomePage = PageGeneratorManager.getUserHomePage(driver);
		firstName = "lulu";
		lastName = "lala";
		emailAdd = "lululala" + fakeNumber() + "@mail.com";
		password = "123456@Lululala";
	}

	@Test
	public void TC_01_Register_User() {

		// Register at user role
		userHomePage.clickToAccountLink();
		userRegisterPage = userHomePage.clickToRegisterLink();
		userAccountDashboardPage = userRegisterPage.enterDataToRegister(firstName, lastName, emailAdd, password);
		Assert.assertTrue(userAccountDashboardPage.getSuccessMessage(),
				"Thank you for registering with Main Website Store.");

		userHomePage.clickToAccountLink();
		userHomePage.clickToLogOutLink();

		// Login with account by user role
		userHomePage.clickToAccountLink();
		userHomePage.clickToLoginLink();
		userAccountDashboardPage = userHomePage.enterToLoginForm(emailAdd, password);
		Assert.assertTrue(userAccountDashboardPage.getWelcomeToDashboardPage(), "My Dashboard");

		// Logout by user role
		userHomePage.clickToAccountLink();
		userHomePage.clickToLogOutLink();

		// Login by admin role to check info
		userHomePage.openPageUrl(driver, GlobalConstantsLiveGuru.ADMIN_PAGE_URL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		adminCustomerPage = adminLoginPage.loginAsAdmin(GlobalConstantsLiveGuru.ADMIN_USERNAME_TO_LOGIN_ACCOUNT,
				GlobalConstantsLiveGuru.ADMIN_PASSWORD_TO_LOGIN_ACCOUNT);
		
		adminCustomerPage.closePopupIncomeMessage();
		Assert.assertTrue(adminCustomerPage.isManageCustomerTextHeaderDisplayed());
		
		adminCustomerPage.inputToEmailTextbox(emailAdd);
		Assert.assertEquals(adminCustomerPage.getTotalRecordsFound(),1);
		Assert.assertTrue(adminCustomerPage.getSearchResult().contains(firstName + " " +lastName));
		Assert.assertTrue(adminCustomerPage.getSearchResult().contains(emailAdd));
		
	

	}

	@AfterClass
	public void afterClass() {

	}
}
