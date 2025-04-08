package testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;

public class LoginSuccess {
	
	WebDriver driver;
	LoginPage loginPage;
	
	public LoginSuccess() {
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
	

//	@Test
//	public void validLogiTest() {
//		loginPage.loginIntoApp("problem_user", "secret_sauce");
//	
//	}
	

}
