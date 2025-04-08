package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage {
	
	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	WebElement itemOne;

	@FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
	WebElement itemTwo;
	
	@FindBy(className = "shopping_cart_link")
	WebElement cartBtn;
	
	public ProductListPage(WebDriver driver)  {
		PageFactory.initElements(driver, this);
	}
	
	
	//Add to cart
	//view cart
	
	public void addItemToCart() {
		itemOne.click();
		itemTwo.click();
	}
	
	public void viewCart() {
		cartBtn.click();
	}
	

}
