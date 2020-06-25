package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import browserfactory.BrowserFactory;
import pagefactory.Address;
import pagefactory.Index;
import pagefactory.Login;
import pagefactory.Payment;
import pagefactory.Shipping;
import pagefactory.Summary;

public class SanityTest {
	
	WebDriver driver = BrowserFactory.getBrowser();
	

	@Test(priority=1)
	public void sanityTest(){
		
		Login login = new Login(driver);
		login.loginApp("mgaur000@gmail.com", "ABC123");
		//driver.quit();
	}
	
	@Test(priority=2)
	public void addItemIntoCart(){
		Index index = new Index(driver);
		index.addItemIntoCart();
	}
	
	@Test(priority=3)
	public void SummaryProceedToCheckout(){
		Summary summary = new Summary(driver);
		summary.ClickOnProceedToCheckoutButton();
	}
	
	@Test(priority=4)
	public void commentandProceed(){
		Address address = new Address(driver);
		address.enterCommentsAndProceedToCheckout();
		
	}
	
	@Test(priority=5)
	public void checkBoxAndProceed(){
		Shipping shipping = new Shipping(driver);
		shipping.clickCheckBoxAndProceedToCheckout();
		
	}
	
	@Test(priority=6)
	public void ClickOnPayByBankWire(){
		Payment payment = new Payment(driver);
		payment.Click_PayByBankWireandCompareAmount();
		payment.printOrderDetails();
		
	}

}
