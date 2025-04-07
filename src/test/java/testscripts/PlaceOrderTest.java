package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class PlaceOrderTest {
	
	WebDriver driver;
	LoginPage loginPage;
	
	public PlaceOrderTest() {
		TestBase.initDriver();
		driver = TestBase.getDriver();
		loginPage = new LoginPage(driver);
	}
	
	@BeforeTest
	public void setup() {
		TestBase.openUrl("https://www.saucedemo.com/");
	}
	
	@Test
	public void validLogiTest() {
		loginPage.loginIntoApp("standard_user", "secret_sauce");
	
	}
	
}
