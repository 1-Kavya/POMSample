package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckOutPage;
import pages.LoginPage;
import pages.ProductListPage;

public class PlaceOrderTest {
	
	WebDriver driver;
	LoginPage loginPage;
	ProductListPage listPage;
	CartPage cartPage;
	CheckOutPage chkoutPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver);
		listPage = new ProductListPage(driver);
		cartPage = new CartPage(driver);
		chkoutPage = new CheckOutPage(driver);
	}
	
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://www.saucedemo.com/");
	}
	
	@Test
	public void validLoginTest() {
		loginPage.loginIntoApp("standard_user", "secret_sauce");
	
	}
	
	
	@Test(priority=1)
	public void addItemTest() {
		listPage.addItemToCart();
		listPage.viewCart();
		Assert.assertTrue(cartPage.isItemsAdded());
	}
	
	@Test(priority=2)
	public void checkoutItems() {
		cartPage.checkoutItems();
		chkoutPage.provideDetails("Test","User","22535");
		chkoutPage.ContinueCheckout();
		chkoutPage.FinishCheckout();
//		chkoutPage.CancelCheckout();
		Assert.assertTrue(chkoutPage.isOrderSuccess());
		
	}
	
	
	@AfterTest
	public void tearDown() {
		TestBase.teardown();
	}
}
