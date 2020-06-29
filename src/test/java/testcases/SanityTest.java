package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import browserfactory.BrowserFactory;
import pagefactory.Index;
import pagefactory.Login;
import reportutil.ExtenReport;
import testBase.TestBase;

public class SanityTest extends TestBase{
	
	WebDriver driver = BrowserFactory.getBrowser();
	ExtentTest test = null;
	Logger log = Logger.getLogger(SanityTest.class);

	@Test(priority=1)
	public void sanityTest(){
		test = ExtenReport.getExtentTest(new Object(){}.getClass().getEnclosingMethod().getName());
		Login login = new Login(driver,test);
		login.loginApp("mgaur000@gmail.com", "ABC123");
		test.log(Status.PASS, "Login Successful");
		log.info("Login test case executed successfully");
	}
	
	@Test(priority=2)
	public void addItemIntoCart(){
		test = ExtenReport.getExtentTest(new Object(){}.getClass().getEnclosingMethod().getName());
		Index index = new Index(driver,test);
		index.addItemIntoCart();
		test.log(Status.PASS, "Item added to cart Successfully");
		log.info("Item added to cart Successfully");
	}
	/*
	@Test(priority=3)
	public void SummaryProceedToCheckout(){
		test = ExtenReport.getExtentTest(new Object(){}.getClass().getEnclosingMethod().getName());
		Summary summary = new Summary(driver);
		summary.ClickOnProceedToCheckoutButton();
	}
	
	@Test(priority=4)
	public void commentandProceed(){
		test = ExtenReport.getExtentTest(new Object(){}.getClass().getEnclosingMethod().getName());
		Address address = new Address(driver);
		address.enterCommentsAndProceedToCheckout();
		
	}
	
	@Test(priority=5)
	public void checkBoxAndProceed(){
		test = ExtenReport.getExtentTest(new Object(){}.getClass().getEnclosingMethod().getName());
		Shipping shipping = new Shipping(driver);
		shipping.clickCheckBoxAndProceedToCheckout();
		
	}
	
	@Test(priority=6)
	public void ClickOnPayByBankWire(){
		test = ExtenReport.getExtentTest(new Object(){}.getClass().getEnclosingMethod().getName());
		Payment payment = new Payment(driver);
		payment.Click_PayByBankWireandCompareAmount();
		payment.printOrderDetails();
		
	}
*/
	@AfterTest
	public void tearDown(){
		ExtenReport.writeReport();
		driver.close();
	}
}
